package iunsuccessful.demo.clazz;

/**
 * 依韵 2022/3/24
 */
public class FatherA {

    void save() {
        System.out.println("FatherA#save");
        System.out.println(this.getClass().getName());
        this.saveAB();
    }

    void saveAB() {
        System.out.println("fatherA#saveAB");
        System.out.println(this.getClass().getName());
    }

}
