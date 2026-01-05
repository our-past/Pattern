package equipment_fyk.autoRule_twy;

import equipment_fyk.Equipment;

public class rule {
    private RuleAction action;
    private RuleCondition condition;
    public rule(RuleAction action,RuleCondition condition){
        this.action = action;
        this.condition = condition;
    }
    /**
     * 检查规则是否匹配
     * @param device 智能设备
     * @return 是否匹配
     */
    public boolean match(Equipment device){
        return condition.match(device);
    }
    /**
     * 执行规则动作
     * @param device 智能设备
     */
    public void execute(Equipment device){
        action.execute(device);
    }
    public RuleAction getAction(){
        return action;
    }
    public RuleCondition getCondition(){
        return condition;
    }
}
