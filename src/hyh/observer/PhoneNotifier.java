package hyh.observer;

/**
 * 手机端通知观察者
 */
public class PhoneNotifier implements DeviceObserver {
    @Override
    public void onDeviceStatusChanged(ObservableEquipment device, String message) {
        System.out.println("[手机通知] 设备[" + device.getName() + "]：" + message);
    }
}
