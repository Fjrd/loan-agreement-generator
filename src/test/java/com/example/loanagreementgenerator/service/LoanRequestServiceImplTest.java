package com.example.loanagreementgenerator.service;

import com.example.loanagreementgenerator.LoanRequestMapper;
import com.example.loanagreementgenerator.domain.LoanApprovalStatus;
import com.example.loanagreementgenerator.domain.LoanRequest;
import com.example.loanagreementgenerator.repository.LoanRequestRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class LoanRequestServiceImplTest {

    @Mock
    private LoanRequestRepository repository;

    @Mock
    private LoanRequestMapper mapper;

    @InjectMocks
    private LoanRequestServiceImpl service;

    LoanRequest request = LoanRequest.builder()
            .id(UUID.randomUUID())
            .fullName("Vasiliy Vasil'evich Pupkin")
            .amount(1000000.0)
            .birthDate(LocalDate.of(1990, 12, 12))
            .period(24)
            .approvalStatus(LoanApprovalStatus.ОДОБРЕН)
            .build();


    @BeforeEach
    void setUp() {
        service = new LoanRequestServiceImpl(repository, mapper);
    }

    @SneakyThrows
    @Test
    void generatePdfWorkCorrectlyTest() {
        service.generatePdf(request);
        //TODO refactor
    }
}