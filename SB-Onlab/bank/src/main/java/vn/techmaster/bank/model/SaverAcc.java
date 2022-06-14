package vn.techmaster.bank.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
@Builder
public class SaverAcc {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    private CommandStatus status;
    private LocalDate startAt;
    private LocalDate finishAt;

    private LocalDate closeAt;


    private Long startBalance;
    private Long endBalance;

    private TypeGiveInterest typeGiveInterest;

    @ManyToOne(fetch = FetchType.LAZY)
    private Interest interest; //Mỗi account phải gắn vào một user

    @PrePersist // Khi lệnh bắt đầu chạy lệnh này
    public void prePresist(){
        startAt = LocalDate.now();
    }

    @PreUpdate // Khi lệnh chạy xong
    public void preUpdate(){
        finishAt = LocalDate.now();
    }
}
