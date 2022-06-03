package vn.techmaster;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.techmaster.model.Job;

import javax.persistence.EntityManager;

public class TestJob {
    @Autowired private EntityManager entityManager;
    @Test
    public void addJob() {
        Job job = Job.builder().title("Java dev").description("2 years").build();
        entityManager.persist(job);
        System.out.println(job.getId());
    }
}
