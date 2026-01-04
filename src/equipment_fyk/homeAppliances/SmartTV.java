package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 * 智能电视
 */
public class SmartTV extends Equipment implements HomeAppliances {
    /**
     * 智能电视构造函数
     */
    public SmartTV() {
        super("7", "智能电视");
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 智能电视构造函数
     * @param name 智能电视名称
     * @param id 智能电视ID
     */
    public SmartTV(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
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
    @Override
    public void executeCommand(String command){

    }
}