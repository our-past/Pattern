package equipment_fyk.autoRule_twy;

import equipment_fyk.Equipment;


// 规则条件策略接口（策略模式）
public interface RuleCondition {
    boolean match(Equipment device);
}