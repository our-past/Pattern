package equipment_fyk.controllableDevice.Sensor_hyh;

import equipment_fyk.Equipment;
import notifier_hyh.Notifier;

import java.util.ArrayList;
import java.util.List;

/**
 * 带观察者功能的设备子类 - 仅需要状态通知的设备继承此类
 */
public abstract class Sensor extends Equipment {

    // 观察者列表
    private final List<Notifier> notifiers = new ArrayList<>();

    public Sensor() {
        super();
    }

    public Sensor(String id, String name) {
        super(id, name);
    }

    // ========== 观察者管理方法 ==========
    public void addNotifier(Notifier notifier) {
        if (notifier != null && !notifiers.contains(notifier)) {
            notifiers.add(notifier);
        }
    }

    public void removeNotifier(Notifier notifier) {
        notifiers.remove(notifier);
    }

    public void clearNotifiers() {
        notifiers.clear();
    }

    protected void notifyNotifiers(String message) {
        for (Notifier notifier : notifiers) {
            notifier.onDeviceStatusChanged(this, message);
        }
    }

    protected abstract void changeToNotified(String key, Object value);

}
