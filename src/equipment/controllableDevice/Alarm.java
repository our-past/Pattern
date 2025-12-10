package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能闹钟
 */
public class Alarm extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" Alarm selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" Alarm register");
    }
    
    @Override
    public void activate() {
        System.out.println(" Alarm activate");
    }

}