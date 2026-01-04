package equipment_fyk;

import equipment_fyk.autoRule.rule;

/**
 * 可控制设备接口
 */
public interface ControllableDevice {

    void addAutoRule(rule r, Equipment e);
    void removeAutoRule(rule r);
    void checkAuto();

}
