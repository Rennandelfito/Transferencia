package org.banking.service;

import org.banking.entities.AccountResponse;
import org.banking.entities.UpdateBalanceRequest;
import org.banking.repositories.account.AccountClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
  private  AccountClient client;

    public AccountResponse getAccount(String document, Long numberaccount){
        return client.getAccount(document, numberaccount);
    }
    public AccountResponse updateBalance(UpdateBalanceRequest request){
        return client.updateBalance(request);
    }
}
