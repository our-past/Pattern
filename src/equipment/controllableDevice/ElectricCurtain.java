package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能窗帘
 */
public class ElectricCurtain extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" ElectricCurtain selfCheck");
    }
    @Override
    public void register() {
        System.out.println(" ElectricCurtain register");
    }
    @Override
    public void activate() {
        System.out.println(" ElectricCurtain activate");
    }

}
