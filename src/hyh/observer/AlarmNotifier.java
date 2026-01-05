package hyh.observer;


/**
 * 警报器观察者
 */
public class AlarmNotifier implements DeviceObserver {

    public void onDeviceStatusChanged(ObservableEquipment device, String message) {
        System.out.println("[警报警报] 设备[" + device.getName() + "]：" + message + "！！！");
    }
}