package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_CONTEXT", indexes = @Index(columnList = "JOB_EXECUTION_ID"))
public class JobExecutionContext {
    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    private String serializedContext;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    private JobExecution jobExecution;

    public JobExecutionContext() {
    }

    public JobExecutionContext(String shortContext, String serializedContext, JobExecution jobExecution) {
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.jobExecution = jobExecution;
    }
}
