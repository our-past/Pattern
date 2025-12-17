package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;

/**
 * 智能马桶
 */
public class SmartToilet extends Equipment implements ControllableDevice {
    /**
     * 智能马桶构造函数
     */
    public SmartToilet() {
        super();
    }
    /**
     * 智能马桶构造函数
     * @param name 智能马桶名称
     * @param id 智能马桶ID
     */
    public SmartToilet(String id,String name) {
        super(id,name);
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

}