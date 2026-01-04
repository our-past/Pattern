package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 智能马桶
 */
public class SmartToilet extends Equipment implements ControllableDevice {
    /**
     * 智能马桶构造函数
     */
    public SmartToilet() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能马桶构造函数
     * @param name 智能马桶名称
     * @param id 智能马桶ID
     */
    public SmartToilet(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
    }
    @Override
    public void selfCheck() {
        System.out.println(" SmartToilet selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" SmartToilet register");
    }
    
    @Override
    public void activate() {
        System.out.println(" SmartToilet activate");
    }
    @Override
    public void executeCommand(String command){

    }
    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" SmartToilet addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" SmartToilet removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" SmartToilet checkAuto");
    }
}