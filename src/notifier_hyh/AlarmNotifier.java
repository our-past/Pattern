package notifier_hyh;


import equipment_fyk.controllableDevice.Sensor_hyh.Sensor;

/**
 * 警报器观察者
 */
public class AlarmNotifier implements Notifier {

    public void onDeviceStatusChanged(Sensor device, String message) {
        System.out.println("[警报警报] 设备[" + device.getName() + "]：" + message + "！！！");
    }
}