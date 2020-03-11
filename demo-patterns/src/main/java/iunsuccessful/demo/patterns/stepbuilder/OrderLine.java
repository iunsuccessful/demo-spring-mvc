package iunsuccessful.demo.patterns.stepbuilder;

import java.util.List;

/**
 * 依韵 2019/12/16
 */
public class OrderLine {

    private List<OrderDetail> details;

    public List<OrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<OrderDetail> details) {
        this.details = details;
    }
}
