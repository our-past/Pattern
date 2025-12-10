package twy.nine;
import java.util.HashMap;
import java.util.Map;

// 空调设备实现
public class AirConditioner implements SmartDevice {
    private String id;
    private Map<String, Object> properties = new HashMap<>();

    public AirConditioner(String id) {
        this.id = id;
        properties.put("temperature", 25); // 初始温度
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getType() { return "AIR_CONDITIONER"; }

    @Override
    public Map<String, Object> getProperties() { return properties; }

    @Override
    public void executeCommand(String command) {
        if (command.equals("TURN_ON")) {
            System.out.println("[空调-" + id + "] 已开启");
        } else if (command.equals("TURN_OFF")) {
            System.out.println("[空调-" + id + "] 已关闭");
        }
    }
}