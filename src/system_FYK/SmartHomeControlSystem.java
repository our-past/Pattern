package system_FYK;

import cd.DeviceGroup;
import common.LangDetectFormatRegexConstants;
import equipment.Equipment;
import equipment.adapter_CD.DeviceAdapter;
import equipment.decorator_HYH.EquipmentDecorator;
import room.Room;
import room.factory.RoomFactory;
import room.roomConfig_HYH.RoomConfig;
import equipment.factory.EquipmentFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static system_FYK.SystemConstants.*;
import static common.LanguageTypeConstants.*;

/**
 * 智能家居中央控制系统
 * 负责设备管理、语音指令解析和执行
 */
public class SmartHomeControlSystem {
    private static volatile SmartHomeControlSystem instance;
    // 设备工厂
    private final EquipmentFactory equipmentFactory = EquipmentFactory.getInstance();
    // 房间工厂
    private final RoomFactory roomFactory = RoomFactory.getInstance();
    // 所有设备的映射
    private final Map<String, Equipment> equipments = new HashMap<>();
    private Integer nextEquipmentId = 1;
    // 设备分类管理
    private final Map<String, DeviceGroup> deviceGroups = new HashMap<>();
    private  Integer nextDeviceGroupId = 1;
    // 房间分类管理
    private final Map<String, Room> roomGroups = new HashMap<>();
    private  Integer nextRoomGroupId = 1;
    // 房间配置管理
    private final Map<String, RoomConfig> roomConfigs = new HashMap<>();
    private  Integer nextRoomConfigId = 1;
    // 设备适配器管理
    private final Map<String, DeviceAdapter> deviceAdapters = new HashMap<>();
    // 设备装饰器管理
    private final Map<String, EquipmentDecorator> equipmentDecorators = new HashMap<>();



    public SmartHomeControlSystem() {
    }

    /**
     * 获取单例实例
     */
    public static SmartHomeControlSystem getInstance() {
        if (instance == null) {
            synchronized (SmartHomeControlSystem.class) {
                if (instance == null) {
                    instance = new SmartHomeControlSystem();
                }
            }
        }
        return instance;
    }

    /**
     * 添加设备到系统
     */
    public String addEquipment(String name,String type) {
        String id = EQUIPMENT_ID_PREFIX + getNextEquipmentId().toString();
        Equipment equipment = equipmentFactory.createEquipment(type, id, name);
        equipments.put(id, equipment);
        System.out.println("设备已添加：" + name);
        return id;
    }

    /**
     * 添加设备到指定类型组
     */
    public String addEquipmentToGroup(String equipmentId,String groupName) {
        // 如果设备不存在
        if (!equipments.containsKey(equipmentId)) {
            System.out.println("该设备不存在，无法添加到设备组。请先添加设备。");
            return null;
        }
        // 如果类型组不存在，创建新的设备组
        if (!deviceGroups.containsKey(groupName)) {
            System.out.println("该设备组不存在，现在帮您添加到系统中");
            addEquipmentGroup(groupName, new DeviceGroup(groupName));
        }
        // 添加设备到对应类型组
        deviceGroups.get(groupName).addComponent(equipments.get(equipmentId));
        System.out.println("设备已添加到设备组：" + groupName);
        return groupName;
    }

    /**
     * 添加设备组到系统
     */
    public String addEquipmentGroup(String groupName, DeviceGroup deviceGroup) {
        deviceGroups.put(groupName, deviceGroup);
        System.out.println("设备组已添加：" + groupName);
        return groupName;
    }

     /**
     * 添加房间到系统
     */
    public String addRoom(String roomName,String roomType) {
        String roomId = ROOM_GROUP_ID_PREFIX + getNextRoomGroupId().toString();
        Room room = roomFactory.createRoom(roomType,roomId, roomName);
        roomGroups.put(roomId, room);
        System.out.println("房间已添加：" + roomName);
        return roomId;
    }

    public void addEquipmentToRoom(String roomId, String equipmentId) {
        if(!equipments.containsKey(equipmentId)) {
            System.out.println("该设备不存在，无法添加到房间。请先添加设备。");
            return;
        }
        if (!roomGroups.containsKey(roomId)) {
            System.out.println("房间不存在：" + roomId+"无法添加设备，请先添加房间");
            return;
        }
        roomGroups.get(roomId).addEquipment(equipments.get(equipmentId));
        System.out.println("设备已添加到房间：" + roomGroups.get(roomId).getName());
    }

    /**
     * 注册设备适配器
     * @param adapter 设备适配器
     */
    public void registerDeviceAdapter(DeviceAdapter adapter) {
        deviceAdapters.put(adapter.getClass().getSimpleName(), adapter);
        System.out.println("设备适配器已注册：" + adapter.getClass().getSimpleName());
    }

    /**
     * 集成第三方设备
     * @param thirdPartyDevice 第三方设备实例
     * @param deviceType 设备类型
     * @return 系统分配的设备ID
     */
    public String integrateThirdPartyDevice(Object thirdPartyDevice, String deviceType) {
        // 查找兼容的适配器
        DeviceAdapter adapter = findCompatibleAdapter(deviceType);
        if (adapter == null) {
            System.out.println("未找到兼容的设备适配器：" + deviceType);
            return null;
        }

        // 生成系统设备ID和名称
        String systemId = EQUIPMENT_ID_PREFIX + getNextEquipmentId().toString();
        String systemName = "第三方设备_" + systemId;

        // 适配第三方设备
        Equipment adaptedEquipment = adapter.adapt(thirdPartyDevice, systemId, systemName);
        if (adaptedEquipment == null) {
            System.out.println("设备适配失败");
            return null;
        }

        // 将适配后的设备添加到系统
        equipments.put(systemId, adaptedEquipment);
        System.out.println("第三方设备已集成：" + systemName);
        return systemId;
    }

    /**
     * 查找兼容的设备适配器
     * @param deviceType 设备类型
     * @return 兼容的适配器
     */
    private DeviceAdapter findCompatibleAdapter(String deviceType) {
        for (DeviceAdapter adapter : deviceAdapters.values()) {
            if (adapter.isCompatible(deviceType)) {
                return adapter;
            }
        }
        return null;
    }



    /**
     * 语音指令解析和执行
     */
    public void processVoiceCommand(String voiceCommand) {
        System.out.println("收到语音指令：" + voiceCommand);

        // 解析语音指令
        Command command = parseVoiceCommand(voiceCommand);

        if (command != null) {
            // 执行指令
            executeCommand(command);
        } else {
            System.out.println("无法识别的语音指令：" + voiceCommand);
        }
    }

    /**
     * 解析语音指令
     */
    private Command parseVoiceCommand(String voiceCommand) {
        // 定义指令模式
        Pattern pattern1 = Pattern.compile(LangDetectFormatRegexConstants.VOICE_COMMAND_FORMAT_REGEX);
        Matcher matcher1 = pattern1.matcher(voiceCommand);

        if (matcher1.find()) {
            String action = matcher1.group(1);
            String room = matcher1.group(2);
            String deviceType = matcher1.group(3);

            // 转换设备类型为系统内部类型
            String systemRoom = mapRoomType(room);
            String systemType = mapDeviceType(deviceType);

            return new Command(action, systemType, systemRoom);
        }

        return null;
    }

    private String mapRoomType(String roomType){
        return switch (roomType) {
            case "所有房间", "所有" -> TYPE_ALL_ROOM;
            case "卧室" -> TYPE_BEDROOM;
            case "客厅" -> TYPE_LIVING_ROOM;
            case "厨房" -> TYPE_KITCHEN;
            case "浴室" -> TYPE_BATHROOM;
            default -> roomType;
        };
    }

    /**
     * 将自然语言设备类型映射到系统内部类型
     */
    private String mapDeviceType(String naturalType) {
        return switch (naturalType) {
            case "灯光" -> TYPE_LIGHT;
            case "电视" -> TYPE_TV;
            case "空调" -> TYPE_AIR_CONDITIONER;
            case "设备" -> TYPE_ALL_EQUIPMENT;
            default -> naturalType;
        };
    }

    /**
     * 执行指令
     */
    private void executeCommand(Command command) {
        System.out.println("执行指令：" + command.action + " " + (command.room.equals(TYPE_ALL_ROOM) ? "所有房间" : command.room) + "的" + command.deviceType);

        if (command.deviceType.equals(TYPE_ALL_EQUIPMENT)&&command.room.equals(TYPE_ALL_ROOM)) {
            // 操作所有设备
            for (Equipment equipment : equipments.values()) {
                executeAction(equipment, command.action);
            }
        }else if (command.room.equals(TYPE_ALL_ROOM)) {
            // 操作所有房间的特定类型设备
            for (Room room : roomGroups.values()) {
                executeAction(room, command.action);
            }
        } else {
            // 操作特定类型的所有设备
            DeviceGroup group = deviceGroups.get(command.deviceType);
            if (group != null) {
                executeAction(group, command.action);
            } else {
                System.out.println("未找到设备类型：" + command.deviceType);
            }
        }
    }

    /**
     * 执行具体操作
     */
    private void executeAction(Equipment equipment, String action) {
        if (action.equals("打开")) {
            equipment.start();
        } else if (action.equals("关闭")) {
            equipment.stop();
        }
    }
    /**
     * 执行具体操作
     */
    private void executeAction(Room room, String action) {
        if (action.equals("打开")) {
            room.start();
        } else if (action.equals("关闭")) {
            room.stop();
        }
    }

     /**
     * 添加默认装饰器
     */
    public void addDefaultDecorator(String decoratorType,EquipmentDecorator equipmentDecorator) {
        equipmentDecorators.put(decoratorType, equipmentDecorator);
    }

    /**
     * 对设备进行装饰
     */
     public void decorateEquipment(String equipmentId,String decoratorType) {
        Equipment equipment = equipments.get(equipmentId);
        if (equipment != null) {
            EquipmentDecorator decorator = equipmentDecorators.get(decoratorType);
            if (decorator != null) {
                EquipmentDecorator decoratedEquipment = decorator.createEquipmentDecorator(equipment);
                equipments.put(equipment.getId(), decoratedEquipment);
            } else {
                System.out.println("未找到装饰器类型：" + decoratorType);
            }
        } else {
            System.out.println("未找到设备ID：" + equipmentId);
        }
    }

    /**
     * 设置自动化功能
     */
     public void setAutomation() {
    }

    /**
     * 获取下一个设备ID
     * @return 下一个设备ID
     */
    public Integer getNextEquipmentId() {
        return nextEquipmentId++;
    }

    /**
     * 获取下一个设备组ID
     * @return 下一个设备组ID
     */
    public Integer getNextDeviceGroupId() {
        return nextDeviceGroupId++;
    }
    /**
     * 获取下一个房间组ID
     * @return 下一个房间组ID
     */
    public Integer getNextRoomGroupId() {
        return nextRoomGroupId++;
    }
    /**
     * 获取下一个房间配置ID
     * @return 下一个房间配置ID
     */
    public Integer getNextRoomConfigId() {
        return nextRoomConfigId++;
    }

    /**
     * 获取所有设备
     * @return 所有设备映射
     */
    public Map<String,Equipment> getEquipments() {
        return equipments;
    }

     /**
     * 获取所有设备组
     * @return 所有设备组映射
     */
     public Map<String,DeviceGroup> getDeviceGroups() {
        return deviceGroups;
    }

    /**
     * 获取所有房间组
     * @return 所有房间组映射
     */
    public Map<String,Room> getRoomGroups() {
        return roomGroups;
    }

    /**
     * 获取所有房间配置
     * @return 所有房间配置映射
     */
    public Map<String,RoomConfig> getRoomConfigs() {
        return roomConfigs;
    }

    /**
     * 指令内部类
     */
    private static class Command {
        String action;      // 操作：打开/关闭
        String deviceType;  // 设备类型
        String room;      // 房间类型

        Command(String action, String deviceType, String room) {
            this.action = action;
            this.deviceType = deviceType;
            this.room = room;
        }
    }
}