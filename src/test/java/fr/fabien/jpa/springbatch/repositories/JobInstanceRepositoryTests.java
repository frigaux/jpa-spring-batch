package fr.fabien.jpa.springbatch.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class JobInstanceRepositoryTests {
    @Autowired
    private JobInstanceRepository repository;

    @Test
    public void testFindAll() {
        var jobInstance = repository.findLastJobByName("jobMajAbcLibelles");
        assertThat(jobInstance).isNotNull();
    }
}
