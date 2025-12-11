package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 热水器
 */
public class ElectricWaterHeater extends Equipment implements HomeAppliances {
    /**
     * 热水器构造函数
     */
    public ElectricWaterHeater() {
        super();
    }
    /**
     * 热水器构造函数
     * @param name 热水器名称
     * @param id 热水器ID
     */
    public ElectricWaterHeater(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" ElectricWaterHeater selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" ElectricWaterHeater register");
    }

    @Override
    public void activate() {
        System.out.println(" ElectricWaterHeater activate");
    }
}