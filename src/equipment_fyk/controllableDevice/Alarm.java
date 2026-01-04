package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;
import equipment_fyk.autoRule.rule;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 智能闹钟
 */
public class Alarm extends Equipment implements ControllableDevice {

    HashMap<rule,Equipment> autoRules = new HashMap<>();

    /**
     * 智能闹钟构造函数
     */
    public Alarm() {
        super();
        setProperty("type", this.getClass().getSimpleName());
        setProperty("time", LocalDateTime.now().toString());
    }
    /**
     * 智能闹钟构造函数
     * @param name 闹钟名称
     * @param id 闹钟ID
     */
    public Alarm(String id,String name) {
        super(id,name);
        setProperty("type", this.getClass().getSimpleName());
        setProperty("time", LocalDateTime.now().toString());
    }

    @Override
    public void selfCheck() {
        System.out.println(" Alarm selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" Alarm register");
    }
    
    @Override
    public void activate() {
        System.out.println(" Alarm activate");
    }

    @Override
    public void executeCommand(String command){

    }

    @Override
    public  void setProperty(String property, Object value) {
        super.setProperty(property,value);
        checkAuto();
    }

    public void addAutoRule(rule r,Equipment e){
        autoRules.put(r,e);
        checkAuto();
    }

    public void removeAutoRule(rule r){
        autoRules.remove(r);
    }
    @Override
    public void checkAuto(){
        for (Map.Entry<rule, Equipment> entry : autoRules.entrySet()) {
            rule r = entry.getKey();
            Equipment device = entry.getValue();
            // 检查规则是否匹配
            if (r.match(this)) {
                // 执行规则动作
                r.execute(device);
                System.out.println("自动化规则触发: " + r.getClass().getSimpleName());
            }
        }
    }
}