package iunsuccessful.demo.jvm.property;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/3/29 .
 */
public class PropertyDemo {

    public static void main(String[] args) {
        String projectName = System.getProperty("project.name");
        System.out.println(projectName);

        System.setProperty("project.name", "snt-harvest");

        projectName = System.getProperty("project.name");
        System.out.println(projectName);

    }

}
