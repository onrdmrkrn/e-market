package com.kitapyurdu.payment.mapper;

import com.kitapyurdu.payment.dto.PaymentDto;
import com.kitapyurdu.payment.entity.Transaction;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMapper extends iEntityMapper<PaymentDto, Transaction> {
}
