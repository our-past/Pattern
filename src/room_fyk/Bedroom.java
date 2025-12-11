package room_fyk;

import room_fyk.roomConfig.BedroomConfig;

public class Bedroom extends Room{

     /**
     * 卧室构造函数
     */
    public Bedroom() {
        super();
        this.setRoomConfig(new BedroomConfig());
    }

     /**
     * 卧室构造函数
     * @param id 卧室ID
     * @param name 卧室名称
     */
    public Bedroom(String id, String name) {
        super(id, name);
        this.setRoomConfig(new BedroomConfig(id, name));
    }

    @Override
    public void start(){
        System.out.println("该卧室设备开始工作");
    }
     @Override
    public void stop(){
        System.out.println("该卧室设备停止工作");
    }

}
