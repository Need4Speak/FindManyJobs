package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class RedisSub extends JedisPubSub{
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("channel: " + channel + " 发布消息： " + message);
    }

    public static void main(String[] args) {
        // 1. 设置 IP, 端口与与密码
        Jedis jedis = new Jedis("120.79.158.194", 6379);
        jedis.auth("Zc-12332145");
        // 2. 创建 JedisPubSub 对象
        RedisSub redisSub = new RedisSub();
        //3. 从 redis 消息 channel 中订阅消息
        jedis.subscribe(redisSub, "mychannel");
    }
}
