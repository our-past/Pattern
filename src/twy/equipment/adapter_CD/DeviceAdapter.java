package twy.equipment.adapter_CD;

import twy.equipment.Equipment;

/**
 * 设备适配器接口
 * 用于适配第三方设备到系统标准设备接口
 *
 * 要实现的功能：
 * 实现第三个功能，把第三方设备适配为系统标准设备，首先这个接口是给你写一个适配者类的，
 * 然后还要一个外部的第三方设备类与你写的适配者对接成一个系统标准的设备类，
 * 对接要求在system——fyk包下的SmartHomeControlSystem类中的registerDeviceAdapter方法中注册适配器，
 * 在integrateThirdPartyDevice方法中调用适配方法，将第三方设备适配为系统标准设备
 * 在findCompatibleAdapter方法中查找适配者类，根据第三方设备类型判断是否有对应的适配者类，
 * 如果有则返回适配者类，否则返回null，不许改变SmartHomeControlSystem类，有问题找我
 */
public interface DeviceAdapter {
    /**
     * 将第三方设备适配为系统标准设备
     * @param thirdPartyDevice 第三方设备对象
     * @param systemDeviceId 系统分配的设备ID
     * @param systemDeviceName 系统分配的设备名称
     * @return 适配后的系统标准设备
     */
    Equipment adapt(Object thirdPartyDevice, String systemDeviceId, String systemDeviceName);

    /**
     * 检查适配器是否支持指定类型的第三方设备
     * @param deviceType 设备类型
     * @return 是否支持
     */
    boolean isCompatible(String deviceType);
}