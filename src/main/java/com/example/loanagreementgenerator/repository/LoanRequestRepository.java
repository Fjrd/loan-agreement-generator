package com.example.loanagreementgenerator.repository;

import com.example.loanagreementgenerator.domain.LoanRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LoanRequestRepository extends JpaRepository<LoanRequest, UUID> {
}
