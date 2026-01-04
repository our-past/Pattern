package twy.equipment.homeAppliances;

import twy.equipment.Equipment;
import twy.equipment.HomeAppliances;

/**
 * 智能电饭煲
 */
public class ElectricCooktop extends Equipment implements HomeAppliances {
    /**
     * 智能电饭煲构造函数
     */
    public ElectricCooktop() {
        super();
    }
    /**
     * 智能电饭煲构造函数
     * @param name 智能电饭煲名称
     * @param id 智能电饭煲ID
     */
    public ElectricCooktop(String id,String name) {
        super(id,name);
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
}