package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 智能音箱
 */
public class SmartSpeaker extends Equipment implements ControllableDevice {
    /**
     * 智能音箱构造函数
     */
    public SmartSpeaker() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能音箱构造函数
     * @param name 智能音箱名称
     * @param id 智能音箱ID
     */
    public SmartSpeaker(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
    }
    @Override
    public void selfCheck() {
        System.out.println(" SmartSpeaker selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartSpeaker register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartSpeaker activate");
    }
    @Override
    public void executeCommand(String command){

    }
    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" SmartSpeaker addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" SmartSpeaker removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" SmartSpeaker checkAuto");
    }

}