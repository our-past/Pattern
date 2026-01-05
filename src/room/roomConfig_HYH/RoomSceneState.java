package room.roomConfig_HYH;

import room.Room;

public interface RoomSceneState {
    String getSceneName();
    void setSceneName(String sceneName);
    void enter(Room room);
    void exit(Room room);
    void execute(Room room);
    void setProperty(String key, Object value);
    void removeProperty(String key);

}
