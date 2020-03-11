package iunsuccessful.demo.patterns.sharding;

import java.util.HashMap;
import java.util.Map;

/**
 * 依韵 2019/12/19
 */
public class Shard {

    private Integer id;

    // database -> datasource
    private Map<Integer, Object> dataSource;

    public Shard(Integer id) {
        this.id = id;
        this.dataSource = new HashMap<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Map<Integer, Object> getDataSource() {
        return dataSource;
    }

    public void setDataSource(Map<Integer, Object> dataSource) {
        this.dataSource = dataSource;
    }
}
