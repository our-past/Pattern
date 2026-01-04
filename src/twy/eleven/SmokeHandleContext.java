package twy.eleven;

// 包路径：twy.strategy
/**
 * 烟雾处理策略上下文（负责策略的切换、执行）
 */
public class SmokeHandleContext {
    // 当前使用的策略
    private SmokeHandleStrategy strategy;

    // 设置/切换策略
    public void setStrategy(SmokeHandleStrategy strategy) {
        this.strategy = strategy;
    }

    // 执行当前策略
    public void executeSmokeHandle() {
        if (strategy == null) {
            System.out.println("未配置烟雾处理策略！");
            return;
        }
        strategy.handleSmoke();
    }
}