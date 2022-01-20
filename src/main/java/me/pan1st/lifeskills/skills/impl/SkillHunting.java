package me.pan1st.lifeskills.skills.impl;

import me.pan1st.lifeskills.SkillsType;
import me.pan1st.lifeskills.skills.Skill;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class SkillHunting extends Skill {
    public SkillHunting(int currentEXP) {
        super(currentEXP);
    }

    @Override
    public SkillsType getSkillsType() {
        return SkillsType.HUNTING;
    }

    @Override
    public void handleEvent(Event event) {
        if (event instanceof EntityDeathEvent e){
            if (e.getEntity().getKiller() == null) return;
            Player p = (Player) e.getEntity().getKiller();
            addEXP(10);
            p.sendMessage("Current EXP : " + getCurrentEXP());
        }
    }


}
