package com.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;

import com.common.util.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisCache implements Cache{

	private String id;
	
	private Jedis redisClient=createClient();
	
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	
	public Jedis getRedisClient() {
		return redisClient;
	}

	public void setRedisClient(Jedis redisClient) {
		this.redisClient = redisClient;
	}

	public RedisCache(final String id){
		this.id = id;
	}
	
	public String getId() {
		return this.id;
	}

	public void putObject(Object key, Object value) {
		redisClient.set(SerializeUtil.serialize(key), SerializeUtil.serialize(value));
	}

	public Object getObject(Object key) {
		Object object = SerializeUtil.unserialize(redisClient.get(SerializeUtil.serialize(key)));
		return object;
	}

	public Object removeObject(Object key) {
		return redisClient.del(SerializeUtil.serialize(key));
	}

	public void clear() {
		redisClient.flushDB();
	}

	public int getSize() {
		return Integer.valueOf(redisClient.dbSize().toString());
	}

	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}
	
	  protected static Jedis createClient() {
	        try {
	            JedisPool pool = new JedisPool(new JedisPoolConfig(),
	                    "localhost");
	            return pool.getResource();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        throw new RuntimeException("初始化连接池错误");
	    }

}
