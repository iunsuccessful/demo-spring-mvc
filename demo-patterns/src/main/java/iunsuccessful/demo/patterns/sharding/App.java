package iunsuccessful.demo.patterns.sharding;

/**
 * 依韵 2019/12/19
 */
public class App {

    public static void main(String[] args) {
        Shard shard1 = new Shard(1);
        Shard shard2 = new Shard(2);
        Shard shard3 = new Shard(3);

        ShardManager shardManager = new RandomShardManager();
        shardManager.addNewShard(shard1);
        shardManager.addNewShard(shard2);
        shardManager.addNewShard(shard3);

        Data data = new Data();

        shardManager.storeData(data);



    }

}
