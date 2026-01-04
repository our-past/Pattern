package strategy;


import equipment_fyk.homeAppliances.RangeHood;

/**
 * 打开抽油烟机的烟雾处理策略（具体策略）
 */
public class OpenRangeHoodStrategy implements Strategy {
    String strategyName;
    /**
     * 打开抽油烟机的烟雾处理策略构造函数
     * @param strategyName 策略名称
     */
    public OpenRangeHoodStrategy(String strategyName,RangeHood rangeHood) {
        this.strategyName = strategyName;
        this.rangeHood = rangeHood;
    }

    // 依赖的设备：抽油烟机
    private final RangeHood rangeHood;

    @Override
    public void executeStrategy() {
        System.out.println("检测到烟雾，执行策略：打开抽油烟机排风");
        rangeHood.start();
    }
     @Override
    public String getStrategyName() {
        return strategyName;
    }
}