//package iunsuccessful.demo.byteoprate;
//
//import net.bytebuddy.ByteBuddy;
//import net.bytebuddy.dynamic.ClassFileLocator;
//import net.bytebuddy.pool.TypePool;
//
///**
// * 依韵 2020/4/8
// */
//public class ReloadDemo {
//
//    public static void main(String[] args) throws NoSuchFieldException {
//        TypePool typePool = TypePool.Default.ofSystemLoader();
//        new ByteBuddy()
//                .redefine(typePool.describe("iunsuccessful.demo.byteoprate.Bar3").resolve(), // do not use 'Bar.class'
//                        ClassFileLocator.ForClassLoader.ofSystemLoader())
//                .defineField("qux", String.class) // we learn more about defining fields later
//                .make()
//                .load(ClassLoader.getSystemClassLoader());
//
//        System.out.println(Bar3.class.getDeclaredField("qux"));
//    }
//
//}
