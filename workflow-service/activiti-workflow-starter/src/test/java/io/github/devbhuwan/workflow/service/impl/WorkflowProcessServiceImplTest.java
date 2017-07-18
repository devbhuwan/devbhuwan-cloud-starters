package io.github.devbhuwan.workflow.service.impl;

import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessInfo;
import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessService;
import io.github.devbhuwan.workflow.service.ActivitiWorkflowStarterApplication;
import org.assertj.core.api.Assertions;
import org.assertj.core.condition.Join;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Bhuwan Upadhyay
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ActivitiWorkflowStarterApplication.class)
public class WorkflowProcessServiceImplTest {

    @Autowired
    private WorkflowProcessService workflowProcessService;

    @Test
    public void startNewProcessByProcessDefinitionIdThenReturnProcessInfo() {
        Assertions.assertThat(workflowProcessService.startProcess("WF_Order", null))
                .is(new Join<WorkflowProcessInfo>() {
                    @Override
                    public boolean matches(WorkflowProcessInfo value) {
                        return value.processInstanceId() != null;
                    }
                });
    }

}
