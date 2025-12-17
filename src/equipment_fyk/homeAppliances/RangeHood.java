package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 *  抽油烟机
 */
public class RangeHood extends Equipment implements HomeAppliances {
    /**
     * 抽油烟机构造函数
     */
    public RangeHood() {
        super();
    }
    /**
     * 抽油烟机构造函数
     * @param name 抽油烟机名称
     * @param id 抽油烟机ID
     */
    public RangeHood(String id,String name) {
        super(id,name);
    }
    @Override
    public void selfCheck() {
        System.out.println(" RangeHood selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" RangeHood register");
    }

    @Override
    public void activate() {
        System.out.println(" RangeHood activate");
    }
}