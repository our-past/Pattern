package room.roomConfig_HYH;

import room.Room;
import equipment_fyk.Equipment;

public class SleepMode implements RoomSceneState {

    private String sceneName;

    public SleepMode() {
        this.sceneName = "睡眠模式";
    }
    public SleepMode(String sceneName) {
        System.out.println("默认场景不能自定义名称");
    }

    @Override
    public String getSceneName() {
        return sceneName;
    }

    @Override
    public void setSceneName(String sceneName) {
        System.out.println("默认场景不能自定义名称");
    }

    @Override
    public void enter(Room room) {
        System.out.println("进入[" + room.getName() + "]的" + getSceneName());
    }

    @Override
    public void exit(Room room) {
        System.out.println("退出[" + room.getName() + "]的" + getSceneName());
    }

    @Override
    public void execute(Room room) {
        // 睡眠模式下的设备状态设置
        for (Equipment eq : room.getEquipments().values()) {
            Object type = eq.getProperty("type");
            if ("Lamp".equals(type)) {
                eq.executeCommand("关闭");
            } else if ("AirConditioner".equals(type)) {
                eq.setProperty("temperature", 26);
            } else if ("Curtain".equals(type)) {
                eq.executeCommand("关闭");
            }
        }
        for (Equipment eq : room.getEquipments().values()) {
            Object type = eq.getProperty("type");
            if ("AirConditioner".equals(type)) {
                eq.executeCommand("关闭");
            } else if ("Curtain".equals(type)) {
                eq.executeCommand("打开");
            }
        }
        for (Equipment eq : room.getEquipments().values()) {
            Object type = eq.getProperty("type");
            if ("ElectricWindow".equals(type)) {
                eq.executeCommand("关闭");
            } else if ("Curtain".equals(type)) {
                eq.executeCommand("打开");
            }
        }
    }
     @Override
    public void setProperty(String key, Object value) {
        System.out.println("默认场景不能自定义属性");
    }
    @Override
    public void removeProperty(String key) {
        System.out.println("默认场景不能自定义属性");
    }
}
