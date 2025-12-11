package equipment.factory;

import equipment.Equipment;
import utils.ReflectionUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 设备工厂类
 * 使用反射扫描所有Equipment子类并创建映射
 */
public class EquipmentFactory {
    private static volatile EquipmentFactory instance;

    public static EquipmentFactory getInstance() {
        if (instance == null) {
            synchronized (EquipmentFactory.class) {
                if (instance == null) {
                    instance = new EquipmentFactory();
                }
            }
        }
        return instance;
    }

    // 类名到Class对象的映射
    private static final Map<String, Class<? extends Equipment>> equipmentClassMap = new HashMap<>();

    // 静态初始化块，扫描所有Equipment子类
    static {
        try {
            // 扫描equipment包下的所有类
            List<Class<?>> allClasses = ReflectionUtils.scanClasses("equipment");

            // 过滤出Equipment的直接或间接子类
            for (Class<?> clazz : allClasses) {
                if (Equipment.class.isAssignableFrom(clazz) && !clazz.equals(Equipment.class)) {
                    // 将类名映射到Class对象
                    equipmentClassMap.put(clazz.getSimpleName(), (Class<? extends Equipment>) clazz);
                    System.out.println("已注册设备类: " + clazz.getSimpleName());
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
    public Equipment createEquipment(String className, String id, String name) {
        Class<? extends Equipment> equipmentClass = equipmentClassMap.get(className);

        if (equipmentClass == null) {
            System.err.println("未找到设备类: " + className);
            return null;
        }

        try {
            // 尝试调用带id和name参数的构造函数
            return equipmentClass.getConstructor(String.class, String.class).newInstance(id, name);
        } catch (Exception e) {
            System.err.println("创建设备实例失败: " + e.getMessage());
            try {
                // 尝试调用无参构造函数
                Equipment equipment = equipmentClass.getConstructor().newInstance();
                equipment.setId(id);
                equipment.setName(name);
                return equipment;
            } catch (Exception ex) {
                System.err.println("创建设备实例失败(无参): " + ex.getMessage());
                return null;
            }
        }
    }

    /**
     * 获取所有注册的设备类映射
     */
    public Map<String, Class<? extends Equipment>> getEquipmentClassMap() {
        return new HashMap<>(equipmentClassMap); // 返回副本，避免外部修改
    }

    /**
     * 检查是否支持指定设备类型
     */
    public boolean isSupportedEquipment(String className) {
        return equipmentClassMap.containsKey(className);
    }
}