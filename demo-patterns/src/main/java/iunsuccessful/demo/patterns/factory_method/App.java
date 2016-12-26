package iunsuccessful.demo.patterns.factory_method;

import iunsuccessful.demo.patterns.factory_kit.Weapon;
import iunsuccessful.demo.patterns.factory_kit.WeaponType;

/**
 * @author LiQZ on 2016/9/27.
 */
public class App {

    private Blacksmith blacksmith;

    public App(Blacksmith blacksmith) {
        this.blacksmith = blacksmith;
    }

    public void manufactureWeapons() {
        Weapon weapon = blacksmith.manufactureWeapon(WeaponType.AXE);
        System.out.println(weapon);
    }

    public static void main(String[] args) {
        new App(new ElfBlacksmith()).manufactureWeapons();
    }

}
