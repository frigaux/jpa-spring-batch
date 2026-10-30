package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.JobInstance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface JobInstanceRepository extends JpaRepository<JobInstance, Long> {
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
}
