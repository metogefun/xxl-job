package cn.finegames.oss.schedule.starter;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * TODO
 *
 * @author wang zhaohui
 * @since 1.0
 */
@Component
@JobHandler("billJobHandler")
public class BillJobHandler extends IJobHandler {

    Logger logger = LoggerFactory.getLogger(BillJobHandler.class);

    @Override
    public ReturnT<String> execute(String param) throws Exception {

        logger.info("bill job handler....");
        return ReturnT.SUCCESS;
    }
}
