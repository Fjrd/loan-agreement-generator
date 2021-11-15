package com.example.loanagreementgenerator;


import com.example.loanagreementgenerator.domain.LoanRequest;
import com.example.loanagreementgenerator.dto.LoanRequestDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoanRequestMapper {
    LoanRequestDto modelToDto(LoanRequest request);
    LoanRequest dtoToModel(LoanRequestDto requestDto);
}
