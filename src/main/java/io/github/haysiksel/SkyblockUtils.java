package io.github.haysiksel;

import lombok.experimental.UtilityClass;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class SkyblockUtils {

    public String colored(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public List<String> colored(List<String> list) {
        return list.stream().map(SkyblockUtils::colored).collect(Collectors.toList());
    }
}