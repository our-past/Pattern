package equipment_fyk.adapter_CD;

import equipment_fyk.Equipment;
import equipment_fyk.three.ThirdPartyAlarm;

public class AlarmLocal extends Equipment {
    private ThirdPartyAlarm alarm;
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
        this.alarm = (ThirdPartyAlarm)alarm;
        setProperty("type", this.getClass().getSimpleName());
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

    @Override
    public void executeCommand(String command) {

    }

}
