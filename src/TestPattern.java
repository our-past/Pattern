import cd.DeviceGroup;
import equipment.Equipment;
import equipment.homeAppliances.SmartTV;
import equipment.homeAppliances.lamp;

public class TestPattern {
    public static void main(String[] args){
        DeviceGroup roomDeviceGroup = new DeviceGroup("客厅设备组");
        Equipment lamp = new lamp();
        Equipment tv = new SmartTV();
        roomDeviceGroup.addComponent(lamp);
        roomDeviceGroup.addComponent(tv);
        DeviceGroup rushroomDeviceGroup = new DeviceGroup("灯设备组");
        Equipment lamp1 = new lamp();
        Equipment lamp2 = new lamp();
        rushroomDeviceGroup.addComponent(lamp1);
        rushroomDeviceGroup.addComponent(lamp2);
        roomDeviceGroup.addComponent(rushroomDeviceGroup);
    }
}
