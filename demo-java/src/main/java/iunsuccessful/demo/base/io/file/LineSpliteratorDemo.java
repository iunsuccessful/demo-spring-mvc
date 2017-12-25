package iunsuccessful.demo.base.io.file;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

/**
 * 实现 grep -b 功能
 * 查询该文件中，含有数字的行数
 * Created by LiQZ on 2017/12/22.
 */
public class LineSpliteratorDemo {


    public static void main(String[] args) {

        Path start = new File("D:\\a\\com\\azt\\api\\pojo\\StdCategoryPriceConfig.java").toPath();

        System.out.println(start.toAbsolutePath());

        Pattern pattern = Pattern.compile("[-+]?[0-9]*\\.?[0-9]+");

        try (FileChannel fc = FileChannel.open(start)) {

            MappedByteBuffer bB = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
            Spliterator<DispLine> ls = new LineSpliterator(bB, 0, bB.limit() - 1);

            StreamSupport.stream(ls, true)
                    .filter(dl -> pattern.matcher(dl.line).find())
                    .forEachOrdered(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

class LineSpliterator implements Spliterator<DispLine> {


    private static final int AVERAGE_LINE_LENGTH = 80;

    private ByteBuffer bb;

    private volatile int lo, hi; // 行首 行尾

    public LineSpliterator(ByteBuffer bb, int lo, int hi) {
        this.bb = bb;
        this.lo = lo;
        this.hi = hi;
    }

    @Override
    public boolean tryAdvance(Consumer<? super DispLine> action) {
        String name = Thread.currentThread().getName();
        System.out.println(action);
        if (lo >= hi) {
            System.out.printf("%s ########### lo: %d hi: %d\n", name, lo, hi);
            return false;
        }
//        System.out.printf("lo: %d hi: %d\n", lo, hi);
        int index = lo;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char) bb.get(index++));
        } while (bb.get(index) != '\n');
        action.accept(new DispLine(lo, sb.toString()));
        lo = lo + sb.length();
        if (lo == hi) {
            System.out.printf("%s lo: %d hi: %d tryAdvance: %s\n", name, lo, hi, lo < hi);
        }
        return lo < hi;
    }

    @Override
    public Spliterator<DispLine> trySplit() {
        int mid = (lo + hi) >>> 1; // 除以 2, 取中间的意思
//        System.out.printf("lo: %d hi: %d mid: %d\n", lo, hi, mid);
        while (bb.get(mid) != '\n') mid++; // 移动到中间那行行尾
//        System.out.println(mid);
        LineSpliterator newLineSpliterator = null;
        // 如果不是最后一行，就继续找中间行
        if (mid != hi) {
            // 断续分解前半段
            System.out.printf("mid: %d hi: %d\n", mid, hi);
            newLineSpliterator = new LineSpliterator(bb, lo, mid);
            lo = mid + 1;
        }
        return newLineSpliterator;
    }

    @Override
    public long estimateSize() {
        return (hi - lo + 1)/AVERAGE_LINE_LENGTH;
    }

    @Override
    public int characteristics() {
        return ORDERED | IMMUTABLE | NONNULL;
    }

}

class DispLine {

    final int disp;
    final String line;

    public DispLine(int disp, String line) {
        this.disp = disp;
        this.line = line;
    }

    @Override
    public String toString() {
        return "DispLine{" +
                "disp=" + disp +
                ", line='" + line.trim() + '\'' +
                '}';
    }
}
