package vn.techmaster.jobhunt.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.jobhunt.model.Employer;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployerRepo {
    private ConcurrentHashMap<String, Employer> employers = new ConcurrentHashMap<>();
    public EmployerRepo(){

    }
    public Collection<Employer> getAll() {
        return employers.values();
    }
    public void add(Employer employer) {
        String id = UUID.randomUUID().toString();
        employer.setId(UUID.randomUUID().toString());
        employers.put(id,employer);
    }

    public Employer get(String id) {
        return employers.get(id);
    }
//    @PostConstruct
//    public void addSomeData(){
//        this.add(new Employer());
//    }
}
