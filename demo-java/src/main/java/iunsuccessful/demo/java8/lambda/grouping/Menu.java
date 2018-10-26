package iunsuccessful.demo.java8.lambda.grouping;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.List;

/**
 * Create By LiQZ 2018/10/11
 */
public class Menu {

    private String name;

    private List<Menu> menus;

    public Menu(String name) {
        this.name = name;
    }

    public static List<Menu> data() {
        Menu menu = new Menu("father1");
        Menu son1 = new Menu("son1");
        Menu son2 = new Menu("son2");
        menu.setMenus(Arrays.asList(son1, son2));
        Menu menu2 = new Menu("father2");
        menu2.setMenus(Arrays.asList(son1, son2));
        Menu menu3 = new Menu("father1");
        Menu son3 = new Menu("son3");
        menu3.setMenus(Arrays.asList(son1, son3));
        return Arrays.asList(menu, menu2, menu3);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("name", name)
                .add("menus", menus)
                .toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }
}
