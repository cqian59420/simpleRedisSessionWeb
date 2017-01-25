package service;

import redis.clients.jedis.Jedis;

/**
 * Created by cq on 2017/1/24.
 */
public class RedisServer {

    private static Jedis jedis = new Jedis("localhost");

    public static Jedis getJedis() {
        return jedis;
    }
}
