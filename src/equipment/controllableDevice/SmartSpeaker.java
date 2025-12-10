package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能音箱
 */
public class SmartSpeaker extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" SmartSpeaker selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartSpeaker register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartSpeaker activate");
    }

}