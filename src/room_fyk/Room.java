package room_fyk;

import equipment.Equipment;
import room_fyk.roomConfig.RoomConfig;

import java.util.HashMap;

public abstract class Room {
    private String id;
    private String name;
    private RoomConfig roomConfig;

    HashMap<String, Equipment> equipments;

    abstract public void start();

    abstract public void stop();



     public Room() {
        equipments = new HashMap<String, Equipment>();
    }

    public Room(String id, String name) {
        this.id = id;
        this.name = name;
        equipments = new HashMap<String, Equipment>();
    }
     /**
     * 房间添加设备
     * @param equipment 设备
     */
    public void addEquipment(Equipment equipment) {
        equipments.put(equipment.getId(), equipment);
    }

     /**
     * 房间获取设备
     * @param id 设备ID
     * @return 设备
     */
    public Equipment getEquipmentById(String id) {
        return equipments.get(id);
    }

    /**
     * 房间获取设备
     * @param name 设备名称
     * @return 设备
     */
    public Equipment getEquipmentByName(String name) {
        for (Equipment equipment : equipments.values()) {
            if (equipment.getName().equals(name)) {
                return equipment;
            }
        }
        return null;
    }

    /**
     * 房间改变配置自身(可在子类中重写)
     * @param roomConfig 房间配置
     */
    public void changeRoomConfigSelf(RoomConfig roomConfig) {

    }

    /**
     * 房间改变配置
     * @param roomConfig 房间配置
     */
    public final void changeRoomConfig(RoomConfig roomConfig) {
        changeRoomConfigSelf(roomConfig);
        setRoomConfig(roomConfig);
        roomConfig.changeRoomConfig(this);
    }

     /**
     * 房间设置ID
     * @param id 房间ID
     */
    public void setId(String id) {
        this.id = id;
    }
     /**
     * 房间获取ID
     * @return 房间ID
     */
    public String getId() {
        return id;
    }
     /**
     * 房间设置名称
     * @param name 房间名称
     */
    public void setName(String name) {
        this.name = name;
    }
     /**
     * 房间获取名称
     * @return 房间名称
     */
    public String getName() {
        return name;
    }

     /**
     * 房间设置配置
     * @param roomConfig 房间配置
     */
    public void setRoomConfig(RoomConfig roomConfig) {
        this.roomConfig = roomConfig;
    }
     /**
     * 房间获取配置
     * @return 房间配置
     */
    public RoomConfig getRoomConfig() {
        return roomConfig;
    }
}
