package io.github.devbhuwan.workflow.service.strater.config;

import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessService;
import io.github.devbhuwan.workflow.service.impl.WorkflowProcessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Bhuwan Upadhyay
 */
@Configuration
//@ConditionalOnClass(T.class)
@EnableConfigurationProperties(WorkflowServiceProperties.class)
public class CamundaWorkflowServiceAutoConfiguration {

    @Autowired
    private WorkflowServiceProperties serviceProperties;

    @Bean
    public WorkflowProcessService workflowProcessService() {
        return new WorkflowProcessServiceImpl();
    }
}
