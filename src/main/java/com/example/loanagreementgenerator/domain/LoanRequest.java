package com.example.loanagreementgenerator.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@Validated
@AllArgsConstructor
public class LoanRequest {

    @NotNull
    private UUID id;

    @NotBlank
    private String fullName;

    @NotNull
    private LocalDate birthDate;

    @NotNull
    private Double amount;

    @NotNull
    private Integer period;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    LoanApprovalStatus approvalStatus;

}
