package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 升降衣服烘干rack
 */
public class ElevatingClothesDryingRack extends Equipment implements ControllableDevice {
    /**
     * 升降衣服烘干rack构造函数
     */
    public ElevatingClothesDryingRack() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 升降衣服烘干rack构造函数
     * @param name 升降衣服烘干rack名称
     * @param id 升降衣服烘干rackID
     */
    public ElevatingClothesDryingRack(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
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
    @Override
    public void executeCommand(String command){

    }
    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" ElevatingClothesDryingRack addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" ElevatingClothesDryingRack removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" ElevatingClothesDryingRack checkAuto");
    }

}