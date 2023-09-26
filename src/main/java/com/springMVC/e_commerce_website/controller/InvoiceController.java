package com.springMVC.e_commerce_website.controller;

import com.springMVC.e_commerce_website.entity.Invoice;
import com.springMVC.e_commerce_website.model.CreateInvoiceModel;
import com.springMVC.e_commerce_website.service.IMPL.InvoiceServiceImpl;
import com.springMVC.e_commerce_website.service.InvoiceService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceServiceImpl invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/createInvoice")
    public ResponseEntity<Boolean> createInvoice(@RequestBody @Valid CreateInvoiceModel createInvoiceModel) {
        return ResponseEntity.ok(invoiceService.createInvoice(createInvoiceModel));
    }
    @GetMapping("/all")
    public Iterable<Invoice>getAll(){
       return invoiceService.getAll();
    }
}
