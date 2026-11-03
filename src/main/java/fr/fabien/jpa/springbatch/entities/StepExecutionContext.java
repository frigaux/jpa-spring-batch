package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_STEP_EXECUTION_CONTEXT", indexes = @Index(columnList = "STEP_EXECUTION_ID"))
public class StepExecutionContext {
    @Id
    @Column(name = "STEP_EXECUTION_ID")
    private Long id;

    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    public String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    public String serializedContext;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "STEP_EXECUTION_ID", nullable = false)
    public StepExecution stepExecution;

    public StepExecutionContext() {
    }

    public StepExecutionContext(String shortContext, String serializedContext, StepExecution stepExecution) {
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.stepExecution = stepExecution;
    }
}
