package com.wpf.realestate.task;

import com.wpf.realestate.extractor.LjExtractor;
import com.wpf.realestate.storage.HouseRedisDao;
import com.wpf.realestate.storage.RedisDBConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by laopengwork on 2016/10/30.
 */
@Service
public class LjTask extends BaseTask {

    private LjExtractor ljExtractor;

    @Autowired
    public LjTask(HouseRedisDao houseRedisDao) {
        ljExtractor = new LjExtractor(houseRedisDao);
    }

    @Override
    public String taskName() {
        return "ljTask";
    }

    @Override
    public void process() {
        ljExtractor.run();
    }
}