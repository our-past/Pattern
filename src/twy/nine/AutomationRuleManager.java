package twy.nine;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

// 自动化规则管理器（观察者模式核心）
public class AutomationRuleManager {
    private List<SmartDevice> observedDevices = new ArrayList<>();
    private Map<RuleCondition, RuleAction> ruleMap = new HashMap<>();

    // 注册设备（添加观察者）
    public void registerDevice(SmartDevice device) {
        observedDevices.add(device);
    }

    // 添加规则（条件+动作）
    public void addRule(RuleCondition condition, RuleAction action) {
        ruleMap.put(condition, action);
    }

    // 检查并执行规则（观察者响应）
    public void checkRules() {
        for (SmartDevice device : observedDevices) {
            for (Map.Entry<RuleCondition, RuleAction> entry : ruleMap.entrySet()) {
                if (entry.getKey().match(device)) {
                    entry.getValue().execute(device);
                }
            }
        }
    }
}