package com.jwt.controller;


import com.jwt.model.Invoice;
import com.jwt.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(origins = "*") // Assuming CORS is configured as needed
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Create a new invoice
    @PostMapping
    public Invoice createInvoice(@Valid @RequestBody Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    // Read all invoices
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Read an invoice by ID
    @GetMapping("/{id}")
    public Optional<Invoice> getInvoiceById(@PathVariable Long id) {
        return invoiceRepository.findById(id);
    }

    // Update an invoice
    @PutMapping("/{id}")
    public Invoice updateInvoice(@Valid @PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        // Update invoice details (replace with your specific fields)
        invoice.setCustomerName(invoiceDetails.getCustomerName());
        invoice.setOrderNumber(invoiceDetails.getOrderNumber()); // Assuming linking to Order model
        invoice.setDueDate(invoiceDetails.getDueDate());
        invoice.setInvoiceAmount(invoiceDetails.getInvoiceAmount());
        invoice.setStatus(invoiceDetails.getStatus()); // Assuming invoice status (Paid, Unpaid, etc.)
        return invoiceRepository.save(invoice);
    }

    // Delete an invoice
    @DeleteMapping("/{id}")
    public String deleteInvoice(@PathVariable Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        invoiceRepository.delete(invoice);
        return "Invoice deleted successfully!";
    }
}
