package me.pan1st.lifeskills.skills;

import me.pan1st.lifeskills.SkillsType;
import me.pan1st.lifeskills.player.PlayerProfile;
import me.pan1st.lifeskills.skills.impl.SkillHunting;
import me.pan1st.lifeskills.utils.BlockUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.EntityDeathEvent;

public class SkillsListener implements Listener {

    // Gathering

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (BlockUtil.isPlayerPlaced(e.getBlock())) {
            BlockUtil.removePlayerPlaced(e.getBlock());
            e.getPlayer().sendMessage("This block is fucking placed by player : D");
            return;
        }
        PlayerProfile profile = PlayerProfile.getProfile(e.getPlayer().getUniqueId());
        profile.getSkillBySkillsType(SkillsType.GATHERING).handleEvent(e);
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        BlockUtil.addPlayerPlaced(e.getBlock());
    }

    @EventHandler
    public void onPiston(BlockPistonExtendEvent e) {
        if (e.getBlock().getType() == Material.PISTON) {
            e.getBlocks().forEach(block -> {
                if (!BlockUtil.isPlayerPlaced(block)) return;
                if (block.getRelative(e.getDirection().getOppositeFace()).equals(e.getBlock())) {
                    BlockUtil.removePlayerPlaced(block);
                    BlockUtil.addPlayerPlaced(block.getRelative(e.getDirection()));
                } else {
                    BlockUtil.addPlayerPlaced(block.getRelative(e.getDirection()));
                }
            });
        } else if (e.getBlock().getType() == Material.STICKY_PISTON) {
            e.getBlocks().forEach(block -> {
                if (!BlockUtil.isPlayerPlaced(block)) return;
                if (block.getRelative(e.getDirection().getOppositeFace()).equals(e.getBlock())) return;
                BlockUtil.removePlayerPlaced(block);
                BlockUtil.addPlayerPlaced(block.getRelative(e.getDirection()));
            });
        }
    }

    // Hunting

    @EventHandler
    public void onKill(EntityDeathEvent e){
        if (e.getEntity().getKiller() == null) return;
        Bukkit.broadcastMessage("123");
        PlayerProfile profile = PlayerProfile.getProfile(e.getEntity().getKiller().getUniqueId());
        profile.getSkillBySkillsType(SkillsType.HUNTING).handleEvent(e);
    }

}
