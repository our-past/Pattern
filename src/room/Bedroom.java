package room;

import equipment_fyk.Equipment;

public class Bedroom extends Room{

     /**
     * 卧室构造函数
     */
    public Bedroom() {
        super();
    }

     /**
     * 卧室构造函数
     * @param id 卧室ID
     * @param name 卧室名称
     */
    public Bedroom(String id, String name) {
        super(id, name);
    }

    @Override
    public void start(){
        System.out.println("卧室设备开始工作");
        for(Equipment equipment:equipments.values()){
            equipment.start();
        }
    }
     @Override
    public void stop(){
        System.out.println("卧室设备停止工作");
        for(Equipment equipment:equipments.values()){
            equipment.stop();
        }
    }

}
