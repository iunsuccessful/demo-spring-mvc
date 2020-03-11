package iunsuccessful.demo.patterns.sharding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * mapper -> database
 * database -> datasource
 *
 * 依韵 2019/12/19
 */
public abstract class ShardManager {
    
    private static final Logger logger = LoggerFactory.getLogger(ShardManager.class);

    // mapper -> database
    protected Map<Integer, Shard> shardMap;

    public ShardManager() {
        this.shardMap = new HashMap<>();
    }

    public boolean addNewShard(final Shard shard) {
        Integer shardId = shard.getId();
        if (!shardMap.containsKey(shardId)) {
            shardMap.put(shardId, shard);
            return true;
        }
        return false;
    }

    public boolean removeShardById(final int shardId) {
        if (shardMap.containsKey(shardId)) {
            shardMap.remove(shardId);
            return true;
        }
        return false;
    }

    public Shard getShardById(final int shardId) {
        return shardMap.get(shardId);
    }

    public abstract int storeData(final Data data);

    protected abstract int allocateShard(final Data data);

}
