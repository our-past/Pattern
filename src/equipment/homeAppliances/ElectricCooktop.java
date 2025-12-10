package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 智能电饭煲
 */
public class ElectricCooktop extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" ElectricCooktop selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" ElectricCooktop register");
    }

    @Override
    public void activate() {
        System.out.println(" ElectricCooktop activate");
    }
}