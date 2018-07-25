package cn.finegames.oss.schedule.starter;

import com.xxl.job.core.executor.XxlJobExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 分布式任务自动配置
 *
 * @author wang zhaohui
 * @since 1.0
 */
@Configuration
@AutoConfigureOrder(9999)
@ConditionalOnClass(XxlJobExecutor.class)
@EnableConfigurationProperties(ExecutorProperties.class)
public class ScheduleAutoConfiguration {


    @Autowired
    private ExecutorProperties executorProperties;


    @Bean(initMethod = "start", destroyMethod = "destroy")
    @ConditionalOnMissingBean
    public XxlJobExecutor edzJobExecutor() {
        XxlJobExecutor xxlJobExecutor = new XxlJobExecutor();
        xxlJobExecutor.setAdminAddresses(executorProperties.getRegistryAddress());
        xxlJobExecutor.setAppName(executorProperties.getClusterName());
        xxlJobExecutor.setIp(executorProperties.getIp());
        xxlJobExecutor.setPort(executorProperties.getPort());
        xxlJobExecutor.setAccessToken(executorProperties.getAccessToken());
        xxlJobExecutor.setLogPath(executorProperties.getLogPath());
        xxlJobExecutor.setLogRetentionDays(executorProperties.getLogRetentionDays());
        return xxlJobExecutor;
    }

}
