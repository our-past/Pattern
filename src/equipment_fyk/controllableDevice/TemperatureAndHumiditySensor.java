package equipment_fyk.controllableDevice;

import equipment_fyk.ControllableDevice;
import equipment_fyk.Equipment;

/**
 * 温度和湿度传感器
 */
public class TemperatureAndHumiditySensor extends Equipment implements ControllableDevice {

    String temperatureType;
    String humidityType;
    double temperature;
    double humidity;

    /**
     * 温度和湿度传感器构造函数
     */
    public TemperatureAndHumiditySensor() {
        super();
        temperatureType = "摄氏度";
        humidityType = "百分比";
        temperature = 0.0;
        humidity = 0.0;
    }
    /**
     * 温度和湿度传感器构造函数
     * @param name 温度和湿度传感器名称
     * @param id 温度和湿度传感器ID
     */
    public TemperatureAndHumiditySensor(String id,String name) {
        super(id,name);
        temperatureType = "摄氏度";
        humidityType = "百分比";
        temperature = 0.0;
        humidity = 0.0;
    }

    @Override
    public void selfCheck() {
        System.out.println(" TemperatureAndHumiditySensor selfCheck");
    }
    
    @Override
    public void register() {
        System.out.println(" TemperatureAndHumiditySensor register");
    }
    
    @Override
    public void activate() {
        System.out.println(" TemperatureAndHumiditySensor activate");
    }

    public void setTemperatureType(String temperatureType) {
        this.temperatureType = temperatureType;
    }
    public String getTemperatureType() {
        return temperatureType;
    }
    public void setHumidityType(String humidityType) {
        this.humidityType = humidityType;
    }
    public String getHumidityType() {
        return humidityType;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }
    public double getHumidity() {
        return humidity;
    }
}