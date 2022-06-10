package com.kitapyurdu.payment.mapper;

import java.util.List;

public interface iEntityMapper <R,E>{
    R toResource(E e);
    E toEntity(R r);
    List<R> toResource(List<E> eList);
    List<E> toEntity(List<R> rList);
}


