package com.ber.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：${DESCRIPTION}
 * 创建时间：2018/11/12 20:42
 *
 * @author 朱超
 */
public class MyElasticJob implements SimpleJob {

    private static final Logger log = LoggerFactory.getLogger(MyElasticJob.class);

    @Override
    public void execute(ShardingContext context) {

        log.info("----------任务名称："+context.getJobName());
        log.info("----------分片："+context.getShardingItem());
        log.info("----------任务参数"+context.getJobParameter());
        log.info("----------分片名称"+context.getShardingParameter());
        switch (context.getShardingItem()) {
            case 0:
                // do something by sharding item 0
                break;
            case 1:
                // do something by sharding item 1
                break;
            case 2:
                // do something by sharding item 2
                break;
            // case n: ...
        }
    }
}
