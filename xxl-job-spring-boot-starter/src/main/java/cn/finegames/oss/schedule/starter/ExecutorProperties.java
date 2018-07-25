package cn.finegames.oss.schedule.starter;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 执行器属性
 *
 * @author wang zhaohui
 * @since 1.0
 */
@Getter
@Setter
@ToString
@Component
@ConfigurationProperties("edianzu.schedule")
public class ExecutorProperties {

    /**
     * 注册地址，如果多个地址用"，"分割
     */
    private String registryAddress;

    /**
     * 集群名
     */
    private String clusterName;

    /**
     * ip地址
     */
    private String ip;

    /**
     * 端口
     */
    private int port = 9999;


    /**
     * access token
     */
    private String accessToken;


    /**
     * 业务log path
     */
    private String logPath = "/data/logs/job/";

    /**
     * log保留天数
     */
    private int logRetentionDays = 15;
}
