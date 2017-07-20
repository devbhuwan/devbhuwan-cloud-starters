package io.github.devbhuwan.workflow.service;

import io.github.devbhuwan.workflow.model.contracts.ImmutableOperationSearchQuery;
import io.github.devbhuwan.workflow.model.contracts.Operation;
import io.github.devbhuwan.workflow.model.contracts.OperationRole;
import io.github.devbhuwan.workflow.model.contracts.WorkflowProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * @author Bhuwan Upadhyay
 */
@RestController
@RequestMapping("/bpm")
public class RESTWorkflowService {

    public static final String PROCESS_INSTANCE_ID = "processInstanceId";

    @Autowired
    private WorkflowProcessService workflowProcessService;

    @GetMapping("/operations")
    public List<Operation> operations(HashMap<String, String> requestBody) {
        return workflowProcessService.operations(ImmutableOperationSearchQuery.builder()
                .processInstanceId(requestBody.get(PROCESS_INSTANCE_ID))
                .userId("")
                .userRole(OperationRole.MAKER)
                .build());
    }

}
