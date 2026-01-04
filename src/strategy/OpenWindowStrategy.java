package strategy;


import equipment_fyk.controllableDevice.ElectricWindow;

/**
 * 打开窗户的烟雾处理策略（具体策略）
 */
public class OpenWindowStrategy implements Strategy {
    String strategyName;
    // 依赖的设备：电动窗户
    private final ElectricWindow electricWindow;
    /**
     * 打开窗户的烟雾处理策略构造函数
     * @param strategyName 策略名称
     */
    public OpenWindowStrategy(String strategyName,ElectricWindow electricWindow) {
        this.strategyName = strategyName;
        this.electricWindow = electricWindow;
    }

    @Override
    public void executeStrategy(){
        System.out.println("检测到烟雾，执行策略：打开窗户");
        electricWindow.open(); // 调用窗户的打开方法
    }
    @Override
    public String getStrategyName() {
        return strategyName;
    }
}