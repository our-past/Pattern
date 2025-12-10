package equipment.controllableDevice;

import equipment.ControllableDevice;
import equipment.Equipment;

/**
 * 温度和湿度传感器
 */
public class TemperatureAndHumiditySensor extends Equipment implements ControllableDevice {

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

}