package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT")
public class StepExecutionContext {
    @Id
    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    private String serializedContext;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STEP_EXECUTION_ID", nullable = false)
    private StepExecution stepExecution;

    public String getShortContext() {
        return shortContext;
    }

    public void setShortContext(final String shortContext) {
        this.shortContext = shortContext;
    }

    public String getSerializedContext() {
        return serializedContext;
    }

    public void setSerializedContext(final String serializedContext) {
        this.serializedContext = serializedContext;
    }

    public StepExecution getStepExecution() {
        return stepExecution;
    }

    public void setStepExecution(final StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

}
