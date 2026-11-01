package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.JobInstance;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;


public interface RepositoryJobInstance extends JpaRepository<JobInstance, Long> {
    @Query("""
            select ji
                from JobInstance ji
                    inner join fetch ji.jobExecutions je
                    inner join fetch je.jobExecutionParams
                    inner join fetch je.stepExecutions
                where ji.jobName = :jobName
                and ji.jobInstanceId = (select MAX(jobInstanceId) from JobInstance where jobName = :jobName)
            """)
    JobInstance findLastJobByName(@Param("jobName") String jobName);

    @Query("""
            select ji
                from JobInstance ji
                    inner join fetch ji.jobExecutions je
                    inner join fetch je.jobExecutionParams
                    inner join fetch je.stepExecutions
                where ji.jobName IN (:jobNames)
                order by ji.jobInstanceId DESC
            """)
    List<JobInstance> findLastJobsByName(@Param("jobNames") Set<String> jobNames, Limit limit);
}
