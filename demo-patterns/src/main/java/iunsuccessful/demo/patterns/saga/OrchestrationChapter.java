package iunsuccessful.demo.patterns.saga;

/**
 * 依韵 2020/1/17
 */
public interface OrchestrationChapter<K> {

    String getName();

    ChapterResult<K> process(K value);

    ChapterResult<K> rollback(K value);

}
