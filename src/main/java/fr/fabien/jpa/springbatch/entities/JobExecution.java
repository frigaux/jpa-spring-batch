package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "BATCH_JOB_EXECUTION", indexes = @Index(columnList = "job_instance_id"))
public class JobExecution {
    @Id
    @Column(name = "JOB_EXECUTION_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobExecutionId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATE_TIME", nullable = false)
    private OffsetDateTime createTime;

    @Column(name = "START_TIME")
    private OffsetDateTime startTime;

    @Column(name = "END_TIME")
    private OffsetDateTime endTime;

    @Column(name = "STATUS", length = 10)
    private String status;

    @Column(name = "EXIT_CODE", length = 2500)
    private String exitCode;

    @Column(name = "EXIT_MESSAGE", length = 2500)
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private OffsetDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_INSTANCE_ID", nullable = false)
    private JobInstance jobInstance;

    @OneToMany(mappedBy = "jobExecution")
    private Set<JobExecutionContext> jobExecutionContexts = new HashSet<>();

    @OneToMany(mappedBy = "jobExecution")
    private Set<JobExecutionParams> jobExecutionParams = new HashSet<>();

    @OneToMany(mappedBy = "jobExecution")
    private Set<StepExecution> stepExecutions = new HashSet<>();

    public Long getJobExecutionId() {
        return jobExecutionId;
    }

    public void setJobExecutionId(final Long jobExecutionId) {
        this.jobExecutionId = jobExecutionId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public OffsetDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(final OffsetDateTime createTime) {
        this.createTime = createTime;
    }

    public OffsetDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(final OffsetDateTime startTime) {
        this.startTime = startTime;
    }

    public OffsetDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(final OffsetDateTime endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(final String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(final String exitCode) {
        this.exitCode = exitCode;
    }

    public String getExitMessage() {
        return exitMessage;
    }

    public void setExitMessage(final String exitMessage) {
        this.exitMessage = exitMessage;
    }

    public OffsetDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(final OffsetDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public JobInstance getJobInstance() {
        return jobInstance;
    }

    public void setJobInstance(final JobInstance jobInstance) {
        this.jobInstance = jobInstance;
    }

    public Set<JobExecutionContext> getJobExecutionContexts() {
        return jobExecutionContexts;
    }

    public void setJobExecutionContexts(
            final Set<JobExecutionContext> jobExecutionContexts) {
        this.jobExecutionContexts = jobExecutionContexts;
    }

    public Set<JobExecutionParams> getJobExecutionParams() {
        return jobExecutionParams;
    }

    public void setJobExecutionParams(
            final Set<JobExecutionParams> jobExecutionParams) {
        this.jobExecutionParams = jobExecutionParams;
    }

    public Set<StepExecution> getStepExecutions() {
        return stepExecutions;
    }

    public void setStepExecutions(final Set<StepExecution> stepExecutions) {
        this.stepExecutions = stepExecutions;
    }

}
