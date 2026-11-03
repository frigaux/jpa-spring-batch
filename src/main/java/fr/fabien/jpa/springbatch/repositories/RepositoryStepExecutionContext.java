package fr.fabien.jpa.springbatch.repositories;

import fr.fabien.jpa.springbatch.entities.StepExecutionContext;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RepositoryStepExecutionContext extends JpaRepository<StepExecutionContext, String> {
}
