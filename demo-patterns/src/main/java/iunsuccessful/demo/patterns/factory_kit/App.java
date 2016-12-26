package iunsuccessful.demo.patterns.factory_kit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author LiQZ on 2016/9/27.
 */
public class App {

    public static void main(String[] args) {

        // simple
        Weapon axe = SimpleWeaponFactory.create(WeaponType.AXE);
        System.out.println(axe);

        // kit
        Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
        map.put(WeaponType.AXE, Axe::new);
        map.put(WeaponType.SPEAR, Spear::new);

        System.out.println(KitWeaponFactory.factory(map).create(WeaponType.SPEAR));

        // function interface
        KitWeaponFactory factory = KitWeaponFactory.factory(new Consumer<Builder>() {
            @Override
            public void accept(Builder builder) {
                builder.add(WeaponType.AXE, Axe::new);
                builder.add(WeaponType.SPEAR, Spear::new);
            }
        });

//        KitWeaponFactory factory1 = KitWeaponFactory.factory(new Consumer<BiConsumer<WeaponType, Supplier<Weapon>>>(){
//            @Override
//            public void accept(BiConsumer<WeaponType, Supplier<Weapon>> consumer) {
//                consumer.accept(WeaponType.AXE, Axe::new);
//                consumer.accept(WeaponType.SPEAR, Spear::new);
//            }
//        });

        System.out.println(factory.create(WeaponType.AXE));

    }

}
