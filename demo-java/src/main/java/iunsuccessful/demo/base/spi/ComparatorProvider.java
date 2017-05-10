package iunsuccessful.demo.base.spi;

import java.util.Comparator;

/**
 *
 * 利用 SPI 机制，调用
 * --META-INF
 * ----services
 * -------java.util.Comparator
 *
 * Created by LiQZ on 2017/5/10.
 */
public class ComparatorProvider implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        // 倒序
        return o2.compareTo(o1);
    }

}
