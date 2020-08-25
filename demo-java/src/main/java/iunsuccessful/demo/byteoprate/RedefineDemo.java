//package iunsuccessful.demo.byteoprate;
//
//import net.bytebuddy.ByteBuddy;
//import net.bytebuddy.agent.ByteBuddyAgent;
//import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
//
///**
// * 依韵 2020/4/7
// */
//public class RedefineDemo {
//
//    public static void main(String[] args) {
//        ByteBuddyAgent.install();
//        Foo3 foo = new Foo3();
//        new ByteBuddy()
//                .redefine(Bar3.class)
//                .name(Foo3.class.getName())
//                .make()
//                .load(Foo3.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
////                .load(Foo3.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER);
//        // assertThat(foo.m(), is("bar"));
//        System.out.println(foo.toString());
//        System.out.println(foo.m("xb"));
//    }
//
//}
//
//class Foo {
//
//    public String m(String hello) {
//        return "foo" + hello;
//    }
//
//    public String b() {
//        return "b";
//    }
//
//}
//
//class Bar {
//
//    public String m(String hello) {
//        return "bar" + hello;
//    }
//
//    public String b() {
//        return "b";
//    }
//
//}
