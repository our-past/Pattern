package hyh.observer;

import equipment_fyk.Equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 带观察者功能的设备子类 - 仅需要状态通知的设备继承此类
 */
public abstract class ObservableEquipment extends Equipment {
    // 设备核心属性
    private String id;
    private String name;
    public int temperature; // 温度属性
    public boolean hasSmoke; // 烟雾检测属性
    private Map<String, Object> properties = new HashMap<>(); // 设备扩展属性

    // 观察者列表
    private List<DeviceObserver> observers = new ArrayList<>();

    public ObservableEquipment(String id, String name) {
        this.id = id;
        this.name = name;
        this.properties.put("type", this.getClass().getSimpleName());
    }

    // ========== 设备属性getter/setter ==========
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTemperature() {
        return temperature;
    }

    public boolean isHasSmoke() {
        return hasSmoke;
    }

    public void setProperty(String key, Object value) {
        properties.put(key, value);
    }

    public Object getProperty(String key) {
        return properties.get(key);
    }

    // ========== 观察者管理方法 ==========
    public void addObserver(DeviceObserver observer) {
        if (observer != null && !observers.contains(observer)) {
            observers.add(observer);
        }
    }

    public void removeObserver(DeviceObserver observer) {
        observers.remove(observer);
    }

    public void clearObservers() {
        observers.clear();
    }

    protected void notifyObservers(String message) {
        for (DeviceObserver observer : observers) {
            observer.onDeviceStatusChanged(this, message);
        }
    }

    // ========== 状态变更触发通知的方法 ==========
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if (temperature > 35) {
            notifyObservers("温度过高，当前温度：" + temperature + "℃");
        } else if (temperature < 0) {
            notifyObservers("温度过低，当前温度：" + temperature + "℃");
        }
    }

    public void setSmokeDetected(boolean detected) {
        this.hasSmoke = detected;
        if (detected) {
            notifyObservers("侦测到烟雾，存在火灾风险");
        } else {
            notifyObservers("烟雾已消散，设备恢复正常");
        }
    }

    // ========== 设备基础功能方法 ==========
    public void operate() {
        System.out.println("设备[" + name + "]开始运行");
    }

    public void selfCheck() {
        System.out.println("设备[" + name + "]自检中...");
        setProperty("selfCheckResult", "正常");
    }
}
