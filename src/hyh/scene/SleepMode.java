package hyh.scene;

import room.Room;
import equipment_fyk.Equipment;

public class SleepMode implements RoomSceneState {
    @Override
    public String getSceneName() {
        return "睡眠模式";
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
}
