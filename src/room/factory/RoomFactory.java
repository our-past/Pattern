package room.factory;

import room.Room;
import utils.ReflectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RoomFactory {
    private static volatile RoomFactory instance;

    public static RoomFactory getInstance() {
        if (instance == null) {
            synchronized (RoomFactory.class) {
                if (instance == null) {
                    instance = new RoomFactory();
                }
            }
        }
        return instance;
    }

    // 类名到Class对象的映射
    private static final Map<String, Class<? extends Room>> roomClassMap = new HashMap<>();

    // 静态初始化块，扫描所有Room子类
    static {
        try {
            // 扫描room_fyk包下的所有类
            List<Class<?>> allClasses = ReflectionUtils.scanClasses("room");

            // 过滤出Room的直接或间接子类
            for (Class<?> clazz : allClasses) {
                if (Room.class.isAssignableFrom(clazz) && !clazz.equals(Room.class)) {
                    // 将类名映射到Class对象
                    roomClassMap.put(clazz.getSimpleName(), (Class<? extends Room>) clazz);
                    System.out.println("已注册房间类: " + clazz.getSimpleName());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("设备类扫描失败: " + e.getMessage());
        }
    }

    /**
     * 根据类名创建设备实例
     */
    public Room createRoom(String className, String id, String name) {
        Class<? extends Room> roomClass = roomClassMap.get(className);

        if (roomClass == null) {
            System.err.println("未找到房间类: " + className);
            return null;
        }

        try {
            // 尝试调用带id和name参数的构造函数
            return roomClass.getConstructor(String.class, String.class).newInstance(id, name);
        } catch (Exception e) {
            System.err.println("创建房间实例失败: " + e.getMessage());
            try {
                // 尝试调用无参构造函数
                Room room = roomClass.getConstructor().newInstance();
                room.setId(id);
                room.setName(name);
                return room;
            } catch (Exception ex) {
                System.err.println("创建房间实例失败(无参): " + ex.getMessage());
                return null;
            }
        }
    }

    /**
     * 获取所有注册的设备类映射
     */
    public Map<String, Class<? extends Room>> getRoomClassMap() {
        return new HashMap<>(roomClassMap); // 返回副本，避免外部修改
    }

    /**
     * 检查是否支持指定设备类型
     */
    public boolean isSupportedEquipment(String className) {
        return roomClassMap.containsKey(className);
    }
}
