
import cd.DeviceGroup;
import equipment.Equipment;
import equipment.EquipmentConstants;
import room.RoomConstants;
import system_FYK.SmartHomeControlSystem;

import java.util.Map;

public class TestPattern {
    public static void main(String[] args){
        SmartHomeControlSystem smartHomeControlSystem = new SmartHomeControlSystem();
        // 创建设备
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
    }
}
