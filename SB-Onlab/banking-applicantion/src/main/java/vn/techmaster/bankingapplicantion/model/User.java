package vn.techmaster.bankingapplicantion.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {
    @Id @GeneratedValue
    private Long id;
    private String name;

   @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Account> accountList= new ArrayList<>();

}
