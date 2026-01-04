package equipment_fyk.adapter_CD;

import equipment_fyk.Equipment;
import equipment_fyk.three.ThirdPartySmartToilet;

public class SmartToiletLocal extends Equipment {
    private ThirdPartySmartToilet toilet;
    public SmartToiletLocal() {
        super();
    }
    /**
     * 智能闹钟构造函数
     * @param name 闹钟名称
     * @param id 闹钟ID
     */
    public SmartToiletLocal(String id, String name, Object smartToilet) {
        super(id,name);
        this.toilet = (ThirdPartySmartToilet)smartToilet;
        setProperty("type", this.getClass().getSimpleName());
    }

    @Override
    public void selfCheck() {
        toilet.selfCheck();
    }

    @Override
    public void register() {
        toilet.register();

    }

    @Override
    public void activate() {
        toilet.activate();
    }

    @Override
    public void executeCommand(String command) {

    }
}
