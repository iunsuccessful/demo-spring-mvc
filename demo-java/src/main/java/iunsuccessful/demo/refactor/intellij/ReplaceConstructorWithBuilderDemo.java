package iunsuccessful.demo.refactor.intellij;

/**
 * 依韵 2020/5/4
 */
public class ReplaceConstructorWithBuilderDemo {

    public static void main(String[] args){
        // before:
//        variety varietyObject = new variety("Red Delicious");
        // after: 只找到 factorty
        variety varietyObject = variety.createvariety("Red Delicious");
        varietyObject.saying();
    }


}


// variety class

class variety{
    private String string;

    // constructor
    private variety(String name){
        string = name;
    }

    public static variety createvariety(String name) {
        return new variety(name);
    }

    public void setName(String name) {
        string = name;
    }

    public String getName() {
        return string;
    }

    public void saying(){
        System.out.printf("On sale today : %s\n", getName());
    }
}
