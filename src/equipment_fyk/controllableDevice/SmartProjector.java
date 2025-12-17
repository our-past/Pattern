package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;

/**
 * 智能投影仪
 */
public class SmartProjector extends Equipment implements ControllableDevice {
    /**
     * 智能投影仪构造函数
     */
    public SmartProjector() {
        super();
    }
    /**
     * 智能投影仪构造函数
     * @param name 智能投影仪名称
     * @param id 智能投影仪ID
     */
    public SmartProjector(String id,String name) {
        super(id,name);
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

}