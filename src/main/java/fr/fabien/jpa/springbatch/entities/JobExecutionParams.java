package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS", indexes = @Index(columnList = "JOB_EXECUTION_ID"))
public class JobExecutionParams {
    @Column(name = "PARAMETER_NAME", nullable = false, updatable = false, length = 100)
    private String parameterName;

    @Column(name = "PARAMETER_TYPE", nullable = false, length = 100)
    private String parameterType;

    @Column(name = "PARAMETER_VALUE", length = 2500)
    private String parameterValue;

    @Column(name = "IDENTIFYING", nullable = false)
    private Character identifying;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    private JobExecution jobExecution;

    public JobExecutionParams() {
    }

    public JobExecutionParams(String parameterName, String parameterType, String parameterValue, Character identifying, JobExecution jobExecution) {
        this.parameterName = parameterName;
        this.parameterType = parameterType;
        this.parameterValue = parameterValue;
        this.identifying = identifying;
        this.jobExecution = jobExecution;
    }
}
