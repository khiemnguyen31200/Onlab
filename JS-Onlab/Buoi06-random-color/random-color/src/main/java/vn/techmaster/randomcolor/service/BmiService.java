package vn.techmaster.randomcolor.service;

import org.springframework.stereotype.Service;
import vn.techmaster.randomcolor.exception.BadRequestException;

@Service
public class BmiService {

    public double calBmi(double height, double weight){
        if (height<=0||weight<=0){
            throw new BadRequestException("Chiều cao hoặc cân nặng phải lớn hơn 0");
        }
        return weight/(height*height);
    }

}
