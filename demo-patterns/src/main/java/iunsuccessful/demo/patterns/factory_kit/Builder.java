package iunsuccessful.demo.patterns.factory_kit;

import java.util.function.Supplier;

/**
 * 这里用 function interface 的好处是 consumer.accept(map::put); 可以直接这样写
 * @author LiQZ on 2016/9/27.
 */
@FunctionalInterface
public interface Builder {

    void add(WeaponType name, Supplier<Weapon> supplier);

}
