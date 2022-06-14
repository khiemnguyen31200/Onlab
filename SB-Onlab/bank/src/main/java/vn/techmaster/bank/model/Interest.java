package vn.techmaster.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
@Builder
public class Interest {
    @Id
    private String id;

    @Enumerated
    private MonthSaver months;

    private Double interest;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "saver_account_id")
    private List<SaverAcc> listAccount = new ArrayList<>();
}
