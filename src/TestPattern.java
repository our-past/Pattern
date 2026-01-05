
import equipment_fyk.Equipment;
import equipment_fyk.EquipmentConstants;
import equipment_fyk.adapter_CD.DeviceAdapter;
import equipment_fyk.adapter_CD.alarmAdapter;
import equipment_fyk.autoRule_twy.RuleCondition;
import equipment_fyk.autoRule_twy.TemperatureCondition;
import equipment_fyk.autoRule_twy.TimeCondition;
import equipment_fyk.controllableDevice.ElectricWindow;
import equipment_fyk.group_cd.DeviceGroup;
import equipment_fyk.homeAppliances.RangeHood;
import equipment_fyk.three_cd.ThirdPartyAlarm;
import equipment_fyk.three_cd.ThirdPartyDevice;

import equipment_fyk.decorator_HYH.BrightnessFadeDecorator;
import equipment_fyk.decorator_HYH.ColorAdjustDecorator;
import notifier_hyh.AlarmNotifier;
import notifier_hyh.PhoneNotifier;
import notifier_hyh.PropertyNotifier;
import room.RoomConstants;
import room.roomConfig_HYH.RoomSceneState;
import room.roomConfig_HYH.selfMode;
import strategy_twy.*;
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
        smartHomeControlSystem.setAutomation(alarmId,curtainId,"关闭",timeCondition);
        System.out.println("设置自动化规则：当时间为20时，关闭客厅窗帘");
        smartHomeControlSystem.setAutomation(temperatureAndHumiditySensorId,airConditionerId, "打开", temperatureCondition);
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


        //测试状态模式
        System.out.println("\n==================== hyh的状态模式测试 ====================");
        // 创建卧室
        String bedroomId = smartHomeControlSystem.addRoom("主卧室", RoomConstants.BED_ROOM);
        // 添加设备到卧室
        smartHomeControlSystem.addEquipmentToRoom(bedroomId, lampId);
        smartHomeControlSystem.addEquipmentToRoom(bedroomId, airConditionerId);
        smartHomeControlSystem.addEquipmentToRoom(bedroomId, windowId);

        // 设置卧室场景模式 - 日间模式
        System.out.println("=== 日间模式设备状态 ===");
        smartHomeControlSystem.setRoomScene(bedroomId, "日间模式");
        // 日间模式预期状态：灯光亮度100%、空调26℃、窗户打开

        System.out.println("\n=== 起居模式设备状态 ===");
        // 切换到起居模式
        smartHomeControlSystem.setRoomScene(bedroomId, "起居模式");
        // 起居模式预期状态：灯光亮度70%、空调24℃、窗户半开

        System.out.println("\n=== 睡眠模式设备状态 ===");
        // 切换到睡眠模式
        smartHomeControlSystem.setRoomScene(bedroomId, "睡眠模式");
        // 睡眠模式预期状态：灯光关闭、空调28℃、窗户关闭

        // 创建另一个房间并复制场景
        String guestRoomId = smartHomeControlSystem.addRoom("客房", RoomConstants.BED_ROOM);
        // 复制主卧室的所有场景配置（包含日间/起居/睡眠模式）
        smartHomeControlSystem.copyScenes(bedroomId, guestRoomId);
        // 添加相同类型设备到客房
        smartHomeControlSystem.addEquipmentToRoom(guestRoomId, lampId);
        smartHomeControlSystem.addEquipmentToRoom(guestRoomId, airConditionerId);
        smartHomeControlSystem.addEquipmentToRoom(guestRoomId, windowId);

        // 客房应用睡眠模式（继承主卧室的场景配置）
        System.out.println("\n=== 客房应用复制的睡眠模式 ===");
        smartHomeControlSystem.setRoomScene(guestRoomId, "睡眠模式");


        // 客房应用起居模式（继承主卧室的场景配置）
        System.out.println("\n=== 客房应用复制的起居模式 ===");
        smartHomeControlSystem.setRoomScene(guestRoomId, "起居模式");

        //自定义模式
        System.out.println("\n=== 客房应用自定义模式 ===");
        RoomSceneState sceneState = new selfMode("自定义模式");
        sceneState.setProperty(EquipmentConstants.AIR_CONDITIONER, "设置温度 27");
        sceneState.setProperty(EquipmentConstants.LAMP, "打开");
        smartHomeControlSystem.setRoomSceneMode(guestRoomId,sceneState);
        smartHomeControlSystem.setRoomScene(guestRoomId, "自定义模式");


        //测试装饰器模式
        System.out.println("\n==================== hyh的装饰器模式测试 ====================");


        // 1. 注册默认装饰器到系统
        smartHomeControlSystem.addDefaultDecorator("colorAdjust", new ColorAdjustDecorator());
        smartHomeControlSystem.addDefaultDecorator("brightnessFade", new BrightnessFadeDecorator());
        System.out.println("===== 装饰器注册完成 =====");

        // 2. 添加基础灯光设备
        String lightId = smartHomeControlSystem.addEquipment("客厅主灯",EquipmentConstants.LAMP );
        System.out.println("\n===== 基础设备状态 =====");
        smartHomeControlSystem.controlSingleEquipment(lightId, "打开");
        System.out.println("设备描述：" + smartHomeControlSystem.getEquipments().get(lightId).getDescription());

        // 3. 为灯光添加颜色调节功能
        smartHomeControlSystem.decorateEquipment(lightId, "colorAdjust");
        System.out.println("\n===== 添加颜色调节功能后 =====");
        // 调用颜色调节方法（需要强制转换为具体装饰器类型）
        ColorAdjustDecorator colorLight = (ColorAdjustDecorator) smartHomeControlSystem.getEquipments().get(lightId);
        colorLight.setColor("暖黄色");
        smartHomeControlSystem.controlSingleEquipment(lightId, "打开");
        System.out.println("设备描述：" + colorLight.getDescription());

        // 4. 继续为灯光添加亮度渐变功能（多层装饰）
        smartHomeControlSystem.decorateEquipment(lightId, "brightnessFade");
        System.out.println("\n===== 添加亮度渐变功能后 =====");
        // 调用亮度渐变方法
        BrightnessFadeDecorator advancedLight = (BrightnessFadeDecorator) smartHomeControlSystem.getEquipments().get(lightId);
        advancedLight.setFadeDuration(3); // 设置3秒渐变
        smartHomeControlSystem.controlSingleEquipment(lightId, "打开");
        System.out.println("设备描述：" + advancedLight.getDescription());

        //测试观察者模式
        System.out.println("\n==================== hyh的观察者模式测试 ====================");
        // 1. 创建需要通知的设备（温感+烟感）
        String tempSensorId = smartHomeControlSystem.addEquipment("客厅温感", EquipmentConstants.TEMPERATURE_AND_HUMIDITY_SENSOR);
        String smokeSensorId = smartHomeControlSystem.addEquipment("厨房烟感", EquipmentConstants.SMART_SMOKE_SENSOR);

        // 2. 创建观察者（手机/物业/警报）
        PhoneNotifier phoneNotifier = new PhoneNotifier();
        PropertyNotifier propertyNotifier = new PropertyNotifier();
        AlarmNotifier alarmNotifier = new AlarmNotifier();

        // 3. 为设备注册观察者（可灵活组合）
        smartHomeControlSystem.setNotifiers(tempSensorId, phoneNotifier);  // 温感只通知手机
        smartHomeControlSystem.setNotifiers(tempSensorId, alarmNotifier);  // 温感同时触发警报
        smartHomeControlSystem.setNotifiers(smokeSensorId, phoneNotifier); // 烟感通知手机
        smartHomeControlSystem.setNotifiers(smokeSensorId, propertyNotifier); // 烟感通知物业
        smartHomeControlSystem.setNotifiers(smokeSensorId, alarmNotifier); // 烟感触发警报

        // 4. 模拟设备状态变更，触发通知
        System.out.println("===== 模拟温感设备温度过高 =====");
        smartHomeControlSystem.getEquipments().get(tempSensorId).setProperty("temperature", 40); // 超过35℃，触发通知

        System.out.println("\n===== 模拟烟感设备检测到烟雾 =====");
        smartHomeControlSystem.getEquipments().get(smokeSensorId).setProperty("smokeDetected", true); // 检测到烟雾，触发通知

        System.out.println("\n===== 模拟烟感设备烟雾消散 =====");
        smartHomeControlSystem.getEquipments().get(smokeSensorId).setProperty("smokeDetected", false); // 烟雾消散，触发恢复通知

    }
}
