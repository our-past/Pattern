package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能马桶
 */
public class SmartToilet extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" SmartToilet selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartToilet register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartToilet activate");
    }

}