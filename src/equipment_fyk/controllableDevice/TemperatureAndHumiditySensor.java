package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

import java.util.HashMap;
import java.util.Map;

/**
 * 温度和湿度传感器
 */
public class TemperatureAndHumiditySensor extends Equipment implements ControllableDevice {

    HashMap<rule, Equipment> autoRules = new HashMap<>();

    /**
     * 温度和湿度传感器构造函数
     */
    public TemperatureAndHumiditySensor() {
        super();
        setProperty("type", this.getClass().getSimpleName());
        setProperty("temperatureType", "摄氏度");
        setProperty("humidityType", "百分比");
        setProperty("temperature", 0.0);
        setProperty("humidity", 0.0);
    }
    /**
     * 温度和湿度传感器构造函数
     * @param name 温度和湿度传感器名称
     * @param id 温度和湿度传感器ID
     */
    public TemperatureAndHumiditySensor(String id,String name) {
        super(id,name);
        setProperty("temperatureType", "摄氏度");
        setProperty("humidityType", "百分比");
        setProperty("temperature", 0.0);
        setProperty("humidity", 0.0);
        setProperty("type", this.getClass().getSimpleName());
    }

    @Override
    public void selfCheck() {
        System.out.println(" TemperatureAndHumiditySensor selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" TemperatureAndHumiditySensor register");
    }
    
    @Override
    public void activate() {
        System.out.println(" TemperatureAndHumiditySensor activate");
    }

    @Override
    public void setProperty(String key, Object value) {
        super.setProperty(key, value);
        checkAuto();
    }

    public void addAutoRule(rule r, Equipment device) {
        autoRules.put(r, device);
        checkAuto();
    }

    public void removeAutoRule(rule r) {
        autoRules.remove(r);
    }

    @Override
    public void checkAuto() {
        for (Map.Entry<rule, Equipment> entry : autoRules.entrySet()) {
            rule r = entry.getKey();
            Equipment device = entry.getValue();
            // 检查规则是否匹配
            if (r.match(this)) {
                // 执行规则动作
                r.execute(device);
                System.out.println("自动化规则触发: " + r.getClass().getSimpleName());
            }
        }
    }

    @Override
    public void executeCommand(String command){

    }
}