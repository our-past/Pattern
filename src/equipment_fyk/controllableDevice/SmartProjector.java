package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 智能投影仪
 */
public class SmartProjector extends Equipment implements ControllableDevice {
    /**
     * 智能投影仪构造函数
     */
    public SmartProjector() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能投影仪构造函数
     * @param name 智能投影仪名称
     * @param id 智能投影仪ID
     */
    public SmartProjector(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
    }
    @Override
    public void selfCheck() {
        System.out.println(" SmartProjector selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartProjector register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartProjector activate");
    }
    @Override
    public void executeCommand(String command){

    }
    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" SmartProjector addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" SmartProjector removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" SmartProjector checkAuto");
    }

}