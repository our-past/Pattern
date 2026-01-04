package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;

/**
 * 智能音箱
 */
public class SmartSpeaker extends Equipment implements ControllableDevice {
    /**
     * 智能音箱构造函数
     */
    public SmartSpeaker() {
        super();
    }
    /**
     * 智能音箱构造函数
     * @param name 智能音箱名称
     * @param id 智能音箱ID
     */
    public SmartSpeaker(String id,String name) {
        super(id,name);
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

}