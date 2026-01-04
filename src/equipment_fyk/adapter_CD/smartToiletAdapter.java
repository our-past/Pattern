package equipment_fyk.adapter_CD;

import equipment_fyk.adapter_CD.SmartToiletLocal;
import equipment_fyk.Equipment;
public class smartToiletAdapter implements DeviceAdapter{
    @Override
  public  Equipment adapt(Object thirdPartyDevice, String systemDeviceId, String systemDeviceName){

        return  new SmartToiletLocal(systemDeviceId,systemDeviceName, thirdPartyDevice);

    }


   public boolean isCompatible(String deviceType){

        return this.getClass().getSimpleName().toLowerCase().contains(deviceType.toLowerCase());

    }
}
