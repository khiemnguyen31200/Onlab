package vn.techmaster.bank.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User requester;

    public Command(User requester){
        this.requester = requester;
    }
    private CommandStatus status;
    private LocalDateTime startAt;
    private LocalDateTime finishAt;

    @PrePersist // Khi lệnh bắt đầu chạy lệnh này
    public void prePresist(){
        startAt = LocalDateTime.now();
    }

    @PreUpdate // Khi lệnh chạy xong
    public void preUpdate(){
        finishAt = LocalDateTime.now();
    }
}
