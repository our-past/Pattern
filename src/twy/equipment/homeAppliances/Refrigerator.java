package twy.equipment.homeAppliances;

import twy.equipment.Equipment;
import twy.equipment.HomeAppliances;

/**
 * 冰箱
 */
public class Refrigerator extends Equipment implements HomeAppliances {
    /**
     * 冰箱温度
     */
    int temperature;
    String temperatureType;
     /**
     * 冰箱湿度
     */
    int humidity;
    String humidityType;

    /**
     * 冰箱构造函数
     */
    public Refrigerator() {
        super();
        temperatureType = "摄氏度";
        humidityType = "百分比";
        temperature = 0;
        humidity = 0;
    }
    /**
     * 冰箱构造函数
     * @param name 冰箱名称
     * @param id 冰箱ID
     */
    public Refrigerator(String id,String name) {
        super(id,name);
        temperatureType = "摄氏度";
        humidityType = "百分比";
        temperature = 0;
        humidity = 0;
    }
    @Override
    public void selfCheck() {
        System.out.println(" Refrigerator selfCheck");
    }

    @Override
    public void register() {
        System.out.println(" Refrigerator register");
    }

    @Override
    public void activate() {
        System.out.println(" Refrigerator activate");
    }
}