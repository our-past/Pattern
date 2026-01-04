package equipment_fyk.autoRule;

import equipment_fyk.Equipment;

// 设备控制动作实现
public class DeviceControlAction implements RuleAction {
    private String command;

    public DeviceControlAction(String command) {
        this.command = command;
    }

    @Override
    public void execute(Equipment device) {
        device.executeCommand(command);
    }
}