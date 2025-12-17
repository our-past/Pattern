package cd;
import equipment.Equipment;
import equipment.adapter_CD.DeviceAdapter ;
import system_FYK.SmartHomeControlSystem;
public class Main {
    public static void main(String[] args){
        //创建两个适配器
        DeviceAdapter alarmAdapter = new alarmAdapter();
        DeviceAdapter smartToiletAdapter = new smartToiletAdapter();
        //创建两个第三方设备 设配者
        thirdPartyDevice alarm=new thirdPartyAlarm("1","第三方闹钟");
        thirdPartyDevice smartToilet=new thirdPartySmartToilet("2","第三方智能马桶");

        SmartHomeControlSystem smartHomeControlSystem = new SmartHomeControlSystem();
        smartHomeControlSystem.registerDeviceAdapter(alarmAdapter);
        smartHomeControlSystem.registerDeviceAdapter(smartToiletAdapter);
        smartHomeControlSystem.integrateThirdPartyDevice(alarm, "alarm");
        smartHomeControlSystem.integrateThirdPartyDevice(smartToilet, "smartToilet");

    }


}
