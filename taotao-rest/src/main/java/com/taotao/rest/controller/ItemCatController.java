package com.taotao.rest.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.utils.ExceptionUtil;
import com.taotao.common.utils.JsonUtils;
import com.taotao.common.utils.TaotaoResult;
import com.taotao.rest.entity.ItemCatResult;
import com.taotao.rest.service.ItemCatService;

@Controller
@RequestMapping("/item/cat")
public class ItemCatController {

	@Autowired
	private ItemCatService itemCatService;
	
	/*@RequestMapping(value="/list",produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemCatList(String callback) {
		ItemCatResult result = itemCatService.getItemCatList();
		if (StringUtils.isBlank(callback)) {
			//需要把result转换成字符串
			String json = JsonUtils.objectToJson(result);
			return json;
		}
		//如果字符串不为空，需要支持jsonp调用
		//需要把result转换成字符串
		String json = JsonUtils.objectToJson(result);
		return callback + "(" + json + ");";
	}*/
	//第二种方法
		@RequestMapping(value="/list")
		@ResponseBody
		public Object getItemCatList(String callback) {
			ItemCatResult result = itemCatService.getItemCatList();
			if (StringUtils.isBlank(callback)) {
				//需要把result转换成字符串
				return result;
			}
			//如果字符串不为空，需要支持jsonp调用
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(result);
			mappingJacksonValue.setJsonpFunction(callback);
			return mappingJacksonValue;
		}
		// 后台修改了parentId对应的内容后应该进行的操作
		@RequestMapping("/sync/{parentId}")
		@ResponseBody
		public TaotaoResult sysncContent(@PathVariable Long parentId) {
			try {
				TaotaoResult result = itemCatService.syncContent(parentId);
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				return TaotaoResult.build(500, ExceptionUtil.getStackTrace(e));
			}
		}
}

