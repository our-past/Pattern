package equipment_fyk.controllableDevice.Sensor_hyh;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule_twy.rule;

import java.util.HashMap;

/**
 * 智能烟感设备 - 需要状态通知
 */
public class SmartSmokeSensor extends Sensor implements ControllableDevice {

    HashMap<rule, Equipment> autoRules = new HashMap<>();

    public SmartSmokeSensor(){
        super();
        setProperty("type", this.getClass().getSimpleName());
        setProperty("smokeLevel", 0.0);
    }

    // 构造方法
    public SmartSmokeSensor(String id, String name) {
        super(id, name);
        setProperty("type", this.getClass().getSimpleName());
        setProperty("smokeLevel", 0.0);
    }

    @Override
    public void setProperty(String key, Object value) {
        super.setProperty(key, value);
        checkAuto();
        changeToNotified(key, value);
    }

    public void addAutoRule(rule r, Equipment device) {
        autoRules.put(r, device);
        checkAuto();
    }

    public void removeAutoRule(rule r) {
        autoRules.remove(r);
    }

    @Override
    protected void changeToNotified(String key, Object value) {

        String message = "";
        switch (key) {
            case "smokeLevel":
                if (value instanceof Double num) {
                    if (num > 0.5) {
                        message = "警告："+"烟雾传感器[" + getName() + "]检测到烟雾浓度为：" + num;
                    }else{
                        message = "正常："+"烟雾传感器[" + getName() + "]检测到烟雾浓度为：" + num;
                    }
                }else if (value instanceof Boolean bool){
                    if (bool) {
                        message = "警告："+"烟雾传感器[" + getName() + "]检测到烟雾信号！";
                    }else{
                        message = "正常："+"烟雾传感器[" + getName() + "]未检测到烟雾信号。";
                    }
                }else if (value instanceof String str){
                    message = "烟雾传感器[" + getName() + "]状态更新：" + key + " -> " + str;
                }else if (value instanceof Integer intNum){
                    message = "烟雾传感器[" + getName() + "]状态更新：" + key + " -> " + intNum;
                }else{
                    message = "烟雾传感器[" + getName() + "]状态更新：" + key + " -> " + value;
                }
            default:
                message = "烟雾传感器[" + getName() + "]状态更新：" + key + " -> " + value;
        }
        notifyNotifiers(message);
    }

    @Override
    public void checkAuto() {

        System.out.println("烟雾传感器[" + getName() + "]正在检查自动规则...");
    }

    // 实现父类的抽象方法register()
    @Override
    public void register() {
        // 烟雾传感器的注册逻辑，例如向系统注册设备信息
        System.out.println("烟雾传感器[" + getName() + "]已完成注册，设备ID：" + getId());
        // 可添加实际注册操作（如将设备信息录入系统、初始化注册状态等）
    }

    @Override
    public void selfCheck() {
        // 自检逻辑
        System.out.println("烟雾传感器[" + getName() + "]正在进行自检...");
        // 例如检查传感器灵敏度、电池状态等
    }

    @Override
    public void activate() {
        System.out.println("烟雾传感器[" + getName() + "]已激活，开始监听烟雾信号...");
    }

    @Override
    public void executeCommand(String command) {
        // 命令执行逻辑（之前错误中已实现，此处保持一致）
        switch (command) {
            case "检测烟雾":
                System.out.println("烟雾传感器[" + getName() + "]开始检测烟雾...");
                break;
            case "启动警报":
                System.out.println("烟雾传感器[" + getName() + "]触发警报！");
                break;
            default:
                System.out.println("烟雾传感器[" + getName() + "]不支持命令：" + command);
        }
    }

}

