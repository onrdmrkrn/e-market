package com.kitapyurdu.payment.repository;

import com.kitapyurdu.payment.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Transaction, Integer> {
    public Transaction findPaymentByBasketId(int paymentId);
}
