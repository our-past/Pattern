package twy.nine;
// 规则条件策略接口（策略模式）
public interface RuleCondition {
    boolean match(SmartDevice device);
}