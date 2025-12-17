package cd;
import equipment.Equipment;
import equipment.adapter_CD.DeviceAdapter ;


public class alarmAdapter implements DeviceAdapter{

    @Override
  public  Equipment adapt(Object thirdPartyDevice, String systemDeviceId, String systemDeviceName){

      return  new AlarmLocal(systemDeviceId,systemDeviceName, thirdPartyDevice);


    }

    @Override
   public  boolean isCompatible(String deviceType){

    return this.getClass().getSimpleName().toLowerCase().contains(deviceType.toLowerCase());

    }
}
