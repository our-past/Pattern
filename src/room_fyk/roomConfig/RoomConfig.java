package room_fyk.roomConfig;

import room_fyk.Room;

import java.util.HashMap;
import java.util.Map;

public class RoomConfig {
    private String id;
    private String name;
    private String description;

    private final Map<String,Object> properties = new HashMap<>();

    // 设备配置常量
    public static final String PROP_TEMPERATURE = "temperature";
    public static final String PROP_LIGHT_BRIGHTNESS = "lightBrightness";
    public static final String PROP_CURTAIN_POSITION = "curtainPosition";
    public static final String PROP_HUMIDITY = "humidity";
    public static final String PROP_AIR_CONDITIONER_MODE = "airConditionerMode";

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
        setProperty(PROP_TEMPERATURE, 22.0);
        setProperty(PROP_LIGHT_BRIGHTNESS, 50);
        setProperty(PROP_CURTAIN_POSITION, 0.5);
        setProperty(PROP_HUMIDITY, 50);
        setProperty(PROP_AIR_CONDITIONER_MODE, "cool");
    }

    /**
     * 房间配置改变
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
     */
    public RoomConfig createCopy(String newId,String newName){
        RoomConfig copy = new RoomConfig(newId, newName);
        copy.properties.putAll(this.properties);
        copy.description = this.description;
        return copy;
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

     /**
     * 房间配置设置属性值
     * @param key 属性键
     * @param value 属性值
     */
    public <T> void setProperty(String key, T value) {
        properties.put(key, value);
    }

     /**
     * 房间配置获取属性值
     * @param key 属性键
     * @return 属性值
     */
     @SuppressWarnings("unchecked")
    public <T> T getProperty(String key) {
        return (T) properties.get(key);
    }

    public Map<String,Object> getProperties(){
        return properties;
    }

}
