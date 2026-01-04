package twy.eleven;

import twy.equipment.homeAppliances.RangeHood;

/**
 * 策略模式测试类
 * 用于测试第11个需求：智能算法选择（烟雾处理策略）
 */
public class SmokeStrategyTest {

    public static void main(String[] args) {
        System.out.println("=== 策略模式测试：烟雾处理 ===");

        // 1. 创建具体的设备实例（策略需要操作的对象）
        ElectricWindow livingRoomWindow = new ElectricWindow("win-001", "客厅电动窗户");
        RangeHood kitchenHood = new RangeHood("rh-001", "厨房抽油烟机");

        // 2. 创建具体的策略实例
        // 策略A：打开窗户
        SmokeHandleStrategy openWindowStrategy = new OpenWindowStrategy(livingRoomWindow);
        // 策略B：打开抽油烟机
        SmokeHandleStrategy openHoodStrategy = new OpenRangeHoodStrategy(kitchenHood);

        // 3. 创建策略上下文（环境类）
        SmokeHandleContext context = new SmokeHandleContext();

        System.out.println("\n--- 场景1：在客厅检测到烟雾 ---");
        // 4. 在上下文中设置并执行策略A
        context.setStrategy(openWindowStrategy);
        System.out.println("系统选择策略：打开窗户进行通风。");
        context.executeSmokeHandle();

        System.out.println("\n--- 场景2：在厨房检测到烟雾 ---");
        // 5. 在同一个上下文中，动态切换并执行策略B
        context.setStrategy(openHoodStrategy);
        System.out.println("系统选择策略：打开抽油烟机进行排烟。");
        context.executeSmokeHandle();

        System.out.println("\n=== 测试结束 ===");
    }
}