package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 智能门锁
 */
public class SmartDoorLock extends Equipment implements ControllableDevice {
    /**
     * 智能门锁构造函数
     */
    public SmartDoorLock() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能门锁构造函数
     * @param name 智能门锁名称
     * @param id 智能门锁ID
     */
    public SmartDoorLock(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
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
    @Override
    public void executeCommand(String command){

    }
    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" SmartDoorLock addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" SmartDoorLock removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" SmartDoorLock checkAuto");
    }

}