package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_CONTEXT")
public class JobExecutionContext {
    @Id
    @Column(name = "SHORT_CONTEXT", nullable = false, updatable = false, length = 2500)
    private String shortContext;

    @Column(name = "SERIALIZED_CONTEXT", columnDefinition = "longtext")
    private String serializedContext;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    private JobExecution jobExecution;

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

    public JobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(final JobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

}
