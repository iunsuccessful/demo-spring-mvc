package iunsuccessful.demo.common.domain;

import java.util.Date;

/**
 * <p/>
 *
 * @author Created by 依韵 on 2019/4/10 .
 */
public class Fighter {

    private String name;

    private Date signDate;

    public Fighter() {
    }

    public Fighter(String name, Date signDate) {
        this.name = name;
        this.signDate = signDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getSignDate() {
        return signDate;
    }

    public void setSignDate(Date signDate) {
        this.signDate = signDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Fighter{");
        sb.append("name='").append(name).append('\'');
        sb.append(", signDate=").append(signDate);
        sb.append('}');
        return sb.toString();
    }
}
