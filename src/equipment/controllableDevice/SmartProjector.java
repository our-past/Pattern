package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能投影仪
 */
public class SmartProjector extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" SmartProjector selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartProjector register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartProjector activate");
    }

}