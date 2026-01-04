package equipment_fyk.three;

public class ThirdPartySmartToilet extends ThirdPartyDevice {

    public ThirdPartySmartToilet() {
        super();
    }

    public ThirdPartySmartToilet(String id, String name) {
        super(id,name);
    }


    public void selfCheck() {
        System.out.println("Third Party SmartToilet selfCheck");
    }


    public void register() {
        System.out.println("Third Party SmartToilet register");
    }


    public void activate() {
        System.out.println("Third Party SmartToilet activate");
    }


}
