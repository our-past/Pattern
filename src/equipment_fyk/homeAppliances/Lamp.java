package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 * 灯
 */
public class Lamp extends Equipment implements HomeAppliances {
    /**
     * 灯构造函数
     */
    public Lamp() {
        super();
    }
    /**
     * 灯构造函数
     * @param name 灯名称
     * @param id 灯ID
     */
    public Lamp(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" Lamp selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" Lamp register");
    }

    @Override
    public void activate() {
        System.out.println(" Lamp activate");
    }
}
