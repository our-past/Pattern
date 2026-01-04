package twy.eleven;
// 包路径：twy.equipment.controllableDevice
import twy.equipment.ControllableDevice;
import twy.equipment.Equipment;

/**
 * 电动窗户（可控设备）
 */
public class ElectricWindow extends Equipment implements ControllableDevice {
    public ElectricWindow() {
        super();
    }

    public ElectricWindow(String id, String name) {
        super(id, name);
    }

    @Override
    public void selfCheck() {
        System.out.println("ElectricWindow selfCheck");
    }

    @Override
    public void register() {
        System.out.println("ElectricWindow register");
    }

    @Override
    public void activate() {
        System.out.println("ElectricWindow activate");
    }

    // 新增：窗户打开方法
    public void open() {
        System.out.println("【" + this.getName() + "】正在开启（用于驱散烟雾）");
    }
}