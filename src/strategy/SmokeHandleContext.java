package strategy;

/**
 * 烟雾处理策略上下文（负责策略的切换、执行）
 */
public class SmokeHandleContext extends StrategyContext{
     /**
      * 烟雾处理策略上下文构造函数
      * @param strategyName 策略名称
      */
    public SmokeHandleContext(String strategyName) {
        super(strategyName);
    }

    // 执行当前策略
    @Override
    public void executeStrategy(){
        if (strategy == null) {
            System.out.println("未配置烟雾处理策略！");
            return;
        }
        strategy.executeStrategy();
    }
}