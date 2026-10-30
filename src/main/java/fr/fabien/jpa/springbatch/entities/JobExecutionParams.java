package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS", indexes = @Index(columnList = "job_execution_id"))
public class JobExecutionParams {
    @Id
    @Column(name = "PARAMETER_NAME", nullable = false, updatable = false, length = 100)
    private String parameterName;

    @Column(name = "PARAMETER_TYPE", nullable = false, length = 100)
    private String parameterType;

    @Column(name = "PARAMETER_VALUE", length = 2500)
    private String parameterValue;

    @Column(name = "IDENTIFYING", nullable = false)
    private Character identifying;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    private JobExecution jobExecution;

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(final String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(final String parameterType) {
        this.parameterType = parameterType;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(final String parameterValue) {
        this.parameterValue = parameterValue;
    }

    public Character getIdentifying() {
        return identifying;
    }

    public void setIdentifying(final Character identifying) {
        this.identifying = identifying;
    }

    public JobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(final JobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

}
