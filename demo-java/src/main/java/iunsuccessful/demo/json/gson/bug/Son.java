package iunsuccessful.demo.json.gson.bug;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/11 .
 */
public class Son extends Parent {

    private Integer pageSize;

    @Override
    public Integer getPageSize() {
        return pageSize;
    }

    @Override
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
