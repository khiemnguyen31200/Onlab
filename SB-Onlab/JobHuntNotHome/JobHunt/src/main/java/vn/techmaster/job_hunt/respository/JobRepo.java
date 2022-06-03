package vn.techmaster.job_hunt.respository;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.techmaster.job_hunt.model.City;
import vn.techmaster.job_hunt.model.Employer;
import vn.techmaster.job_hunt.model.Job;

@Repository
public class JobRepo {

  private ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();

  public Collection<Job> getAll(){
    return jobs.values().stream().sorted((o2,o1) -> (o1.getUpdateTime().compareTo(o2.getUpdateTime()))).collect(Collectors.toList());
  }

  public Job addJob(Job job) {
    String id = UUID.randomUUID().toString();
    job.setId(id);
    job.setCreateTime(LocalDateTime.now());
    job.setUpdateTime(job.getCreateTime());
    jobs.put(id, job);
    return job;
  }

  public Job addJobForEmployer(Employer employer, Job job) {
    String id = UUID.randomUUID().toString();
    job.setId(id);
    job.setCreateTime(LocalDateTime.now());
    job.setUpdateTime(job.getCreateTime());
    job.setEmp_id(employer.getId());
    jobs.put(id, job);
    return job;
  }

  public Job findById(String id) {
    return jobs.get(id);
  }

  public Collection<Job> findByEmpId(String empId) {
    return jobs.entrySet().stream()
		.filter(x -> empId.equals(x.getValue().getEmp_id()))
		.map(x->x.getValue()).collect(Collectors.toList());
  }

  public Collection<Job> findByTitle(String title) {
    return jobs.entrySet().stream()
        .filter(x -> title.equals(x.getValue().getTitle()))
        .map(x -> x.getValue()).collect(Collectors.toList());
  }

  public Job deleteById(String id) {
    return jobs.remove(id);
  }

  public void update(Job job){
    job.setUpdateTime(LocalDateTime.now());
    jobs.put(job.getId(), job);
  }


  public List<Job> SearchByKeyword(String search, String city) {
    if(search.equals("")&&city.equals("----City----")){
      return  jobs.values().stream().collect(Collectors.toList());
    }
    else if(search.equals("")){
      return jobs.values().stream().filter(job -> job.SearchByCity(city)).collect(Collectors.toList());
    }else if(city.equals("----City----")){
      return jobs.values().stream().filter(job -> job.SearchByOnlyKeyword(search)).collect(Collectors.toList());
    }
    return jobs.values().stream().filter(job -> job.SearchByKeyword(search,city)).collect(Collectors.toList());
  }
}

