package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.ImmutableOperation;
import io.github.devbhuwan.workflow.model.contracts.Operation;
import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessService;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author Bhuwan Upadhyay
 */
@Slf4j
public class WorkflowProcessServiceImpl implements WorkflowProcessService {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private HistoryService historyService;

    @Override
    public void startProcess(String processDefinitionId, Map<String, Object> variables) {
        log.info("Workflow Process Started [processDefinitionId={}]", processDefinitionId);
        runtimeService.startProcessInstanceByKey(processDefinitionId, variables);
    }

    @Override
    public List<Operation> operations(String processDefinitionId, String state) {
        List<Task> tasks = taskService.createTaskQuery().processDefinitionKey(processDefinitionId).list();
        ImmutableOperation.builder().build();
        return null;
    }

}
