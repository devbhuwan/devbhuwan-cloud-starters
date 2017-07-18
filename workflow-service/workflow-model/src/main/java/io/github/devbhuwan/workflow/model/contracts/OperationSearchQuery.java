package io.github.devbhuwan.workflow.model.contracts;

import org.immutables.value.Value;

/**
 * @author Bhuwan Upadhyay
 */
@Value.Immutable
public interface OperationSearchQuery {

    String processInstanceId();

    String userId();

    OperationRole userRole();
}
