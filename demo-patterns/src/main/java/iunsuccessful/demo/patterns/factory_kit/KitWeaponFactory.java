package iunsuccessful.demo.patterns.factory_kit;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @author LiQZ on 2016/9/27.
 */
@FunctionalInterface
public interface KitWeaponFactory {

    Weapon create(WeaponType name);

    /**
     * 简单工厂的一种写法
     */
    @Deprecated
    static KitWeaponFactory factory(Map<WeaponType, Supplier<Weapon>> map) {
        return new KitWeaponFactory() {
            @Override
            public Weapon create(WeaponType name) {
                return map.get(name).get();
            }
        };
    }

    /**
     * 结合 java 8 的写法
     */
    static KitWeaponFactory factory(Consumer<Builder> consumer) {
        Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
        consumer.accept(map::put);
        return name -> map.get(name).get();
//        consumer.accept(new Builder() {
//            @Override
//            public void add(WeaponType name, Supplier<Weapon> supplier) {
//                map.put(name, supplier);
//            }
//        });
//        return new KitWeaponFactory() {
//            @Override
//            public Weapon create(WeaponType name) {
//                return map.get(name).get();
//            }
//        };
    }

//    static KitWeaponFactory factory(Consumer<BiConsumer<WeaponType, Supplier<Weapon>>> consumer) {
//        Map<WeaponType, Supplier<Weapon>> map = new HashMap<>();
//        consumer.accept(map::put);
//        return name -> map.get(name).get();
//    }

}
