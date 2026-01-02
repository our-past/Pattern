package twy.eleven;

import twy.eleven.ElectricWindow;
/**
 * 打开窗户的烟雾处理策略（具体策略）
 */
public class OpenWindowStrategy implements SmokeHandleStrategy {
    // 依赖的设备：电动窗户
    private final ElectricWindow electricWindow;

    // 构造器注入设备
    public OpenWindowStrategy(ElectricWindow electricWindow) {
        this.electricWindow = electricWindow;
    }

    @Override
    public void handleSmoke() {
        System.out.println("检测到烟雾，执行策略：打开窗户驱散");
        electricWindow.open(); // 调用窗户的打开方法
    }
}