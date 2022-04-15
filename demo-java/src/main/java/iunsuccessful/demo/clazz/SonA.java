package iunsuccessful.demo.clazz;

/**
 * 依韵 2022/3/24
 */
public class SonA extends FatherA {

    public final void save() {
        System.out.println("SonA#save");
        System.out.println(this.getClass().getName());
        super.save();
    }

    public final void saveAB() {
        System.out.println("SonA#saveAB");
        System.out.println(this.getClass().getName());
    }

    public static void main(String[] args) {
        FatherA sonA = new SonA();
        sonA.save();
    }

}
