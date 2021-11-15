package com.example.loanagreementgenerator.dto;

import com.example.loanagreementgenerator.domain.LoanApprovalStatus;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Validated
public class LoanRequestDto {

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
    LoanApprovalStatus approvalStatus;

}
