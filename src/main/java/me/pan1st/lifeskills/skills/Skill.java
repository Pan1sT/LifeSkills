package me.pan1st.lifeskills.skills;

import lombok.Getter;
import me.pan1st.lifeskills.SkillsType;
import org.bukkit.event.Event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Skill {

    private final List<Integer> requiredEXP = Arrays.asList(50, 125, 200, 300, 500, 750, 1000, 1500, 2000, 3500, 5000, 7500, 10000, 15000, 20000, 30000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 600000, 700000, 800000, 900000, 1000000, 1100000, 1200000, 1300000, 1400000, 1500000, 1600000, 1700000, 1800000, 1900000, 2000000, 2100000, 2200000, 2300000, 2400000, 2500000, 2600000, 2750000, 2900000, 3100000, 3400000, 3700000, 4000000);
    @Getter private int currentEXP;

    public Skill(int currentEXP) {
        this.currentEXP = currentEXP;
    }

    public abstract SkillsType getSkillsType();

    public abstract void handleEvent(Event event);

    public void addEXP(int exp){
        this.currentEXP += exp;
    }


}
