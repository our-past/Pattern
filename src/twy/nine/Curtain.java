package twy.nine;
import java.util.HashMap;
import java.util.Map;

// 窗帘设备实现
public class Curtain implements SmartDevice {
    private String id;
    private Map<String, Object> properties = new HashMap<>();

    public Curtain(String id) {
        this.id = id;
        properties.put("position", 100); // 初始全开
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getType() { return "CURTAIN"; }

    @Override
    public Map<String, Object> getProperties() { return properties; }

    @Override
    public void executeCommand(String command) {
        if (command.equals("CLOSE")) {
            properties.put("position", 0);
            System.out.println("[窗帘-" + id + "] 已关闭");
        }
    }
}