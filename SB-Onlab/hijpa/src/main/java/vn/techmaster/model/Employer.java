package vn.techmaster.model;

import lombok.*;

import javax.persistence.*;


@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
@Entity //Kí hiệu một bản ghi
@Table //Name dùng để đổi tên bảng khác mặc định trong databasse
public class Employer {
    @Id//Đánh dấu khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)//
    private Long id;
    private String name;
    private String email;
    private String website;
}
