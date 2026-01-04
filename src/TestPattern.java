
import equipment_fyk.Equipment;
import equipment_fyk.EquipmentConstants;
import equipment_fyk.adapter_CD.DeviceAdapter;
import equipment_fyk.adapter_CD.alarmAdapter;
import equipment_fyk.autoRule.RuleCondition;
import equipment_fyk.autoRule.TemperatureCondition;
import equipment_fyk.autoRule.TimeCondition;
import equipment_fyk.controllableDevice.ElectricWindow;
import equipment_fyk.group.DeviceGroup;
import equipment_fyk.homeAppliances.RangeHood;
import equipment_fyk.three.ThirdPartyAlarm;
import equipment_fyk.three.ThirdPartyDevice;
import room.RoomConstants;
import strategy.*;
import system_FYK.SmartHomeControlSystem;

import java.time.LocalDateTime;
import java.util.Map;

public class TestPattern {
    public static void main(String[] args){
        // 测试系统初始化
        System.out.println("==================== 测试系统初始化 ====================");
        SmartHomeControlSystem smartHomeControlSystem = new SmartHomeControlSystem();
        // 创建设备
        String airConditionerId = smartHomeControlSystem.addEquipment("客厅空调", EquipmentConstants.AIR_CONDITIONER);
        String curtainId = smartHomeControlSystem.addEquipment("客厅窗帘", EquipmentConstants.ELECTRIC_CURTAIN);
        String temperatureAndHumiditySensorId = smartHomeControlSystem.addEquipment("客厅温度湿度传感器", EquipmentConstants.TEMPERATURE_AND_HUMIDITY_SENSOR);
        String alarmId = smartHomeControlSystem.addEquipment("客厅闹钟系统", EquipmentConstants.ALARM);
        String windowId = smartHomeControlSystem.addEquipment("客厅电动窗户", EquipmentConstants.ELECTRIC_WINDOW);
        String rangeHoodId = smartHomeControlSystem.addEquipment("客厅抽油烟机", EquipmentConstants.RANGE_HOOD);
        String lampId = smartHomeControlSystem.addEquipment("客厅灯", EquipmentConstants.LAMP);
        String tvId = smartHomeControlSystem.addEquipment("客厅电视", EquipmentConstants.SMART_TV);
        String heaterId = smartHomeControlSystem.addEquipment("热水器", EquipmentConstants.ELECTRIC_WATER_HEATER);
        smartHomeControlSystem.addEquipmentGroup("灯光设备组",new DeviceGroup("灯光设备组"));
        Map<String,Equipment> equipments = smartHomeControlSystem.getEquipments();
        String[] equipmentNames = equipments.keySet().toArray(new String[0]);
        System.out.println("系统已添加的设备有：");
        for(String equipmentName: equipmentNames){
            System.out.println(equipmentName + " : " + equipments.get(equipmentName));
        }
        Map<String,DeviceGroup> deviceGroups = smartHomeControlSystem.getDeviceGroups();
        String[] deviceGroupNames = deviceGroups.keySet().toArray(new String[0]);
        System.out.println("系统已添加的设备组有：");
        for(String deviceGroupName: deviceGroupNames){
            System.out.println(deviceGroupName + " : " + deviceGroups.get(deviceGroupName));
        }
       smartHomeControlSystem.addEquipmentToGroup(lampId, "灯光设备组");
       String roomId = smartHomeControlSystem.addRoom("客厅", RoomConstants.BED_ROOM);
       smartHomeControlSystem.addEquipmentToRoom(roomId,tvId);

        System.out.println("==================== 第三方适配测试 ====================");
       //测试适配第三方设备
       ThirdPartyDevice thirdPartyDevice = new ThirdPartyAlarm();
       DeviceAdapter deviceAdapter = new alarmAdapter();
       smartHomeControlSystem.registerDeviceAdapter(deviceAdapter);
       String partyAlarmId = smartHomeControlSystem.integrateThirdPartyDevice(thirdPartyDevice,"alarmAdapter");
       smartHomeControlSystem.controlSingleEquipment(partyAlarmId,"打开");
        smartHomeControlSystem.addEquipmentToRoom(roomId,partyAlarmId);


       //自动化测试
        System.out.println("==================== 自动化测试 ====================");
        RuleCondition temperatureCondition = new TemperatureCondition(">", 28.0);
        RuleCondition timeCondition = new TimeCondition(20);
        System.out.println("设置自动化规则：当温度大于28摄氏度时，打开客厅空调");
        smartHomeControlSystem.setAutomation(alarmId,curtainId,"close",timeCondition);
        System.out.println("设置自动化规则：当时间为20时，关闭客厅窗帘");
        smartHomeControlSystem.setAutomation(temperatureAndHumiditySensorId,airConditionerId, "open", temperatureCondition);
        System.out.println("设置温度为25摄氏度");
        smartHomeControlSystem.getEquipments().get(temperatureAndHumiditySensorId).setProperty("temperature", 25.0);
        System.out.println("设置温度为29摄氏度");
        smartHomeControlSystem.getEquipments().get(temperatureAndHumiditySensorId).setProperty("temperature", 29.0);
        System.out.println("设置时间为20:00");
        smartHomeControlSystem.getEquipments().get(alarmId).setProperty("time", LocalDateTime.of(2023, 12, 25, 20, 0).toString());

         //测试语音以及客户端控制
        System.out.println("==================== 客户端控制测试 ====================");
        smartHomeControlSystem.controlSingleEquipment(heaterId, "打开");
        smartHomeControlSystem.controlSingleEquipment(airConditionerId, "打开");
        smartHomeControlSystem.controlEquipmentGroup("灯光设备组", "关闭");

        // 7. 语音控制测试（严格匹配正则规则：打开/关闭 + 所有房间室 + 灯光/空调/电视）
        System.out.println("\n==================== 语音控制测试 ====================");
        // 匹配正则：打开 + 所有房间 + 灯光
        smartHomeControlSystem.processVoiceCommand("打开所有房间灯光");
        // 匹配正则：关闭 + 所有房间 + 空调
        smartHomeControlSystem.processVoiceCommand("关闭所有房间空调");
        // 匹配正则：打开 + 所有房间 + 电视
        smartHomeControlSystem.processVoiceCommand("打开所有房间电视");
        // 匹配正则：关闭 + 所有房间 + 电视
        smartHomeControlSystem.processVoiceCommand("关闭所有房间电视");

       //测试策略模式
       System.out.println("\n==================== 策略模式测试 ====================");
       Equipment electricWindow = equipments.get(windowId);
       Equipment rangeHood = equipments.get(rangeHoodId);
       String windowStrategyName = "窗口策略";
       Strategy openWindowStrategy = new OpenWindowStrategy(windowStrategyName, (ElectricWindow) electricWindow);
       String rangeHoodStrategyName = "抽油烟机策略";
       Strategy openRangeHoodStrategy = new OpenRangeHoodStrategy(rangeHoodStrategyName, (RangeHood) rangeHood);
       String smokeHandleStrategyName = "烟雾处理策略环境";
       StrategyContext smokeHandleStrategyContext = new SmokeHandleContext(smokeHandleStrategyName);
       //添加策略环境
       smartHomeControlSystem.addStrategyContext(smokeHandleStrategyName,smokeHandleStrategyContext);
       //添加抽油烟机策略
       smartHomeControlSystem.addStrategy(smokeHandleStrategyName, "抽油烟机策略", openRangeHoodStrategy);
       //添加窗口策略
       smartHomeControlSystem.addStrategy(smokeHandleStrategyName, "窗口策略", openWindowStrategy);
       //设置抽油烟机策略
       smartHomeControlSystem.setStrategy(smokeHandleStrategyName, "抽油烟机策略");
        System.out.println("发现烟雾");
       //执行策略
       smartHomeControlSystem.executeStrategy(smokeHandleStrategyName);
       //设置窗口策略
       smartHomeControlSystem.setStrategy(smokeHandleStrategyName, "窗口策略");
        System.out.println("发现烟雾");
       //执行窗口策略
       smartHomeControlSystem.executeStrategy(smokeHandleStrategyName);
    }
}
