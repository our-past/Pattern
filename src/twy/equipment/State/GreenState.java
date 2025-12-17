package twy.equipment.State;

import twy.equipment.Equipment;

public class GreenState implements State {
    @Override
    public void changeState(Equipment equipment) {
        equipment.setState(this);
    }


}
