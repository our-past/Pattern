package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 智能闹钟
 */
public class Alarm extends Equipment implements ControllableDevice {
    /**
     * 智能闹钟构造函数
     */
    public Alarm() {
        super();
    }
    /**
     * 智能闹钟构造函数
     * @param name 闹钟名称
     * @param id 闹钟ID
     */
    public Alarm(String id,String name) {
        super(id,name);
    }

    @Override
    public void selfCheck() {
        System.out.println(" Alarm selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" Alarm register");
    }
    
    @Override
    public void activate() {
        System.out.println(" Alarm activate");
    }

}