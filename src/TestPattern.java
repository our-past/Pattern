import equipment.Equipment;
import equipment.homeAppliances.lamp;

import java.util.HashMap;

public class TestPattern {
    HashMap<Integer, Equipment> equipmentMap = new HashMap<>();
    public static void main(String[] args) {
        TestPattern test = new TestPattern();
        test.equipmentMap.put(1, new lamp());
        test.equipmentMap.get(1).start();
    }
}
