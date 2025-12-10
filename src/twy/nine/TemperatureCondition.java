package twy.nine;
// 温度条件策略实现
public class TemperatureCondition implements RuleCondition {
    private int threshold;
    private String operator;

    public TemperatureCondition(String operator, int threshold) {
        this.operator = operator;
        this.threshold = threshold;
    }

    @Override
    public boolean match(SmartDevice device) {
        if (!device.getType().equals("AIR_CONDITIONER")) return false;
        int currentTemp = (int) device.getProperties().get("temperature");
        return operator.equals(">") ? currentTemp > threshold : currentTemp < threshold;
    }
}