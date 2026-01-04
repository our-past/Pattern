package room;

import equipment_fyk.Equipment;
import hyh.scene.DayMode;
import hyh.scene.LivingMode;
import hyh.scene.RoomSceneState;
import hyh.scene.SleepMode;
import room.roomConfig_HYH.RoomConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public abstract class Room {
    private String id;
    private String name;
    private RoomConfig roomConfig;
    private RoomSceneState currentState; // 当前场景状态
    private List<RoomSceneState> supportedScenes = new ArrayList<>(); // 支持的场景集合

    HashMap<String, Equipment> equipments;

    abstract public void start();

    abstract public void stop();



     public Room() {
        equipments = new HashMap<String, Equipment>();
         initDefaultScenes(); // 初始化默认场景
         this.currentState = new DayMode(); // 默认场景为日间模式
    }

    public Room(String id, String name) {
        this.id = id;
        this.name = name;
        equipments = new HashMap<String, Equipment>();
        initDefaultScenes(); // 初始化默认场景
        this.currentState = new DayMode(); // 默认场景为日间模式
        supportedScenes = new ArrayList<>();
        supportedScenes.add(new DayMode()); // 日间模式
        supportedScenes.add(new SleepMode()); // 睡眠模式
        supportedScenes.add(new LivingMode());
        this.currentState = supportedScenes.get(0); // 默认场景
    }

    /**
     * 初始化默认支持的场景模式
     */
    private void initDefaultScenes() {
        supportedScenes.add(new DayMode());
        supportedScenes.add(new SleepMode());
        supportedScenes.add(new LivingMode());
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
     * 为房间添加新场景
     * @param scene 场景模式
     */
    public void addScene(RoomSceneState scene) {
        supportedScenes.add(scene);
    }

    /**
     * 切换房间场景模式
     * @param sceneName 场景名称
     */
    public void setScene(String sceneName) {
        for (RoomSceneState scene : supportedScenes) {
            if (scene.getSceneName().equals(sceneName)) {
                currentState.exit(this); // 退出当前场景
                currentState = scene;    // 更新当前场景
                currentState.enter(this); // 进入新场景
                currentState.execute(this); // 执行场景逻辑
                return;
            }
        }
        System.out.println("场景模式不存在: " + sceneName);
    }

    /**
     * 从其他房间复制场景模式
     * @param otherRoom 源房间
     */
    public void copyScenesFrom(Room otherRoom) {
        // 避免重复添加相同场景
        for (RoomSceneState scene : otherRoom.supportedScenes) {
            boolean isExist = false;
            for (RoomSceneState existingScene : this.supportedScenes) {
                if (existingScene.getSceneName().equals(scene.getSceneName())) {
                    isExist = true;
                    break;
                }
            }
            if (!isExist) {
                this.supportedScenes.add(scene);
            }
        }
        System.out.println("已从" + otherRoom.getName() + "复制场景模式");
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
    /**
     * 获取当前场景状态
     * @return 当前场景
     */
    public RoomSceneState getCurrentState() {
        return currentState;
    }

    /**
     * 获取设备列表（供场景模式调用）
     * @return 设备集合
     */
    public HashMap<String, Equipment> getEquipments() {
        return equipments;
    }

}
