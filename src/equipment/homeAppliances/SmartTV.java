package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 智能电视
 */
public class SmartTV extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" SmartTV selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" SmartTV register");
    }

    @Override
    public void activate() {
        System.out.println(" SmartTV activate");
    }
}