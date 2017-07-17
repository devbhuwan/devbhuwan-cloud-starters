package io.github.devbhuwan.cloud.service.strater.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bhuwan Upadhyay
 */
@Configuration
//@ConditionalOnClass(T.class)
@EnableConfigurationProperties(CloudServiceProperties.class)
public class CloudServiceAutoConfiguration {

    @Autowired
    private CloudServiceProperties serviceProperties;

}
