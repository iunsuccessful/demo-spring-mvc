package iunsuccessful.demo.java8;

import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * 依韵 2019/12/19
 */
public class IteratorDemo {



    public static void main(String[] args) {
        Seed seed = new Seed(1);
        Seed seed1 = Stream.iterate(seed, new UnaryOperator<Seed>() {
            @Override
            public Seed apply(Seed seed) {
                seed.setI(seed.getI()+1);
                return seed;
            }
        }).filter(new Predicate<Seed>() {
            @Override
            public boolean test(Seed seed) {
                return seed.getI() == 100;
            }
        }).findFirst().get();

        System.out.println(seed1.getI());
    }

}

class Seed {

    private int i;

    public Seed(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "Seed{" +
                "i=" + i +
                '}';
    }
}
