package com.github.haysiksel;

import org.jetbrains.annotations.NotNull;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisHandler implements DatabaseHandler<JedisPool> {

    private JedisPool jedisPool;

    public RedisHandler() {
        if (LibraryMain.getInstance().getConfig().getBoolean("database.redis.auth.enabled")) {
            this.jedisPool = new JedisPool(new JedisPoolConfig(),
                    LibraryMain.getInstance().getConfig().getString("database.redis.ip"),
                    LibraryMain.getInstance().getConfig().getInt("database.redis.port"),
                    0,
                    LibraryMain.getInstance().getConfig().getString("database.redis.auth.password"));
        } else {
            this.jedisPool = new JedisPool(new JedisPoolConfig(),
                    LibraryMain.getInstance().getConfig().getString("database.redis.ip"),
                    LibraryMain.getInstance().getConfig().getInt("database.redis.port"),
                    0);
        }
    }

    @Override
    public @NotNull JedisPool get() {
        return jedisPool;
    }

    @Override
    public boolean isConnected() {
        return jedisPool.isClosed();
    }

    @Override
    public @NotNull String getName() {
        return "Redis Database";
    }

    @Override
    public void shutdown() {
        jedisPool.close();
    }
}
