package twy.ten;
import java.util.Map;

// 基础设备接口
public interface SmartDevice {
    String getId();
    String getType();
    Map<String, Object> getProperties();
    void executeCommand(String command);
}
