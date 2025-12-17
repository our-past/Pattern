package cd;

public class thirdPartySmartToilet extends thirdPartyDevice{

    public thirdPartySmartToilet() {
        super();
    }

    public thirdPartySmartToilet(String id,String name) {
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
