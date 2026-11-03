package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.StepExecution;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryStepExecution extends JpaRepository<StepExecution, Long> {
}
