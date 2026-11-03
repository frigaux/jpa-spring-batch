package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;


@Entity
@Table(name = "BATCH_JOB_EXECUTION_PARAMS", indexes = @Index(columnList = "JOB_EXECUTION_ID"))
public class JobExecutionParam {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long id;

    @Column(name = "PARAMETER_NAME", nullable = false, updatable = false, length = 100)
    public String parameterName;

    @Column(name = "PARAMETER_TYPE", nullable = false, length = 100)
    public String parameterType;

    @Column(name = "PARAMETER_VALUE", length = 2500)
    public String parameterValue;

    @Column(name = "IDENTIFYING", nullable = false)
    public Character identifying;

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    public JobExecution jobExecution;

    public JobExecutionParam() {
    }

    public JobExecutionParam(String parameterName, String parameterType, String parameterValue, Character identifying, JobExecution jobExecution) {
        this.parameterName = parameterName;
        this.parameterType = parameterType;
        this.parameterValue = parameterValue;
        this.identifying = identifying;
        this.jobExecution = jobExecution;
    }
}
