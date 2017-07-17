package io.github.devbhuwan.workflow.service.strater.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Bhuwan Upadhyay
 */

@ConfigurationProperties(prefix = WorkflowServiceProperties.DEVBHUWAN_WORKFLOW_SERVICE_PREFIX)
@Getter
@Setter
public class WorkflowServiceProperties {

    public static final String DEVBHUWAN_WORKFLOW_SERVICE_PREFIX = "devbhuwan.workflow.service";


}
