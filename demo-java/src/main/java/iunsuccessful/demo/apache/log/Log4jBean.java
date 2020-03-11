package iunsuccessful.demo.apache.log;

/**
 * 依韵 2019-08-01
 */
public class Log4jBean {

    private String name;

    private String type;

    public Log4jBean(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Log4jBean{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
