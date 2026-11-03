package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.JobExecution;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryJobExecution extends JpaRepository<JobExecution, Long> {
}
