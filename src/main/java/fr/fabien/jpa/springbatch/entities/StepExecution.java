package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "BATCH_STEP_EXECUTION", indexes = @Index(columnList = "job_execution_id"))
public class StepExecution {
    @Id
    @Column(name = "STEP_EXECUTION_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stepExecutionId;

    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Column(name = "STEP_NAME", nullable = false, length = 100)
    private String stepName;

    @Column(name = "CREATE_TIME", nullable = false)
    private OffsetDateTime createTime;

    @Column(name = "START_TIME")
    private OffsetDateTime startTime;

    @Column(name = "END_TIME")
    private OffsetDateTime endTime;

    @Column(name = "STATUS", length = 10)
    private String status;

    @Column(name = "COMMIT_COUNT")
    private Long commitCount;

    @Column(name = "READ_COUNT")
    private Long readCount;

    @Column(name = "FILTER_COUNT")
    private Long filterCount;

    @Column(name = "WRITE_COUNT")
    private Long writeCount;

    @Column(name = "READ_SKIP_COUNT")
    private Long readSkipCount;

    @Column(name = "WRITE_SKIP_COUNT")
    private Long writeSkipCount;

    @Column(name = "PROCESS_SKIP_COUNT")
    private Long processSkipCount;

    @Column(name = "ROLLBACK_COUNT")
    private Long rollbackCount;

    @Column(name = "EXIT_CODE", length = 2500)
    private String exitCode;

    @Column(name = "EXIT_MESSAGE", length = 2500)
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private OffsetDateTime lastUpdated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "JOB_EXECUTION_ID", nullable = false)
    private JobExecution jobExecution;

    @OneToMany(mappedBy = "stepExecution")
    private Set<StepExecutionContext> stepExecutionContexts = new HashSet<>();

    public Long getStepExecutionId() {
        return stepExecutionId;
    }

    public void setStepExecutionId(final Long stepExecutionId) {
        this.stepExecutionId = stepExecutionId;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(final Long version) {
        this.version = version;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(final String stepName) {
        this.stepName = stepName;
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

    public Long getCommitCount() {
        return commitCount;
    }

    public void setCommitCount(final Long commitCount) {
        this.commitCount = commitCount;
    }

    public Long getReadCount() {
        return readCount;
    }

    public void setReadCount(final Long readCount) {
        this.readCount = readCount;
    }

    public Long getFilterCount() {
        return filterCount;
    }

    public void setFilterCount(final Long filterCount) {
        this.filterCount = filterCount;
    }

    public Long getWriteCount() {
        return writeCount;
    }

    public void setWriteCount(final Long writeCount) {
        this.writeCount = writeCount;
    }

    public Long getReadSkipCount() {
        return readSkipCount;
    }

    public void setReadSkipCount(final Long readSkipCount) {
        this.readSkipCount = readSkipCount;
    }

    public Long getWriteSkipCount() {
        return writeSkipCount;
    }

    public void setWriteSkipCount(final Long writeSkipCount) {
        this.writeSkipCount = writeSkipCount;
    }

    public Long getProcessSkipCount() {
        return processSkipCount;
    }

    public void setProcessSkipCount(final Long processSkipCount) {
        this.processSkipCount = processSkipCount;
    }

    public Long getRollbackCount() {
        return rollbackCount;
    }

    public void setRollbackCount(final Long rollbackCount) {
        this.rollbackCount = rollbackCount;
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

    public JobExecution getJobExecution() {
        return jobExecution;
    }

    public void setJobExecution(final JobExecution jobExecution) {
        this.jobExecution = jobExecution;
    }

    public Set<StepExecutionContext> getStepExecutionContexts() {
        return stepExecutionContexts;
    }

    public void setStepExecutionContexts(
            final Set<StepExecutionContext> stepExecutionContexts) {
        this.stepExecutionContexts = stepExecutionContexts;
    }

}
