package iunsuccessful.demo.patterns.factory_method;

import iunsuccessful.demo.patterns.factory_kit.*;

/**
 * @author LiQZ on 2016/9/27.
 */
public class ElfBlacksmith implements Blacksmith {

    @Override
    public Weapon manufactureWeapon(WeaponType name) {
        KitWeaponFactory factory = KitWeaponFactory.factory(builder -> {
            builder.add(WeaponType.AXE, Axe::new);
            builder.add(WeaponType.SPEAR, Spear::new);
        });
        return factory.create(name);
    }

}
