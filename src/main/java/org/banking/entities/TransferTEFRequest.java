package org.banking.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferTEFRequest {
   private String documentOrigin;
   private String documentDestiny;
   private Long numberAccountDestiny;
   private Double amount;
}
