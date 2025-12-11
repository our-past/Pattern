package room_fyk.roomConfig;

import room_fyk.Room;

public class BedroomConfig extends RoomConfig{
    /**
     * 卧室配置构造函数
     */
    public BedroomConfig() {
    }
    /**
     * 卧室配置构造函数
     * @param id 卧室配置ID
     * @param name 卧室配置名称
     */
    public BedroomConfig(String id, String name) {
        super(id, name);
    }
     /**
     * 卧室配置改变
     * @param room 房间
     */
    @Override
    public void changeRoomConfig(Room room) {
    }

    @Override
     protected void initDefaultProperties() {
        super.initDefaultProperties();

    }

    @Override
    public BedroomConfig createCopy(String newId,String newName){
        BedroomConfig copy = new BedroomConfig(newId, newName);
        copy.getProperties().putAll(this.getProperties());
        copy.setDescription(this.getDescription());
        return copy;
    }
}
