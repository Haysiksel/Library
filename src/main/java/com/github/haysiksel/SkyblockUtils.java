package com.github.haysiksel;

import lombok.experimental.UtilityClass;

import org.bukkit.ChatColor;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;

import java.util.Collection;
import java.util.stream.Collectors;

@UtilityClass
public class SkyblockUtils {

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    @NotNull
    public String colored(@NotNull String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    @NotNull
    public Collection<String> colored(@NotNull Collection<String> list) {
        return list.stream().map(SkyblockUtils::colored).collect(Collectors.toList());
    }

    @NotNull
    public String formatDouble(double input) {
        return decimalFormat.format(input);
    }
}