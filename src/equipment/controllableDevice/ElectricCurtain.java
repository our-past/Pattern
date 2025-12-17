package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能窗帘
 */
public class ElectricCurtain extends Equipment implements ControllableDevice {
    /**
     * 智能窗帘构造函数
     */
    public ElectricCurtain() {
        super();
    }
    /**
     * 智能窗帘构造函数
     * @param name 智能窗帘名称
     * @param id 智能窗帘ID
     */
    public ElectricCurtain(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" ElectricCurtain selfCheck");
    }
    @Override
    public void register() {
        System.out.println(" ElectricCurtain register");
    }
    @Override
    public void activate() {
        System.out.println(" ElectricCurtain activate");
    }

}
