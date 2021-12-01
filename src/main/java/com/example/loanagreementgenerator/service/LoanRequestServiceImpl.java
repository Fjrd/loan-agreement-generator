package com.example.loanagreementgenerator.service;

import com.example.loanagreementgenerator.domain.LoanApprovalStatus;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoanRequestServiceImpl implements LoanRequestService{

    private final LoanRequestRepository repository;
    private static final String FONT = "fonts/arial.ttf";
    private static final String AGREEMENT_TITLE = "Договор кредитования";

    @SneakyThrows
    @Override
    public byte[] findByIdAndGetAgreementPdf (UUID id) {
        log.info("findById(), id = {}", id);

        LoanRequest request = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id.toString()));

        return request.getApprovalStatus() == LoanApprovalStatus.APPROVED ?
                loadPdfFile(generateAndSavePdf(request)):
                null;

    }

    public File generateAndSavePdf(LoanRequest request) throws IOException, DocumentException {
        log.info("generatePdf(), request = {}", request);

        String pathToSavedAgreementPdf = "temp/agreements/" + request.getFullName() + ".pdf";

        String idTextText = "Id: ";
        String fullNameText = "Full name: ";
        String birthDateText = "Birth date: ";
        String amountText = "Amount: ";
        String periodText = "Period: ";
        String approvalStatusText = "Status: ";

        Font font = FontFactory.getFont(FONT, "cp1251", BaseFont.EMBEDDED, 10);
        Document document = new Document();
        File file = new File(pathToSavedAgreementPdf);
        PdfWriter.getInstance(document, new FileOutputStream(file));

        document.open();
        Paragraph title = new Paragraph(AGREEMENT_TITLE, font);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);
        document.add(new Paragraph(idTextText + request.getId(), font));
        document.add(new Paragraph(fullNameText + request.getFullName(), font));
        document.add(new Paragraph(birthDateText + request.getBirthDate(), font));
        document.add(new Paragraph(amountText + request.getAmount(), font));
        document.add(new Paragraph(periodText + request.getPeriod(), font));
        document.add(new Paragraph(approvalStatusText + request.getApprovalStatus(), font));
        document.close();

        log.info("generatePdf(), path to created file " + pathToSavedAgreementPdf);
        return file;
    }

    public byte[] loadPdfFile(File file) throws IOException {
        return Files.readAllBytes(file.toPath());
    }
}
