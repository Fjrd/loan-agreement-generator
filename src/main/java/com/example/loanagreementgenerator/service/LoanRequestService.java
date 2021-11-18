package com.example.loanagreementgenerator.service;

import java.util.UUID;

public interface LoanRequestService {
    byte[] findByIdAndGetAgreementPdf(UUID id);
}
