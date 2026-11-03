package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_CONTEXT", indexes = @Index(columnList = "JOB_EXECUTION_ID"))
public class JobExecutionContext {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long id;

    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    public String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    public String serializedContext;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    public JobExecution jobExecution;

    public JobExecutionContext() {
    }

    public JobExecutionContext(String shortContext, String serializedContext, JobExecution jobExecution) {
        this.shortContext = shortContext;
        this.serializedContext = serializedContext;
        this.jobExecution = jobExecution;
    }
}
