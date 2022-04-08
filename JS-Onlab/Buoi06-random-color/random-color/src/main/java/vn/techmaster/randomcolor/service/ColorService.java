package vn.techmaster.randomcolor.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import vn.techmaster.randomcolor.exception.BadRequestException;

@Service
public class ColorService {
    Random random = new Random();
    public String randomColor(int type){
        String color = "";
        switch (type) {
            case 1:
                color = randomColorName();
                break;
            case 2:
                color = randomHexColor();
                break;
            case 3:
                color = randomRgbColor();
                break;
            default:
                throw new BadRequestException("Kí tự không hợp lệ");
                
        }
        return color;
    }
    public String randomColorName(){
        String[] colors = {"red","blue","green","black","pink"};
        return colors[random.nextInt(colors.length)];
    }
    public String randomHexColor(){
        String[] characters ={"a","b","c","d","e","f","0","1","2","3","4","5","6","7","8","9"};
        StringBuilder sb = new StringBuilder("#");
        for (int i = 0; i < 6; i++) {
            sb.append(characters[random.nextInt(characters.length)]);
        }
        return sb.toString();
    }
    public String randomRgbColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return "rgb("+r+","+g+","+b+")";
    }

}
