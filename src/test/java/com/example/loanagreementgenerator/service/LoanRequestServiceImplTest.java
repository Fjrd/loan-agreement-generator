package com.example.loanagreementgenerator.service;

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

import java.io.File;
import java.nio.file.Files;
import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class LoanRequestServiceImplTest {

    @Mock
    private LoanRequestRepository repository;

    @InjectMocks
    private LoanRequestServiceImpl service;

    LoanRequest request;



    @BeforeEach
    void setUp() {
        service = new LoanRequestServiceImpl(repository);
        request = LoanRequest.builder()
                .id(UUID.randomUUID())
                .fullName("Vasiliy Vasil'evich Pupkin")
                .amount(1000000.0)
                .birthDate(LocalDate.of(1990, 12, 12))
                .period(24)
                .approvalStatus(LoanApprovalStatus.ОДОБРЕН)
                .build();
    }

    @SneakyThrows
    @Test
    void generatePdfWritesFileTest() {
        File file = service.generateAndSavePdf(request);
        byte[] bytes = Files.readAllBytes(file.toPath());
        assertThat(bytes)
                .isNotNull()
                .isNotEmpty();

        Files.deleteIfExists(file.toPath());
    }
}