package com.springMVC.e_commerce_website.service.IMPL;

import com.springMVC.e_commerce_website.entity.Invoice;
import com.springMVC.e_commerce_website.entity.InvoiceItem;
import com.springMVC.e_commerce_website.entity.InvoiceItemPk;
import com.springMVC.e_commerce_website.entity.Product;
import com.springMVC.e_commerce_website.model.CreateInvoiceModel;
import com.springMVC.e_commerce_website.model.ProductQtyModel;
import com.springMVC.e_commerce_website.repository.InvoiceItemRepository;
import com.springMVC.e_commerce_website.repository.InvoiceRepository;
import com.springMVC.e_commerce_website.repository.ProductRepository;
import com.springMVC.e_commerce_website.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final ProductRepository productRepository;
    private final InvoiceItemRepository invoiceItemRepository;
    @Override
    public Boolean createInvoice(CreateInvoiceModel createInvoiceModel) {
        Invoice newInvoice = new Invoice();
        newInvoice.setBuyerName(createInvoiceModel.getBuyerName());
        newInvoice.setContactNo(createInvoiceModel.getContactNo());
        newInvoice.setTotalBill(createInvoiceModel.getTotalBill());
        newInvoice.setPurchaseDate(LocalDateTime.now());


        Set<Long> productIds = createInvoiceModel.getProductQtyModels().stream().map(ProductQtyModel::getProductId).collect(Collectors.toSet());

        Set<Product> products = productRepository.getAllByIdIn(productIds);

        if (products.size() != productIds.size()){
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product validation Failed......");
        }
        List<InvoiceItem> invoiceItems = createInvoiceModel.getProductQtyModels().stream().map(productQtyModel -> {
            Product product1 = products.stream().filter(product -> product.getId() == productQtyModel.getProductId()).findFirst().orElse(null);
            InvoiceItemPk invoiceItemPk = new InvoiceItemPk(newInvoice, product1);
            InvoiceItem invoiceItem = new InvoiceItem();
            invoiceItem.setId(invoiceItemPk);
            invoiceItem.setQuantity(productQtyModel.getProductQty());
            invoiceItem.setAddDate(LocalDateTime.now());
            invoiceItem.setModDate(null);
            invoiceItem.setTotalAmount(productQtyModel.getProductQty() * product1.getSellingPrice());

            return invoiceItem;

        }).collect(Collectors.toList());

        invoiceRepository.save(newInvoice);
        invoiceItemRepository.saveAll(invoiceItems);

        return invoiceItems.size()>0;
    }

    @Override
    public Iterable<Invoice> getAll() {

        return invoiceRepository.findAll();
    }
}
