package room;

import room.roomConfig_HYH.BedroomConfig;
import room.roomConfig_HYH.RoomConfig;

public class Bedroom extends Room{

     /**
     * 卧室构造函数
     */
    public Bedroom() {
        super();
        setRoomConfig(new BedroomConfig());
    }

     /**
     * 卧室构造函数
     * @param id 卧室ID
     * @param name 卧室名称
     */
    public Bedroom(String id, String name) {
        super(id, name);
        setRoomConfig(new BedroomConfig(id,name));
    }

    @Override
    public void start(){
        System.out.println("该卧室设备开始工作");
    }
     @Override
    public void stop(){
        System.out.println("该卧室设备停止工作");
    }

    @Override
    public void changeRoomConfigSelf(RoomConfig roomConfig) {

    }

}
