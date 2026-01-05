package hyh.observer;

/**
 * 设备主题接口（被观察者）
 */
public interface DeviceSubject {
    void addObserver(DeviceObserver observer);
    void removeObserver(DeviceObserver observer);
    void notifyObservers(String message);
}
