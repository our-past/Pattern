package twy.nine;
import java.time.LocalTime;

// 时间条件策略实现
public class TimeCondition implements RuleCondition {
    private LocalTime targetTime;

    public TimeCondition(LocalTime targetTime) {
        this.targetTime = targetTime;
    }

    @Override
    public boolean match(SmartDevice device) {
        // 模拟当前时间为晚上8点
        LocalTime now = LocalTime.of(20, 0);
        return now.equals(targetTime);
    }
}