package room.roomConfig_HYH;

import room.Room;

import java.util.HashMap;
import java.util.Map;
/**
 * 房间配置类
 * 用于存储和管理房间的配置信息
 *
 * 实现第6个功能，在这个类上写完整，然后要多写一个bedroomConfig类，用于存储和管理卧室的配置信息，并且基础这个类实现状态模式
 */
public class RoomConfig {
    private String id;
    private String name;
    private String description;

    /**
     * 房间配置构造函数
     */
    public RoomConfig() {
    }

    public RoomConfig(String id, String name) {
        this.id = id;
        this.name = name;
        initDefaultProperties();
    }

    /**
     * 初始化默认配置属性
     */
    protected void initDefaultProperties(){
    }

    /**
     * 房间配置改变
     * 需要写,适配Room类的方法
     * @param room 房间
     */
    public void changeRoomConfig(Room room){

    }

    /**
     * 复用
     */
    public RoomConfig createCopy(){
        return this;
    }

    /**
     * 复用(创建新的房间配置副本)
     * 需要写一个新的构造函数，用于创建新的房间配置副本
     */
    public RoomConfig createCopy(String newId,String newName){
        return null;
    }


    /**
     * 房间配置设置ID
     * @param id 房间配置ID
     */
    public void setId(String id) {
        this.id = id;
    }
     /**
     * 房间配置获取ID
     * @return 房间配置ID
     */
    public String getId() {
        return id;
    }
     /**
     * 房间配置设置名称
     * @param name 房间配置名称
     */
    public void setName(String name) {
        this.name = name;
    }
     /**
     * 房间配置获取名称
     * @return 房间配置名称
     */
    public String getName() {
        return name;
    }
    /**
     * 房间配置设置描述
     * @param description 房间配置描述
     */
    public void setDescription(String description) {
        this.description = description;
    }
     /**
     * 房间配置获取描述
     * @return 房间配置描述
     */
    public String getDescription() {
        return description;
    }

}
