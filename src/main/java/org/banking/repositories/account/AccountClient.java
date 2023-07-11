package org.banking.repositories.account;

import org.banking.entities.AccountResponse;
import org.banking.entities.UpdateBalanceRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "AccountClient", url = "localhost:9090/account")

public interface AccountClient {
    @GetMapping
    AccountResponse getAccount(@RequestHeader(value = "document") String document, @RequestHeader(value = "numberaccount") Long numberaccount);

    @PutMapping ("/updateBalance")
    AccountResponse updateBalance(@RequestBody UpdateBalanceRequest request);
}
