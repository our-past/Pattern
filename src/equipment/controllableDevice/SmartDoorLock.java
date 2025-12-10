package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能门锁
 */
public class SmartDoorLock extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" SmartDoorLock selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartDoorLock register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartDoorLock activate");
    }

}