package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 空调
 */
public class AirConditioner extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" AirConditioner selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" AirConditioner register");
    }

    @Override
    public void activate() {
        System.out.println(" AirConditioner activate");
    }
}