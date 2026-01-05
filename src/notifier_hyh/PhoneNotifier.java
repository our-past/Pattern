package notifier_hyh;

import equipment_fyk.controllableDevice.Sensor_hyh.Sensor;

/**
 * 手机端通知观察者
 */
public class PhoneNotifier implements Notifier {
    @Override
    public void onDeviceStatusChanged(Sensor device, String message) {
        System.out.println("[手机通知] 设备[" + device.getName() + "]：" + message);
    }
}
