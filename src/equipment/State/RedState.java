package equipment.State;


import equipment.Equipment;

public class RedState implements State{
    @Override
    public void changeState(Equipment equipment) {
        equipment.setState(this);
    }
}
