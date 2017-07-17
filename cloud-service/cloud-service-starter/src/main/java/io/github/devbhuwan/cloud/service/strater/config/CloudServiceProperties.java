package io.github.devbhuwan.cloud.service.strater.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bhuwan Upadhyay
 */

@ConfigurationProperties(prefix = CloudServiceProperties.DEVBHUWAN_CLOUD_SERVICE_PREFIX)
@Getter
@Setter
public class CloudServiceProperties {

    public static final String DEVBHUWAN_CLOUD_SERVICE_PREFIX = "devbhuwan.cloud.service";

    private Boolean crosAllowOrgin = Boolean.TRUE;

}
