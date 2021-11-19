package com.example.loanagreementgenerator.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Validated
@Entity
@Table(name = "loan_requests", schema = "public")
@AllArgsConstructor
@NoArgsConstructor
public class LoanRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "loan_request_id")
    private UUID id;

    @NotBlank
    private String fullName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private BigDecimal amount;

    @NotNull
    private Integer period;

    @Enumerated(value = EnumType.STRING)
    LoanApprovalStatus approvalStatus;
}
