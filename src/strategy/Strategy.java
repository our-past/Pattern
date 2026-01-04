package strategy;

public interface Strategy {
    /**
     * 执行策略
     */
    void executeStrategy();

     /**
      * 获取策略名称
      * @return 策略名称
      */
     String getStrategyName();
}
