package com.example.loanagreementgenerator.service;

import com.example.loanagreementgenerator.LoanRequestMapper;
import com.example.loanagreementgenerator.domain.LoanRequest;
import com.example.loanagreementgenerator.dto.LoanRequestDto;
import com.example.loanagreementgenerator.repository.LoanRequestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService{

    LoanRequestRepository repository;
    LoanRequestMapper mapper;

    @Override
    public SomePDFClass findById(UUID id) {
        log.info("findById(), id = {}", id);
        LoanRequest request = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        return mapper.modelToDto(request);
    }
}
