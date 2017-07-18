package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.*;
import io.github.devbhuwan.workflow.service.ActivitiWorkflowStarterApplication;
import org.assertj.core.api.Assertions;
import org.assertj.core.condition.Join;
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
@SpringBootTest(classes = ActivitiWorkflowStarterApplication.class)
public class WorkflowProcessServiceImplTest {

    @Autowired
    private WorkflowProcessService workflowProcessService;

    @Test
    public void completeOrderWorkflowTest() {
        WorkflowProcessInfo processInfo = workflowProcessService.startProcess("WF_Order", null);
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

    private List<Operation> getOperations(WorkflowProcessInfo processInfo) {
        return workflowProcessService.operations(ImmutableOperationSearchQuery.builder()
                .processInstanceId(processInfo.processInstanceId())
                .userId("")
                .userRole(OperationRole.MAKER)
                .build());
    }

}
