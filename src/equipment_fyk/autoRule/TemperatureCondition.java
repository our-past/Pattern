package equipment_fyk.autoRule;

import equipment_fyk.Equipment;

// 温度条件策略实现
public class TemperatureCondition implements RuleCondition {
    private Double threshold;
    private String operator;

    public TemperatureCondition(String operator, Double threshold) {
        this.operator = operator;
        this.threshold = threshold;
    }

    @Override
    public boolean match(Equipment device) {
        // 从设备属性中获取当前温度
        Double currentTemp = (Double) device.getProperty("temperature");
        if (currentTemp == null) {
            return false; // 如果设备没有温度属性，条件不匹配
        }

        // 根据操作符进行温度比较
        return switch (operator) {
            case ">" -> currentTemp > threshold;
            case "<" -> currentTemp < threshold;
            case ">=" -> currentTemp >= threshold;
            case "<=" -> currentTemp <= threshold;
            case "=" -> currentTemp.equals(threshold);
            default -> false; // 不支持的操作符，条件不匹配
        };
    }
}