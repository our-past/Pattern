package equipment_fyk.State;

import equipment_fyk.Equipment;

public class GreenState implements State{
    @Override
    public void changeState(Equipment equipment) {
        equipment.setState(this);
    }


}
