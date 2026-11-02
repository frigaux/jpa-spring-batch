package fr.fabien.jpa.springbatch.entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(
        name = "BATCH_JOB_INSTANCE",
        uniqueConstraints = @UniqueConstraint(columnNames = {"JOB_NAME", "JOB_KEY"})
)
public class JobInstance {
    @Id
    @Column(name = "JOB_INSTANCE_ID", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobInstanceId;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "JOB_NAME", nullable = false, length = 100)
    private String jobName;

    @Column(name = "JOB_KEY", nullable = false, length = 32)
    private String jobKey;

    @OneToMany(mappedBy = "jobInstance")
    private Set<JobExecution> jobExecutions = new HashSet<>();

    public JobInstance() {
    }

    public JobInstance(Long version, String jobName, String jobKey, Set<JobExecution> jobExecutions) {
        this.version = version;
        this.jobName = jobName;
        this.jobKey = jobKey;
        this.jobExecutions = jobExecutions;
    }
}
