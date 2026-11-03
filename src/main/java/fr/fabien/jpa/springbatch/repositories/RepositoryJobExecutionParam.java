package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.JobExecutionParam;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryJobExecutionParam extends JpaRepository<JobExecutionParam, String> {
}
