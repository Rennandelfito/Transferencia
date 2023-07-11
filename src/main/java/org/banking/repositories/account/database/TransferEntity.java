package org.banking.repositories.account.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String documentOrigin;
    private String documentDestiny;
    private Long numberAccountOrigin;
    private Long numberAccountDestiny;
    private Double amount;
    private LocalDateTime dtCreate;
}
