package iunsuccessful.demo.patterns.saga;

import java.util.ArrayList;
import java.util.List;

/**
 * 依韵 2020/1/17
 */
public class Saga {

    private List<Chapter> chapters;

    private Saga() {
        this.chapters = new ArrayList<>();
    }

    public Saga chapter(String name) {
        this.chapters.add(new Chapter(name));
        return this;
    }

    public Chapter get(int idx) {
        return chapters.get(idx);
    }

    public boolean isPresent(int idx) {
        return idx >= 0 && idx < chapters.size();
    }

    public static Saga create() {
        return new Saga();
    }

    public enum Result {
        FINISHED, ROLLBACK, CRASHED;
    }

    public static class Chapter {

        private String name;

        public Chapter(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

}
