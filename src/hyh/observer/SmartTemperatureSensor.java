package hyh.observer;

/**
 * 智能温感设备 - 需要状态通知，继承ObservableEquipment
 */
public class SmartTemperatureSensor extends ObservableEquipment {
    public SmartTemperatureSensor(String id, String name) {
        super(id, name);
        // 初始化设备类型属性
        setProperty("type", this.getClass().getSimpleName());
    }

    /**
     * 温度设置方法（温感设备核心功能）
     */
    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("温感设备[" + getName() + "]温度更新为：" + temp + "℃");
        // 温度超过阈值时通知观察者（观察者模式核心逻辑）
        if (temp > 35) {
            notifyObservers("温度过高：" + temp + "℃");
        } else if (temp < 10) {
            notifyObservers("温度过低：" + temp + "℃");
        }
    }

    @Override
    public void operate() {
        System.out.println("温感设备[" + getName() + "]开始工作，实时监测温度...");
    }

    @Override
    public void selfCheck() {
        System.out.println("温感设备[" + getName() + "]正在自检，检查传感器精度...");
        // 模拟自检通过
        setProperty("selfCheckResult", "正常");
    }

    @Override
    public void register() {
        System.out.println("温感设备[" + getName() + "]已注册到系统，设备ID：" + getId());
        setProperty("registered", true);
    }

    @Override
    public void activate() {
        System.out.println("温感设备[" + getName() + "]已激活，进入工作状态");
        setProperty("active", true);
    }

    @Override
    public void executeCommand(String command) {
        switch (command) {
            case "获取温度":
                System.out.println("温感设备[" + getName() + "]当前温度：" + getTemperature() + "℃");
                break;
            case "校准":
                System.out.println("温感设备[" + getName() + "]进行温度校准...");
                break;
            default:
                System.out.println("温感设备[" + getName() + "]不支持命令：" + command);
        }
    }
}


