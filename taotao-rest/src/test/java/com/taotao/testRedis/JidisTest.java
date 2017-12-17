package com.taotao.testRedis;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

public class JidisTest {
	// 连接的是centos7：成功
	@Test
	public void testJedisCluster() throws Exception {
		//创建一个JedisCluster对象
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("192.168.25.129", 7001));
		nodes.add(new HostAndPort("192.168.25.129", 7002));
		nodes.add(new HostAndPort("192.168.25.129", 7003));
		nodes.add(new HostAndPort("192.168.25.129", 7004));
		nodes.add(new HostAndPort("192.168.25.129", 7005));
		nodes.add(new HostAndPort("192.168.25.129", 7006));
		//在nodes中指定每个节点的地址
		//jedisCluster在系统中是单例的。
		JedisCluster jedisCluster = new JedisCluster(nodes);
		/*jedisCluster.set("name", "zhangsan");
		jedisCluster.set("value", "100");*/
		String name = jedisCluster.get("name");
		String value = jedisCluster.get("value");
		System.out.println(name);
		System.out.println(value);
		
		
		//系统关闭时关闭jedisCluster
		jedisCluster.close();
	}
	
	// 连接centos6.5：失败（redis.clients.jedis.exceptions.JedisNoReachableClusterNodeException: No reachable node in cluster）
	@Test
	public void testJedisCluster2() throws Exception {
		//创建一个JedisCluster对象
		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
		nodes.add(new HostAndPort("127.0.0.1", 8001));
		nodes.add(new HostAndPort("127.0.0.1", 8002));
		nodes.add(new HostAndPort("127.0.0.1", 8003));
		nodes.add(new HostAndPort("127.0.0.1", 8004));
		nodes.add(new HostAndPort("127.0.0.1", 8005));
		nodes.add(new HostAndPort("127.0.0.1", 8006));
		//在nodes中指定每个节点的地址
		//jedisCluster在系统中是单例的。
		JedisCluster jedisCluster = new JedisCluster(nodes);
		jedisCluster.set("name", "zhangsan");
		jedisCluster.set("value", "100");
		String name = jedisCluster.get("name");
		String value = jedisCluster.get("value");
		System.out.println(name);
		System.out.println(value);
		
		
		//系统关闭时关闭jedisCluster
		jedisCluster.close();
	}
	
	//单机版测试
		@Test
		public void testJedisSingle() throws Exception {
			//创建一个Jedis对象
			Jedis jedis = new Jedis("192.168.25.129", 6379);
			// jedis.set("test", "hello jedis");
			String string = jedis.get("test");
			System.out.println(string);
			jedis.close();
		}
		//使用连接池
		@Test
		public void testJedisPool() throws Exception {
			//创建一个连接池对象
			//系统中应该是单例的。
			JedisPool jedisPool = new JedisPool("192.168.25.129", 6379);
			//从连接池中获得一个连接
			Jedis jedis = jedisPool.getResource();
			String result = jedis.get("test");
			System.out.println(result);
			//jedis必须关闭
			jedis.close();
			
			//系统关闭时关闭连接池
			jedisPool.close();
			
		}

}
