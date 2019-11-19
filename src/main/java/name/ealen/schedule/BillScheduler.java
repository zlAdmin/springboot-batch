package name.ealen.schedule;

import name.ealen.batch.DataBatchConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhanglei
 * @ProjectName: springboot-batch
 * @create 2019-11-19 16:13
 * @Version: 1.0
 * <p>Copyright: Copyright (zl) 2019</p>
 **/
@Component
public class BillScheduler {

    @Autowired
    private DataBatchConfiguration billBatchConfig;

    private static final Logger log = LoggerFactory.getLogger(BillScheduler.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


    /**
     * @Description 一分钟执行一次
     * @return
     * @throws
     * @Author zhanglei
     * @Date 16:44 2019/11/19
     * @Param
     **/
    @Scheduled(cron="0 0/1 * * * ?")
    public void fixedTimePerDayBillBatch() {
        log.info("schedule-job begin {}", dateFormat.format(new Date()));
        billBatchConfig.run();
        log.info("schedule-job end {}", dateFormat.format(new Date()));
    }
}
