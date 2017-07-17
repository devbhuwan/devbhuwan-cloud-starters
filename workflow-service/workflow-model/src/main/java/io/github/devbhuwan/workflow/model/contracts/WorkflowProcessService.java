package io.github.devbhuwan.workflow.model.contracts;

import java.util.Map;

/**
 * @author Bhuwan Upadhyay
 */
public interface WorkflowProcessService {

    void startProcess(String processDefinitionId, Map<String, Object> variables);
}
