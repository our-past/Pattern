package twy.ten;

import common.LangDetectFormatRegexConstants;

/**
 * 严格匹配语音指令正则规则，仅保留卧室场景，无空调适配器
 * 语音指令格式：(打开|关闭) + (卧室) + (灯光|电视|空调)
 */
public class TestSmartHomeControl {
    public static void main(String[] args) {
        // 1. 获取中央管理器（原有逻辑不变）
        SmartHomeControlSystem controlSystem = SmartHomeControlSystem.getInstance();

        // 2. 初始化卧室设备（类名匹配工厂扫描结果）
        String bedroomLightId = controlSystem.addEquipment("卧室台灯", "Lamp");    // 对应“灯光”
        String bedroomAcId = controlSystem.addEquipment("卧室空调", "AirConditioner");// 对应“空调”
        String bedroomTvId = controlSystem.addEquipment("卧室电视", "SmartTV");    // 对应“电视”

        // 3. 添加设备到设备组（类名与设备类型映射由管理器内部处理）
        controlSystem.addEquipmentToGroup(bedroomLightId, "Lamp");
        controlSystem.addEquipmentToGroup(bedroomAcId, "AirConditioner");
        controlSystem.addEquipmentToGroup(bedroomTvId, "SmartTV");

        // 4. 仅创建卧室房间
        String bedroomId = controlSystem.addRoom("卧室", "Bedroom");

        // 5. 所有设备添加到卧室
        controlSystem.addEquipmentToRoom(bedroomId, bedroomLightId);
        controlSystem.addEquipmentToRoom(bedroomId, bedroomAcId);
        controlSystem.addEquipmentToRoom(bedroomId, bedroomTvId);

        // 6. 客户端控制测试（原有逻辑不变）
        System.out.println("==================== 客户端控制测试 ====================");
        controlSystem.controlSingleEquipment(bedroomLightId, "打开");
        controlSystem.controlSingleEquipment(bedroomAcId, "打开");
        controlSystem.controlEquipmentGroup("Lamp", "关闭");

        // 7. 语音控制测试（严格匹配正则规则：打开/关闭 + 卧室 + 灯光/空调/电视）
        System.out.println("\n==================== 语音控制测试 ====================");
        // 匹配正则：打开 + 卧室 + 灯光
        controlSystem.processVoiceCommand("打开所有房间灯光");
        // 匹配正则：关闭 + 卧室 + 空调
        controlSystem.processVoiceCommand("关闭所有房间空调");
        // 匹配正则：打开 + 卧室 + 电视
        controlSystem.processVoiceCommand("打开所有房间电视");
        // 可选：测试“所有”场景（正则支持）
        // controlSystem.processVoiceCommand("打开所有设备");
    }
}