package equipment_fyk.group;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

import java.util.ArrayList;
import java.util.List;

public  class DeviceGroup extends Equipment implements HomeAppliances {
//    private String groupName;
    private List<Equipment> equipments;
    public DeviceGroup(String groupName) {
        super("设备组", groupName);
        this.equipments = new ArrayList<>();
        setProperty("type", this.getClass().getSimpleName());
    }
    // 添加设备/设备组
    public void addComponent(Equipment equipment ) {
        equipments.add(equipment);
        System.out.println("设备组[" + this.getName() + "]已添加组件："+equipment.getName() );
        setProperty("type", this.getClass().getSimpleName());
    }

    // 移除设备/设备组
    public void removeComponent(Equipment equipment ) {
        equipments.remove(equipment);
        System.out.println("设备组[" + this.getName() + "]已移除组件："+ equipment.getName() );
    }

    public void selfCheck() {
      //  System.out.println(groupName+"  selfCheck");
    }

    @Override
    public void register() {
       // System.out.println(groupName+"  register");
    }

    @Override
    public void activate() {
       // System.out.println(groupName+"  activate");
    }
    public void startSelf(){
        for (Equipment equipment : equipments){
        equipment.start();
        }
    }

    /**
     * 特定设备关闭
     */
    public void stopSelf() {

        for (Equipment equipment : equipments){
            equipment.stop();
        }
    }
    @Override
    public void executeCommand(String command){

    }
}
