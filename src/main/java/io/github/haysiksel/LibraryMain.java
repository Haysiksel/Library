package io.github.haysiksel;

import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class LibraryMain extends JavaPlugin {

    @Getter private static LibraryMain instance;

    private RedisHandler redisHandler;
    private MongoHandler mongoHandler;

    @Override
    public void onEnable() {
        instance = this;
        if (getConfig().getBoolean("database.redis.enabled")) this.redisHandler = new RedisHandler();
        if (getConfig().getBoolean("database.mongo-db.enabled")) this.mongoHandler = new MongoHandler();
    }

    @Override
    public void onDisable() {
        instance = null;
        if (getConfig().getBoolean("database.redis.enabled")) redisHandler.shutdown();
        if (getConfig().getBoolean("database.mongo-db.enabled")) mongoHandler.shutdown();
    }
}