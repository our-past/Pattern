package notifier_hyh;


import equipment_fyk.controllableDevice.Sensor_hyh.Sensor;

/**
 * 物业通知观察者
 */
public class PropertyNotifier implements Notifier {
    public void onDeviceStatusChanged(Sensor device, String message) {
        System.out.println("[物业通知] 设备[" + device.getName() + "]：" + message);
    }
}