package hyh.observer;


/**
 * 物业通知观察者
 */
public class PropertyNotifier implements DeviceObserver {
    public void onDeviceStatusChanged(ObservableEquipment device, String message) {
        System.out.println("[物业通知] 设备[" + device.getName() + "]：" + message);
    }
}