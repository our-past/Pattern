package equipment_fyk.homeAppliances;

import equipment_fyk.Equipment;
import equipment_fyk.HomeAppliances;

/**
 * 空调
 */
public class AirConditioner extends Equipment implements HomeAppliances {
    /**
     * 空调构造函数
     */
    public AirConditioner() {
        super();
        setProperty("temperature", 25.0);
        setProperty("type", this.getClass().getSimpleName());
    }
    /**
     * 空调构造函数
     * @param name 空调名称
     * @param id 空调ID
     */
    public AirConditioner(String id,String name) {
        super(id,name);
        setProperty("temperature", 25.0);
        setProperty("type", this.getClass().getSimpleName());
    }
    @Override
    public void selfCheck() {
        System.out.println(" AirConditioner selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" AirConditioner register");
    }

    @Override
    public void activate() {
        System.out.println(" AirConditioner activate");
    }
    @Override
    public void executeCommand(String command){
        if ("打开".equals(command)) {
            System.out.println("[空调-" + getId() + "] 已开启");
        } else if ("关闭".equals(command)) {
            System.out.println("[空调-" + getId() + "] 已关闭");
        } else if (command.startsWith("设置温度")) {
            String[] parts = command.split(" ");
            if (parts.length == 2) {
                try {
                    double temperature = Double.parseDouble(parts[1]);
                    setProperty("temperature", temperature);
                    System.out.println("[空调-" + getId() + "] 温度已设置为 " + temperature);
                } catch (NumberFormatException e) {
                    System.out.println("温度格式错误");
                }
            } else {
                System.out.println("设置温度命令格式错误");
            }
        }
    }
}