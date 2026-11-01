package fr.fabien.jpa.springbatch.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Limit;
import org.springframework.test.context.ActiveProfiles;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class TestsRepositoryJobInstance {
    @Autowired
    private RepositoryJobInstance repository;

    @Test
    public void testFindLastJobByName() {
        var jobInstance = repository.findLastJobByName("jobMajAbcLibelles");
        assertThat(jobInstance).isNotNull();
    }

    @Test
    public void testFindLastJobsByName() {
        int limit = 2;
        var jobInstances = repository.findLastJobsByName(Set.of("jobMajAbcLibelles", "jobMajAbcCotations"), Limit.of(limit));
        assertThat(jobInstances).hasSize(limit);
    }
}
