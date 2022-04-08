package vn.techmaster.randomcolor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.randomcolor.request.BmiRequest;
import vn.techmaster.randomcolor.service.BmiService;

@RestController
public class BmiController {
    @Autowired
    private BmiService bmiService;
    @GetMapping("/bmi")
    public ResponseEntity<?> calBmi(@RequestParam double height, @RequestParam double weight){
        double bmi = bmiService.calBmi(height,weight);
        return ResponseEntity.ok(bmi);
    }
    @PostMapping("/bmi")
    public ResponseEntity<?> calBmiPost(@RequestBody BmiRequest request){
        double bmi = bmiService.calBmi(request.getHeight(), request.getWeight());
        return ResponseEntity.ok(bmi);
    }
}
