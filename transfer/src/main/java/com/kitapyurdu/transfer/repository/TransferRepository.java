package com.kitapyurdu.transfer.repository;

import com.kitapyurdu.transfer.entity.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {

    //public Transfer findBasketStatus(boolean status);

    public Transfer findTransferByBasketId(int basketId);

}
