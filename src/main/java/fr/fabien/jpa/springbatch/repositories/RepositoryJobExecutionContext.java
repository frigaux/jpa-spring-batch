package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.JobExecutionContext;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryJobExecutionContext extends JpaRepository<JobExecutionContext, String> {
}
