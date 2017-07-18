package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @author Bhuwan Upadhyay
 */
@Slf4j
public class WorkflowProcessServiceImpl implements WorkflowProcessService {

    @Autowired
    private RuntimeService runtimeService;

    @Override
    public void startProcess(String processDefinitionId, Map<String, Object> variables) {
        log.info("Workflow Process Started [processDefinitionId={}]", processDefinitionId);
        runtimeService.startProcessInstanceByKey(processDefinitionId, variables);
    }

}
