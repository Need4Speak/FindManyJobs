package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.concurrent.ExecutionException;

public class JedisDemo1 {
    /**
     * 普通方式
     */
   public static void connect1() {
       // 1. 设置 IP, 端口与与密码
       Jedis jedis = new Jedis("120.79.158.194", 6379);
       jedis.auth("Zc-12332145");
       // 2. 保存数据
       jedis.set("name", "chao");
       // 3. 获取数据
       String value = jedis.get("name");
       System.out.println(value);
       // 4. 释放连接
       jedis.close();
   }

    /**
     * 连接池方式
     */
    public static void connect2() {
        // 1.获取连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        // 2. 设置最大连接数
        config.setMaxTotal(30);
        // 3. 设置最大空闲连接数
        config.setMaxIdle(10);

        // 4. 获得连接池
        JedisPool jedisPool = new JedisPool(config, "120.79.158.194", 6379);

        // 5. 获得核心对象
        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.auth("Zc-12332145");

            // 保存数据
            jedis.set("name", "tom");
            // 获取数据
            String value = jedis.get("name");
            System.out.println(value);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 释放资源
            if (jedis != null) {
                jedis.close();
            }
            if (jedisPool != null) {
                jedisPool.close();
            }
        }

    }

    public static void main(String[] args) {
        connect1();
        connect2();
    }
}
