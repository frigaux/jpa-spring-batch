package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT", indexes = @Index(columnList = "STEP_EXECUTION_ID"))
public class StepExecutionContext {
    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    private String serializedContext;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STEP_EXECUTION_ID", nullable = false)
    private StepExecution stepExecution;

    public StepExecutionContext() {
    }
    
    public StepExecutionContext(String shortContext, String serializedContext, StepExecution stepExecution) {
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.stepExecution = stepExecution;
    }
}
