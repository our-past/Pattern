package hyh.scene;

import room.Room;

public interface RoomSceneState {
    String getSceneName();
    void enter(Room room);
    void exit(Room room);
    void execute(Room room);
}
