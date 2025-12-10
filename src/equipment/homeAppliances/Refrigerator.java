package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 冰箱
 */
public class Refrigerator extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" Refrigerator selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" Refrigerator register");
    }

    @Override
    public void activate() {
        System.out.println(" Refrigerator activate");
    }
}