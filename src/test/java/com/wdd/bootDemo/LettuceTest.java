package com.wdd.bootDemo;

import io.lettuce.core.RedisURI;
import io.lettuce.core.api.sync.RedisCommands;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.RedisClusterURIUtil;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import io.lettuce.core.cluster.api.async.RedisAdvancedClusterAsyncCommands;
import io.lettuce.core.cluster.api.reactive.RedisAdvancedClusterReactiveCommands;
import io.lettuce.core.cluster.api.sync.RedisAdvancedClusterCommands;

/**
 * @Description LettuceTest
 * @Author weidongdong
 * @Date 2020/5/18 10:46
 * @Version 1.0
 */
public class LettuceTest {
    public static void main(String[] args) {
        RedisURI uri = RedisURI.builder().withHost("127.0.0.1").withPort(6379).build();
        RedisClusterClient clusterClient = RedisClusterClient.create(uri);

        StatefulRedisClusterConnection<String, String> connect = clusterClient.connect();

        RedisAdvancedClusterCommands<String, String> redisCommands = connect.sync();

       String name = redisCommands.get("spring");

        System.out.println(name);


    }
}
