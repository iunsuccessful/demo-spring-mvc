package iunsuccessful.demo.patterns.sharding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 依韵 2019/12/19
 */
public class RandomShardManager extends ShardManager {

    private Map<String, Integer> lookupMap = new HashMap<>();

    @Override
    public int storeData(Data data) {
        int shardId = allocateShard(data);
        Shard shard = shardMap.get(shardId);
        return 0;
    }

    @Override
    protected int allocateShard(Data data) {
        var key = data.getMapper();
        return lookupMap.getOrDefault(key, 0);
    }
}
