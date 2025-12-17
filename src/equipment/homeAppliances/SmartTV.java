package equipment.homeAppliances;

import equipment.Equipment;
import equipment.HomeAppliances;

/**
 * 智能电视
 */
public class SmartTV extends Equipment implements HomeAppliances {
    /**
     * 智能电视构造函数
     */
    public SmartTV() {
        super("7", "智能电视");
    }
    /**
     * 智能电视构造函数
     * @param name 智能电视名称
     * @param id 智能电视ID
     */
    public SmartTV(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" SmartTV selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" SmartTV register");
    }

    @Override
    public void activate() {
        System.out.println(" SmartTV activate");
    }
}