package equipment_fyk.autoRule;


import equipment_fyk.Equipment;

// 规则动作策略接口（策略模式）
public interface RuleAction {
    void execute(Equipment device);
}