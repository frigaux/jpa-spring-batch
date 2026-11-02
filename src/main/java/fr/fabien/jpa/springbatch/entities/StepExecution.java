package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "BATCH_STEP_EXECUTION", indexes = @Index(columnList = "JOB_EXECUTION_ID"))
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

    public StepExecution() {
    }

    public StepExecution(Long version, String stepName, OffsetDateTime createTime, OffsetDateTime startTime, OffsetDateTime endTime, String status, Long commitCount, Long readCount, Long filterCount, Long writeCount, Long readSkipCount, Long writeSkipCount, Long processSkipCount, Long rollbackCount, String exitCode, String exitMessage, OffsetDateTime lastUpdated, JobExecution jobExecution, Set<StepExecutionContext> stepExecutionContexts) {
        this.version = version;
        this.stepName = stepName;
        this.createTime = createTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.commitCount = commitCount;
        this.readCount = readCount;
        this.filterCount = filterCount;
        this.writeCount = writeCount;
        this.readSkipCount = readSkipCount;
        this.writeSkipCount = writeSkipCount;
        this.processSkipCount = processSkipCount;
        this.rollbackCount = rollbackCount;
        this.exitCode = exitCode;
        this.exitMessage = exitMessage;
        this.lastUpdated = lastUpdated;
        this.jobExecution = jobExecution;
        this.stepExecutionContexts = stepExecutionContexts;
    }
}
