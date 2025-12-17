package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 * 空调
 */
public class AirConditioner extends Equipment implements HomeAppliances {
    /**
     * 空调构造函数
     */
    public AirConditioner() {
        super();
    }
    /**
     * 空调构造函数
     * @param name 空调名称
     * @param id 空调ID
     */
    public AirConditioner(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" AirConditioner selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" AirConditioner register");
    }

    @Override
    public void activate() {
        System.out.println(" AirConditioner activate");
    }
}