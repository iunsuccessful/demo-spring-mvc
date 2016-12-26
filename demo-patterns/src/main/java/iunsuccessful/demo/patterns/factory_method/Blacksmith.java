package iunsuccessful.demo.patterns.factory_method;

import iunsuccessful.demo.patterns.factory_kit.Weapon;
import iunsuccessful.demo.patterns.factory_kit.WeaponType;

/**
 * @author LiQZ on 2016/9/27.
 */
public interface Blacksmith {

    Weapon manufactureWeapon(WeaponType weaponType);

}
