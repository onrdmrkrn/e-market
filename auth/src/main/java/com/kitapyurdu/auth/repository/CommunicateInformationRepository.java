package com.kitapyurdu.auth.repository;

import com.kitapyurdu.auth.entity.CommunicateInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicateInformationRepository extends JpaRepository<CommunicateInformation,Integer> {
public CommunicateInformation deleteByCommunicateInformationId(int communicateInformationId);
}
