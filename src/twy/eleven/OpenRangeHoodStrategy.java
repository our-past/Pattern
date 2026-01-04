package twy.eleven;

// 包路径：twy.strategy
import twy.equipment.homeAppliances.RangeHood;

/**
 * 打开抽油烟机的烟雾处理策略（具体策略）
 */
public class OpenRangeHoodStrategy implements SmokeHandleStrategy {
    // 依赖的设备：抽油烟机
    private final RangeHood rangeHood;

    // 构造器注入设备
    public OpenRangeHoodStrategy(RangeHood rangeHood) {
        this.rangeHood = rangeHood;
    }

    @Override
    public void handleSmoke() {
        System.out.println("检测到烟雾，执行策略：打开抽油烟机排风");
        rangeHood.start(); // 调用抽油烟机的启动方法（继承自Equipment的start模板方法）
    }
}