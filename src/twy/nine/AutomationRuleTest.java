package twy.nine;
import java.time.LocalTime;

// 自动化规则测试主类
public class AutomationRuleTest {
    public static void main(String[] args) {
        // 1. 创建设备
        SmartDevice livingRoomAc = new AirConditioner("客厅空调");
        SmartDevice livingRoomCurtain = new Curtain("客厅窗帘");

        // 2. 初始化规则管理器
        AutomationRuleManager ruleManager = new AutomationRuleManager();
        ruleManager.registerDevice(livingRoomAc);
        ruleManager.registerDevice(livingRoomCurtain);

        // 3. 添加规则1：温度>28℃自动开空调
        RuleCondition tempCondition = new TemperatureCondition(">", 28);
        RuleAction acOnAction = new DeviceControlAction("TURN_ON");
        ruleManager.addRule(tempCondition, acOnAction);

        // 模拟温度升高到30℃
        livingRoomAc.getProperties().put("temperature", 30);
        System.out.println("=== 检查温度规则 ===");
        ruleManager.checkRules();

        // 4. 添加规则2：晚上8点自动关窗帘
        RuleCondition timeCondition = new TimeCondition(LocalTime.of(20, 0));
        RuleAction curtainCloseAction = new DeviceControlAction("CLOSE");
        ruleManager.addRule(timeCondition, curtainCloseAction);

        System.out.println("\n=== 检查时间规则 ===");
        ruleManager.checkRules();
    }
}