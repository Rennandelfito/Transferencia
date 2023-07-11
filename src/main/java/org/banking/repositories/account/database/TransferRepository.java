package org.banking.repositories.account.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface TransferRepository extends JpaRepository<TransferEntity, Long> {

}
