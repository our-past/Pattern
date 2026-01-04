package strategy;

import java.util.HashMap;

public abstract class StrategyContext {
    private String contextName;
    HashMap<String,Strategy> strategies = new HashMap<>();
    Strategy strategy;

    /**
     * 策略环境构造函数
     * @param contextName 策略环境名称
     */
    public StrategyContext(String contextName){
        this.contextName = contextName;
    }


    /**
     * 设置策略
     * @param key 策略键值
     * @param strategy 策略实例
     */
    public void setStrategyInMap(String key, Strategy strategy) {
        strategies.put(key,strategy);
        // 打印设置的策略
        System.out.println("添加策略：" + key +"到"+contextName+"策略环境");
    }

    public void getStrategyFromMap(String key){
        strategy = strategies.get(key);
        System.out.println("在"+contextName+"策略环境，设置策略：" + key);
    }

    /**
     * 执行策略
     */
    public void executeStrategy(){
        if (strategy == null) {
            System.out.println("未配置策略！");
            return;
        }
        strategy.executeStrategy();
    }

    public String getContextName(){
        return contextName;
    }
}
