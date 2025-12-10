package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 升降衣服烘干rack
 */
public class ElevatingClothesDryingRack extends Equipment implements ControllableDevice {

    @Override
    public void selfCheck() {
        System.out.println(" ElevatingClothesDryingRack selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" ElevatingClothesDryingRack register");
    }
    
    @Override
    public void activate() {
        System.out.println(" ElevatingClothesDryingRack activate");
    }

}