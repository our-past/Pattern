package hyh.decorator;

import equipment_fyk.Equipment;
import equipment_fyk.decorator_HYH.EquipmentDecorator;

/**
 * 亮度渐变装饰器
 * 为设备添加亮度渐变功能
 */
public class BrightnessFadeDecorator extends EquipmentDecorator {
    private int fadeDuration; // 渐变时长（秒）
    public void executeCommand(String command) {
        // 实现命令执行逻辑，例如：
        System.out.println("ColorAdjustDecorator 执行命令: " + command);
        // 也可以调用被装饰设备的对应方法
        // equipment.executeCommand(command);
    }

    // 构造方法：通过已有设备创建装饰器
    public BrightnessFadeDecorator(Equipment decoratedEquipment) {
        super(decoratedEquipment);
        this.fadeDuration = 2; // 默认2秒渐变
        setProperty("function", "亮度渐变"); // 添加功能标识
    }

    // 空构造用于创建装饰器模板（供系统注册默认装饰器）
    public BrightnessFadeDecorator() {
        super("", "亮度渐变装饰器");
        this.fadeDuration = 2;
        setProperty("function", "亮度渐变");
    }

    /**
     * 创建装饰器实例（实现抽象方法）
     */
    @Override
    public EquipmentDecorator createEquipmentDecorator(Equipment decoratedEquipment) {
        return new BrightnessFadeDecorator(decoratedEquipment);
    }

    /**
     * 设置渐变时长
     */
    public void setFadeDuration(int seconds) {
        if (seconds > 0) {
            this.fadeDuration = seconds;
            System.out.println("[" + getDecoratedEquipmentName() + "] 已设置亮度渐变时长：" + seconds + "秒");
        } else {
            System.out.println("渐变时长必须大于0");
        }
    }

    /**
     * 重写设备启动方法，增强渐变功能
     */
    @Override
    public void startSelf() {
        System.out.print("[" + getDecoratedEquipmentName() + "] 正在进行亮度渐变");
        // 模拟渐变过程
        for (int i = 0; i < fadeDuration; i++) {
            System.out.print("...");
            try {
                Thread.sleep(500); // 每步间隔0.5秒
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println();
        super.startSelf(); // 调用被装饰设备的启动方法
        System.out.println("[" + getDecoratedEquipmentName() + "] 亮度渐变完成（总时长：" + fadeDuration + "秒）");
    }

    /**
     * 获取被装饰设备名称（便于日志输出）
     */
    private String getDecoratedEquipmentName() {
        return decoratedEquipment != null ? decoratedEquipment.getName() : "未知设备";
    }

    /**
     * 重写设备描述
     */
    @Override
    public String getDescription() {
        return decoratedEquipment.getDescription() + "，支持亮度渐变（时长：" + fadeDuration + "秒）";
    }
}