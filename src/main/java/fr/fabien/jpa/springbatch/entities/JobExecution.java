package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "BATCH_JOB_EXECUTION", indexes = @Index(columnList = "JOB_INSTANCE_ID"))
public class JobExecution {
    @Id
    @Column(name = "JOB_EXECUTION_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long jobExecutionId;

    @Column(name = "VERSION")
    public Long version;

    @Column(name = "CREATE_TIME", nullable = false)
    public OffsetDateTime createTime;

    @Column(name = "START_TIME")
    public OffsetDateTime startTime;

    @Column(name = "END_TIME")
    public OffsetDateTime endTime;

    @Column(name = "STATUS", length = 10)
    public String status;

    @Column(name = "EXIT_CODE", length = 2500)
    public String exitCode;

    @Column(name = "EXIT_MESSAGE", length = 2500)
    public String exitMessage;

    @Column(name = "LAST_UPDATED")
    public OffsetDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_INSTANCE_ID", nullable = false)
    public JobInstance jobInstance;

    @OneToMany(mappedBy = "jobExecution")
    public Set<JobExecutionContext> jobExecutionContexts = new HashSet<>();

    @OneToMany(mappedBy = "jobExecution")
    public Set<JobExecutionParam> jobExecutionParams = new HashSet<>();

    @OneToMany(mappedBy = "jobExecution")
    public Set<StepExecution> stepExecutions = new HashSet<>();

    public JobExecution() {
    }

    public JobExecution(Long version, OffsetDateTime createTime, OffsetDateTime startTime, OffsetDateTime endTime, String status, String exitCode, String exitMessage, OffsetDateTime lastUpdated, JobInstance jobInstance, Set<JobExecutionContext> jobExecutionContexts, Set<JobExecutionParam> jobExecutionParams, Set<StepExecution> stepExecutions) {
        this.version = version;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.exitCode = exitCode;
        this.exitMessage = exitMessage;
        this.lastUpdated = lastUpdated;
        this.jobInstance = jobInstance;
        this.jobExecutionContexts = jobExecutionContexts;
        this.jobExecutionParams = jobExecutionParams;
        this.stepExecutions = stepExecutions;
    }
}
