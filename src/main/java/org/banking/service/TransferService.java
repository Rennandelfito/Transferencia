package org.banking.service;

import org.banking.entities.*;
import org.banking.entities.exception.TransferValidationException;
import org.banking.repositories.account.database.TransferEntity;
import org.banking.repositories.account.database.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TransferService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private TransferRepository transferRepository;

    public void tef(TransferTEFRequest request) {
        Double amount = request.getAmount();
        String documentDestiny = request.getDocumentDestiny();
        String documentOrigin = request.getDocumentOrigin();
        Long numberAccountDestiny = request.getNumberAccountDestiny();

        AccountResponse accountOrigin = accountService.getAccount(documentOrigin, null);

        validateBalance(amount, accountOrigin);
        validateStatusAccount(accountOrigin);
        if (documentDestiny == null && numberAccountDestiny == null)
            throw new TransferValidationException("field destiny invalide");

        AccountResponse accountDestiny = accountService.getAccount(documentDestiny, numberAccountDestiny);
        validateStatusAccount(accountDestiny);
        UpdateBalanceRequest requestBalanceOrigin = new UpdateBalanceRequest(documentOrigin, null, amount, BalanceActionEnum.WITHDRAW);
        UpdateBalanceRequest requestBalanceDestiny = new UpdateBalanceRequest(accountDestiny.getDocument(), null, amount, BalanceActionEnum.DEPOSIT);

        accountService.updateBalance(requestBalanceOrigin);
        accountService.updateBalance(requestBalanceDestiny);

        TransferEntity entity = new TransferEntity(
                null, documentOrigin,
                documentDestiny,
                accountOrigin.getNumberAccount(),
                accountDestiny.getNumberAccount(),
                amount,
                LocalDateTime.now()

        );
        transferRepository.save(entity);
    }

    private static void validateStatusAccount(AccountResponse accountOrigin) {
        if (!(accountOrigin.getStatus() == StatusAccountEnum.ACTIVE)) {
            throw new TransferValidationException("Cannot make transfer with account blocked");
        }
    }

    private static void validateBalance(Double amount, AccountResponse accountOrigin) {
        if (amount > accountOrigin.getBalance()) {
            throw new TransferValidationException("there is no balance enough");
        }
    }
}
