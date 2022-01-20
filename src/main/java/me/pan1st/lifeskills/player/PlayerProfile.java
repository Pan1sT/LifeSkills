package me.pan1st.lifeskills.player;

import lombok.Getter;
import me.pan1st.lifeskills.SkillsType;
import me.pan1st.lifeskills.skills.Skill;
import me.pan1st.lifeskills.skills.impl.SkillGathering;

import java.util.*;

public class PlayerProfile {

    @Getter private final UUID uuid;

    private static Map<UUID, PlayerProfile> profiles = new HashMap<>();
    private List<Skill> skills = new ArrayList<>();

    public PlayerProfile(UUID uuid){
        this.uuid = uuid;
        skills.add(new SkillGathering(0));
    }

    public static PlayerProfile getProfile(UUID uuid){
        if (profiles.containsKey(uuid)){
            return profiles.get(uuid);
        }else{
            PlayerProfile profile = new PlayerProfile(uuid);
            profiles.put(uuid, profile);
            return profile;
        }
    }

    public Skill getSkillBySkillsType(SkillsType skillsType){
        return skills.stream().filter(skill -> skill.getSkillsType() == skillsType).findFirst().orElse(null);
    }

}
