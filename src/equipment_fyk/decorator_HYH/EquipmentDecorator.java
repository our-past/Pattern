package equipment_fyk.decorator_HYH;

import equipment_fyk.Equipment;

/**
 * 设备装饰器抽象类
 * 使用装饰模式为设备动态添加额外功能
 *
 * 实现第6个功能：为设备添加装饰功能，对设备的基本操作进行扩展，
 * 自己根据这个装饰抽象类来写一个具体的装饰器类,
 * 与SmartHomeControlSystem类中的decorateEquipment方法以及addDefaultDecorator方法结合使用，实现对设备的装饰功能
 */
public abstract class EquipmentDecorator extends Equipment {
    protected final Equipment decoratedEquipment;

    /**
     * 构造函数
     * @param id 设备ID
     * @param name 设备名称
     */
    public EquipmentDecorator(String id, String name) {
        super(id, name);
        this.decoratedEquipment = null;
        setProperty("type", this.getClass().getSimpleName());
    }

    public EquipmentDecorator(Equipment decoratedEquipment) {
        super(decoratedEquipment.getId(), decoratedEquipment.getName());
        this.decoratedEquipment = decoratedEquipment;
        setProperty("type", this.getClass().getSimpleName());
    }

    abstract public EquipmentDecorator createEquipmentDecorator(Equipment decoratedEquipment);

    @Override
    public void selfCheck() {

    }

    @Override
    public void register() {
    }

    @Override
    public void activate() {
    }

    @Override
    public void startSelf() {
    }

    @Override
    public void stopSelf() {
    }
}