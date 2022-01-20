package me.pan1st.lifeskills;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum SkillsType {

    FARMING("耕種", Arrays.asList("")),
    GATHERING("採集", Arrays.asList("")),
    FISHING("釣魚", Arrays.asList("")),
    HUNTING("狩獵", Arrays.asList("")),
    COOKING("料理", Arrays.asList("")),
    ALCHEMY("煉金", Arrays.asList("")),
    PROCESSING("加工", Arrays.asList("")),
    TAMING("馴養", Arrays.asList("")),
    TRADING("交易", Arrays.asList("")),
    EXPLORING("探索", Arrays.asList(""));

    private final String name;
    private final List<String> description;

}
