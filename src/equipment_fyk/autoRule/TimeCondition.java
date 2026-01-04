package equipment_fyk.autoRule;
import equipment_fyk.Equipment;

import java.time.LocalDateTime;
import java.time.LocalTime;

// 时间条件策略实现
public class TimeCondition implements RuleCondition {
    private Integer targetTime;

    public TimeCondition(Integer targetTime) {
        this.targetTime = targetTime;
    }

    @Override
    public boolean match(Equipment device) {
        String currentTimeStr = (String) device.getProperties().get("time");
        if (currentTimeStr == null) {
            System.out.println("时间条件匹配失败：设备未设置时间属性");
            return false;
        }
        LocalDateTime currentTime = LocalDateTime.parse(currentTimeStr);
        Integer currentHour = currentTime.getHour();
        return currentHour.equals(targetTime);
    }
}