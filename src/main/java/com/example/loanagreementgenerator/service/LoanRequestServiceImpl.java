package com.example.loanagreementgenerator.service;

import com.example.loanagreementgenerator.LoanRequestMapper;
import com.example.loanagreementgenerator.domain.LoanRequest;
import com.example.loanagreementgenerator.repository.LoanRequestRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService{

    private final LoanRequestRepository repository;
    private final LoanRequestMapper mapper;
    private static final String FONT = "fonts/arial.ttf";
    private static final String AGREEMENT_TITLE = "Договор кредитования";

    @SneakyThrows
    @Override
    public void findById(UUID id) {
        log.info("findById(), id = {}", id);
        LoanRequest request = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));
        //TODO refactor
        generatePdf(request);
    }

    public void generatePdf(LoanRequest request) throws IOException, DocumentException {
        Font font = FontFactory.getFont(FONT, "cp1251", BaseFont.EMBEDDED, 10);

        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("hello.pdf"));
        document.open();
        document.addTitle(AGREEMENT_TITLE);
        document.add(new Paragraph(request.getId().toString()));
        document.add(new Paragraph(request.getFullName()));
        document.add(new Paragraph(request.getPeriod().toString()));
        document.add(new Paragraph(request.getAmount().toString()));
        document.add(new Paragraph(request.getBirthDate().toString()));
        document.add(new Paragraph(request.getApprovalStatus().toString(), font));
        document.close();

        //TODO refactor
        //TODO FONT
        //TODO return file
    }
}
