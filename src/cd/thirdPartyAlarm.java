package cd;

public class thirdPartyAlarm extends thirdPartyDevice {
    /**
     * 智能闹钟构造函数
     */
    public thirdPartyAlarm() {
        super();
    }

    public thirdPartyAlarm(String id,String name) {
        super(id,name);
    }


    public void selfCheck() {
        System.out.println("Third Party Alarm selfCheck");
    }


    public void register() {
        System.out.println("Third Party Alarm register");
    }


    public void activate() {
        System.out.println("Third Party Alarm activate");
    }


}
