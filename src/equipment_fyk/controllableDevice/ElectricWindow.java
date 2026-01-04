package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

public class ElectricWindow extends Equipment implements ControllableDevice {
        /**
         * 电动窗户构造函数
         */
        public ElectricWindow() {
            super();
            setProperty("type", this.getClass().getSimpleName());
        }
        /**
         * 电动窗户构造函数
         * @param id 电动窗户ID
         * @param name 电动窗户名称
         */
        public ElectricWindow(String id,String name) {
            super(id,name);
            setProperty("type", this.getClass().getSimpleName());
        }
        /**
         * 电动窗户打开
         */
        public void open() {
            System.out.println("ElectricWindow open");
        }
        /**
         * 电动窗户关闭
         */
        public void close() {
            System.out.println("ElectricWindow close");
        }

    @Override
    public void selfCheck() {
        System.out.println(" ElectricWindow selfCheck");
    }
    @Override
    public void register() {
        System.out.println(" ElectricWindow register");
    }
    @Override
    public void activate() {
        System.out.println(" ElectricWindow activate");
    }
    @Override
    public void executeCommand(String command){
        if (command.equals("CLOSE")) {
            setProperty("position", 0);
            System.out.println("[电动窗户-" + getId()+":"+getName() + "] 已关闭");
        }
    }

    @Override
    public void addAutoRule(rule r, Equipment e) {
        System.out.println(" ElectricWindow addAutoRule");
    }
    @Override
    public void removeAutoRule(rule r) {
        System.out.println(" ElectricWindow removeAutoRule");
    }
    @Override
    public void checkAuto() {
        System.out.println(" ElectricWindow checkAuto");
    }
}
