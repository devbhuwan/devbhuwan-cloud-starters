package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.*;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    public WorkflowProcessInfo startProcess(String processDefinitionId, Map<String, Object> variables) {
        log.info("Workflow Process Started [processDefinitionId={}]", processDefinitionId);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(processDefinitionId, variables);
        return ImmutableWorkflowProcessInfo.builder()
                .processInstanceId(processInstance.getProcessInstanceId())
                .build();
    }

    @Override
    public List<Operation> operations(OperationSearchQuery searchQuery) {
        List<Task> tasks = taskService.createTaskQuery()
                .processInstanceId(searchQuery.processInstanceId()).list();
        return tasks.stream()
                .map(task -> ImmutableOperation.builder()
                        .key("")
                        .label("")
                        .taskId(task.getId())
                        .taskName(task.getName())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void executeTask(Operation operation, Map<String, Object> variables) {
        taskService.complete(operation.taskId());
    }

}
