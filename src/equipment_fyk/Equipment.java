package equipment_fyk;


import equipment_fyk.State.GreenState;
import equipment_fyk.State.RedState;
import equipment_fyk.State.State;
import hyh.observer.DeviceObserver;
import hyh.observer.DeviceSubject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 设备接口
 * 负责人：ourPast
 */
public abstract class Equipment {
    /**
     * 设备ID
     */
    private String id;
    /**
     * 设备名称
     */
    private String name;

    /**
     * 设备状态
     */
    private State state;

    private HashMap<String,Object> properties= new HashMap<>();

    public Equipment() {
    }

    public Equipment(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 自检
     */
    public abstract void selfCheck();
    /**
     * 注册
     */
    public abstract void register();
    /**
     * 激活
     */
    public abstract void activate();
    /**
     * 命令执行
     */
    public abstract void executeCommand(String command);

     /**
     * 特定设备启动
     */
    public void startSelf(){

    }
    /**
     * 特定设备关闭
     */
    public void stopSelf() {

    }

    /**
     * 设备启动
     */
    public final void start() {
        System.out.println("设备/设备组："+ this.getName() +"打开");
        selfCheck();
        register();
        activate();
        startSelf();
        setState(new GreenState());
    }

    /**
     * 设备关闭
     */
    public final void stop() {
        System.out.println("设备/设备组："+ this.getName() +"关闭");
        stopSelf();
        setState(new RedState());
    }

    /**
     * 设备检查
     */
    public final void check() {
        System.out.println("设备检查");
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId() {
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setState(State state) {
        this.state = state;
    }
    public State getState() {
        return state;
    }

    public void setProperties(HashMap<String,Object> properties) {
        this.properties = properties;
    }
    public HashMap<String,Object> getProperties() {
        return properties;
    }

    public Object getProperty(String property) {
        return properties.get(property);
    }

    public  void setProperty(String property, Object value) {
        properties.put(property, value);
    }

    public String getDescription() {
        // 可根据实际需求实现，例如返回设备ID、名称和状态的组合描述
        return "设备ID: " + id + ", 设备名称: " + name + ", 设备状态: " + (state != null ? state.getClass().getSimpleName() : "未设置");
    }
}



