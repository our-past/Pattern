package equipment_fyk;


import equipment_fyk.State.GreenState;
import equipment_fyk.State.RedState;
import equipment_fyk.State.State;

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
}
