package iunsuccessful.demo.patterns.factory_kit;

/**
 * 武器工厂
 * @author LiQZ on 2016/9/27.
 */
public class SimpleWeaponFactory {

    public static Weapon create(WeaponType name) {
        switch (name) {
            case AXE: return new Axe();
            case SPEAR: return new Spear();
        }
        return null;
    }



}
