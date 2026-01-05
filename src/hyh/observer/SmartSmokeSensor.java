package hyh.observer;

/**
 * 智能烟感设备 - 需要状态通知，继承ObservableEquipment
 */
public class SmartSmokeSensor extends ObservableEquipment {
    // 构造方法
    public SmartSmokeSensor(String id, String name) {
        super(id, name);
    }

    // 实现父类的抽象方法register()
    @Override
    public void register() {
        // 烟雾传感器的注册逻辑，例如向系统注册设备信息
        System.out.println("烟雾传感器[" + getName() + "]已完成注册，设备ID：" + getId());
        // 可添加实际注册操作（如将设备信息录入系统、初始化注册状态等）
    }

    // 需同时实现其他抽象方法（根据之前的错误提示）
    @Override
    public void operate() {
        // 设备操作逻辑
        System.out.println("烟雾传感器[" + getName() + "]正在运行中...");
    }

    @Override
    public void selfCheck() {
        // 自检逻辑
        System.out.println("烟雾传感器[" + getName() + "]正在进行自检...");
        // 例如检查传感器灵敏度、电池状态等
    }

    @Override
    public void activate() {
        // 激活逻辑（之前错误中已实现，此处保持一致）
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

    // 其他业务方法（如烟雾检测状态设置）
    public void setSmokeDetected(boolean detected) {
        this.hasSmoke = detected;
        // 可添加状态变更通知观察者的逻辑（观察者模式相关）
    }
}

