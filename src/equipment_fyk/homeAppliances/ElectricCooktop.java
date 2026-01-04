package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 * 智能电饭煲
 */
public class ElectricCooktop extends Equipment implements HomeAppliances {
    /**
     * 智能电饭煲构造函数
     */
    public ElectricCooktop() {
        super();
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能电饭煲构造函数
     * @param name 智能电饭煲名称
     * @param id 智能电饭煲ID
     */
    public ElectricCooktop(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
    }
    @Override
    public void selfCheck() {
        System.out.println(" ElectricCooktop selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" ElectricCooktop register");
    }

    @Override
    public void activate() {
        System.out.println(" ElectricCooktop activate");
    }
    @Override
    public void executeCommand(String command){

    }
}