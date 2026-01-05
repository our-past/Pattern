package room.roomConfig_HYH;

import equipment_fyk.Equipment;
import room.Room;

import java.util.HashMap;

public class selfMode implements RoomSceneState{
    private String sceneName;
    private HashMap<String,String> properties = new HashMap<>();

    public selfMode() {
        this.sceneName = "自定义模式";
    }
    public selfMode(String sceneName) {
        this.sceneName = sceneName;
    }

    @Override
    public String getSceneName() {
        return sceneName;
    }

    @Override
    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
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
        // 自定义模式下的设备状态设置（示例逻辑）
        for (Equipment eq : room.getEquipments().values()) {
            if (properties.containsKey(eq.getClass().getSimpleName())) {
                eq.executeCommand(properties.get(eq.getClass().getSimpleName()));
            }
        }
    }
    @Override
    public void setProperty(String key, Object value) {
        System.out.println("设置[" + key + "]为" + value);
        properties.put(key, value.toString());
    }
    @Override
    public void removeProperty(String key) {
        System.out.println("移除[" + key + "]");
        properties.remove(key);
    }
}
