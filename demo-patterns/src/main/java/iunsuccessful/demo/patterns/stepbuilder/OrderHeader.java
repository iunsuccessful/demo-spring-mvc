package iunsuccessful.demo.patterns.stepbuilder;

import java.util.List;

/**
 * 依韵 2019/12/16
 */
public class OrderHeader {

    private List<OrderLine> lines;

    public List<OrderLine> getLines() {
        return lines;
    }

    public void setLines(List<OrderLine> lines) {
        this.lines = lines;
    }

}
