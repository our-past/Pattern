package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 升降衣服烘干rack
 */
public class ElevatingClothesDryingRack extends Equipment implements ControllableDevice {
    /**
     * 升降衣服烘干rack构造函数
     */
    public ElevatingClothesDryingRack() {
        super();
    }
    /**
     * 升降衣服烘干rack构造函数
     * @param name 升降衣服烘干rack名称
     * @param id 升降衣服烘干rackID
     */
    public ElevatingClothesDryingRack(String id,String name) {
        super(id,name);
    }
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