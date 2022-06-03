package vn.techmaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.model.Employer;
import vn.techmaster.repository.EmployerRepo;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class EmployerController {
@Autowired
private EmployerRepo employerRepo;

@GetMapping
    public List<Employer> getAll(){
        return employerRepo.findAll();
}
@GetMapping("/{id}")
    public Optional<Employer> findById(@PathVariable Long id){
     return employerRepo.findById(id);
}
@PostMapping("/add")
    public Employer add(@RequestBody Employer employer){
    employerRepo.save(employer);
    return employer;
}
@PutMapping("/update/{id}")
    public Employer add(@RequestBody Employer employer,@PathVariable Long id) {
    Optional<Employer> employerPut = employerRepo.findById(id);
    employerPut.get().setName(employer.getName());
    employerPut.get().setEmail(employer.getEmail());
    employerPut.get().setWebsite(employer.getWebsite());
    employerRepo.save(employerPut.get());
    return employerPut.get();
}
@DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
    employerRepo.deleteById(id);
}
}
