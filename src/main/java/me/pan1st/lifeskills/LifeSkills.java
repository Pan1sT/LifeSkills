package me.pan1st.lifeskills;

import lombok.Getter;
import me.pan1st.lifeskills.player.ProfileListener;
import me.pan1st.lifeskills.skills.SkillsListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public final class LifeSkills extends JavaPlugin {

    @Getter public static LifeSkills instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        Arrays.asList(new ProfileListener(),
                new SkillsListener()).forEach(listener -> getServer().getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
