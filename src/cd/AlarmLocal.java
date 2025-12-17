package cd;

import equipment.Equipment;

public class AlarmLocal extends Equipment {
    private thirdPartyAlarm alarm;
    public AlarmLocal() {
        super();
    }
    /**
     * 智能闹钟构造函数
     * @param name 闹钟名称
     * @param id 闹钟ID
     */
    public AlarmLocal(String id, String name, Object alarm) {
        super(id,name);
        this.alarm = (thirdPartyAlarm)alarm;
    }

    @Override
    public void selfCheck() {
        alarm.selfCheck();
    }

    @Override
    public void register() {
        alarm.register();

    }

    @Override
    public void activate() {
        alarm.activate();

    }

}
