package equipment_fyk.decorator_HYH;

import equipment_fyk.Equipment;

/**
 * 颜色调节装饰器
 * 为灯光设备添加颜色调节功能
 */
public class ColorAdjustDecorator extends EquipmentDecorator {
    private String currentColor; // 当前颜色
    public void executeCommand(String command) {
        if(!getState().isActive()){
            System.out.println(getName()+"未激活，无法执行命令");
            return;
        }
        // 实现命令执行逻辑，例如：
        System.out.println("ColorAdjustDecorator 执行命令: " + command);
        // 也可以调用被装饰设备的对应方法
        // equipment.executeCommand(command);
    }
    // 构造方法：通过已有设备创建装饰器
    public ColorAdjustDecorator(Equipment decoratedEquipment) {
        super(decoratedEquipment);
        setProperty("function", "颜色调节"); // 添加功能标识
    }

    // 空构造用于创建装饰器模板（供系统注册默认装饰器）
    public ColorAdjustDecorator() {
        super("", "颜色调节装饰器");
        setProperty("function", "颜色调节");
    }

    /**
     * 创建装饰器实例（实现抽象方法）
     */
    @Override
    public EquipmentDecorator createEquipmentDecorator(Equipment decoratedEquipment) {
        return new ColorAdjustDecorator(decoratedEquipment);
    }

    /**
     * 设置设备颜色
     */
    public void setColor(String color) {
        this.currentColor = color;
        System.out.println("[" + getDecoratedEquipmentName() + "] 已设置颜色为：" + color);
    }

    /**
     * 获取当前颜色
     */
    public String getCurrentColor() {
        return currentColor;
    }

    /**
     * 重写设备启动方法，增强颜色功能
     */
    @Override
    public void startSelf() {
        super.startSelf(); // 调用被装饰设备的启动方法
        if (currentColor != null) {
            System.out.println("[" + getDecoratedEquipmentName() + "] 以" + currentColor + "色启动");
        }
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
        return decoratedEquipment.getDescription() + "，支持颜色调节（当前：" + (currentColor != null ? currentColor : "未设置") + "）";
    }
}
