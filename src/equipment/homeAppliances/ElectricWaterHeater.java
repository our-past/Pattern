package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 热水器
 */
public class ElectricWaterHeater extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" ElectricWaterHeater selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" ElectricWaterHeater register");
    }

    @Override
    public void activate() {
        System.out.println(" ElectricWaterHeater activate");
    }
}