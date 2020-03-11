package iunsuccessful.demo.patterns.saga;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 依韵 2020/1/18
 */
public abstract class Service<K> implements OrchestrationChapter<K> {
    
    private static final Logger logger = LoggerFactory.getLogger(Service.class);

    public abstract String getName();

    @Override
    public ChapterResult<K> process(K value) {
        logger.info("The chapter '{}' has been started. "
                        + "The data {} has been stored or calculated successfully",
                getName(), value);
        return ChapterResult.success(value);
    }

    @Override
    public ChapterResult<K> rollback(K value) {
        logger.info("The Rollback for a chapter '{}' has been started. "
                        + "The data {} has been rollbacked successfully",
                getName(), value);
        return ChapterResult.success(value);
    }
}
