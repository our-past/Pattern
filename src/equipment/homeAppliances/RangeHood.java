package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 *  抽油烟机
 */
public class RangeHood extends Equipment implements HomeAppliances {
    public RangeHood() {
        super("5","抽油烟机");
    }
    @Override
    public void selfCheck() {
        System.out.println(" RangeHood selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" RangeHood register");
    }

    @Override
    public void activate() {
        System.out.println(" RangeHood activate");
    }
}