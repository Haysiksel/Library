package com.github.haysiksel;

import lombok.experimental.UtilityClass;

import org.bukkit.Bukkit;
import org.bukkit.Location;

import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@UtilityClass
public class LocationSerialization {

    @NotNull
    public String serializeLocation(@NotNull Location loc) {
        return loc.getWorld().getName()
                + ":" + loc.getX()
                + ":" + loc.getY()
                + ":" + loc.getZ()
                + ":" + loc.getYaw()
                + ":" + loc.getPitch();
    }

    @NotNull
    public Optional<Location> deserializeLocation(@NotNull String str) {
        String[] parts = str.trim().split(":");
        if (parts.length == 6) {
            return Optional.of(new Location(
                    Bukkit.getWorld(parts[0]),
                    Double.parseDouble(parts[1]),
                    Double.parseDouble(parts[2]),
                    Double.parseDouble(parts[3]),
                    Float.parseFloat(parts[4]),
                    Float.parseFloat(parts[5])
            ));
        }
        return Optional.empty();
    }
}