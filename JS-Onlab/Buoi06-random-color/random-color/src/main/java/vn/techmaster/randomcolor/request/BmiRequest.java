package vn.techmaster.randomcolor.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BmiRequest {
    private double weight;
    private double height;
}
