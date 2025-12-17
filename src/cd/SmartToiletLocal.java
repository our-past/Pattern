package cd;

import equipment.Equipment;

public class SmartToiletLocal extends Equipment {
    private thirdPartySmartToilet toilet;
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
        this.toilet = (thirdPartySmartToilet)smartToilet;
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
}
