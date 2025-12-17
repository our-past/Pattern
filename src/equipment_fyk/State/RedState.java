package equipment_fyk.State;


import equipment_fyk.Equipment;

public class RedState implements State{
    @Override
    public void changeState(Equipment equipment) {
        equipment.setState(this);
    }
}
