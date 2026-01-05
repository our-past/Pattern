package hyh.observer;

/**
 * 设备状态观察者接口
 */
public interface DeviceObserver {
    /**
     * 接收设备状态变更通知
     * @param device 发生状态变更的设备
     * @param message 通知消息
     */
    void onDeviceStatusChanged(ObservableEquipment device, String message);
}
