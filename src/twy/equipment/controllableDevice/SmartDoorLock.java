package twy.equipment.controllableDevice;

import twy.equipment.ControllableDevice;
import twy.equipment.Equipment;

/**
 * 智能门锁
 */
public class SmartDoorLock extends Equipment implements ControllableDevice {
    /**
     * 智能门锁构造函数
     */
    public SmartDoorLock() {
        super();
    }
    /**
     * 智能门锁构造函数
     * @param name 智能门锁名称
     * @param id 智能门锁ID
     */
    public SmartDoorLock(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" SmartDoorLock selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartDoorLock register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartDoorLock activate");
    }

}