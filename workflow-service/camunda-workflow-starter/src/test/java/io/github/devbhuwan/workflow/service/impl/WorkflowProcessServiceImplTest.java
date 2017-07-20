package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.*;
import io.github.devbhuwan.workflow.service.CamundaWorkflowStarterApplication;
import org.assertj.core.api.Assertions;
import org.assertj.core.condition.Join;
import org.camunda.bpm.engine.RepositoryService;
import org.camunda.bpm.engine.repository.ProcessDefinition;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Bhuwan Upadhyay
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CamundaWorkflowStarterApplication.class)
public class WorkflowProcessServiceImplTest {

    @Autowired
    private WorkflowProcessService workflowProcessService;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private RepositoryService repositoryService;

    @Test
    public void completeOrderWorkflowTest() {
        String processDefinitionId = "WF_Order";
        waitForProcessDeployment(processDefinitionId);
        WorkflowProcessInfo processInfo = workflowProcessService.startProcess(processDefinitionId, null);
        Assertions.assertThat(processInfo)
                .is(new Join<WorkflowProcessInfo>() {
                    @Override
                    public boolean matches(WorkflowProcessInfo value) {
                        return value.processInstanceId() != null;
                    }
                });
        List<Operation> operations1 = getOperations(processInfo);
        workflowProcessService.executeTask(operations1.get(0), null);
        List<Operation> operations2 = getOperations(processInfo);
    }

    private void waitForProcessDeployment(String processDefinitionId) {
        ProcessDefinition processDefinition;
        do {
            processDefinition = repositoryService.createProcessDefinitionQuery().processDefinitionKey(processDefinitionId).singleResult();
        } while (processDefinition == null);
    }

    private List<Operation> getOperations(WorkflowProcessInfo processInfo) {
        return workflowProcessService.operations(ImmutableOperationSearchQuery.builder()
                .processInstanceId(processInfo.processInstanceId())
                .userId("")
                .userRole(OperationRole.MAKER)
                .build());
    }

}
