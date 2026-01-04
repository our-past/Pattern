package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

/**
 * 智能窗帘
 */
public class ElectricCurtain extends Equipment implements ControllableDevice {
    /**
     * 智能窗帘构造函数
     */
    public ElectricCurtain() {
        super();
        setProperty("type", this.getClass().getSimpleName());
        setProperty("position",100 );
    }
    /**
     * 智能窗帘构造函数
     * @param name 智能窗帘名称
     * @param id 智能窗帘ID
     */
    public ElectricCurtain(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
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
    @Override
    public void executeCommand(String command){
        if (command.equals("close")) {
            setProperty("position", 0);
            System.out.println("[窗帘-" + getId()+":"+getName() + "] 已关闭");
        }
    }

    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" ElectricCurtain addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" ElectricCurtain removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" ElectricCurtain checkAuto");
    }
}
