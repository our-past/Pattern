package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 灯
 */
public class lamp extends Equipment implements HomeAppliances {
    @Override
    public void selfCheck() {
        System.out.println(" Lamp selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" Lamp register");
    }

    @Override
    public void activate() {
        System.out.println(" Lamp activate");
    }
}
