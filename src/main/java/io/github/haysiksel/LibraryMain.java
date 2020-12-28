package io.github.haysiksel;

import lombok.Getter;

import org.bukkit.plugin.java.JavaPlugin;

public class LibraryMain extends JavaPlugin {

    @Getter private static LibraryMain instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}