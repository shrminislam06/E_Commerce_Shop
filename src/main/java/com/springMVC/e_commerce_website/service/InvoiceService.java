package com.springMVC.e_commerce_website.service;

import com.springMVC.e_commerce_website.entity.Invoice;
import com.springMVC.e_commerce_website.model.CreateInvoiceModel;

public interface InvoiceService {
    Boolean createInvoice(CreateInvoiceModel createInvoiceModel);

    Iterable<Invoice> getAll();
}
