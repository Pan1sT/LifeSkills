package me.pan1st.lifeskills.skills.impl;

import me.pan1st.lifeskills.SkillsType;
import me.pan1st.lifeskills.skills.Skill;
import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.block.BlockBreakEvent;

public class SkillGathering extends Skill {

    public SkillGathering(int currentEXP) {
        super(currentEXP);
    }

    @Override
    public SkillsType getSkillsType() {
        return SkillsType.GATHERING;
    }

    @Override
    public void handleEvent(Event event) {
        if (event instanceof BlockBreakEvent e){
            Material blockType = e.getBlock().getType();
            if (blockType.name().contains("_ORE")){
                addEXP(10);
            }else if(blockType.name().contains("_LOG")){
                addEXP(5);
            }else{
                addEXP(1);
            }
            e.getPlayer().sendMessage("Current EXP : " + getCurrentEXP());
        }
    }


}
