package me.pan1st.lifeskills.player;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ProfileListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        PlayerProfile profile = PlayerProfile.getProfile(e.getPlayer().getUniqueId());
    }

}
