package io.github.devbhuwan.workflow.model.contracts;

import java.util.List;
import java.util.Map;

/**
 * @author Bhuwan Upadhyay
 */
public interface WorkflowProcessService {

    WorkflowProcessInfo startProcess(String processDefinitionId, Map<String, Object> variables);

    List<Operation> operations(OperationSearchQuery searchQuery);

    void executeTask(Operation operation, Map<String, Object> variables);
}
