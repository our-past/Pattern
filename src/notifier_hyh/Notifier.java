package notifier_hyh;

import equipment_fyk.controllableDevice.Sensor_hyh.Sensor;

/**
 * 设备状态观察者接口
 */
public interface Notifier {
    /**
     * 接收设备状态变更通知
     * @param device 发生状态变更的设备
     * @param message 通知消息
     */
    void onDeviceStatusChanged(Sensor device, String message);
}
