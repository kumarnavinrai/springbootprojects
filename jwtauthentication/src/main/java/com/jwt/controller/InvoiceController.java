package com.jwt.controller;

import com.jwt.model.Invoice;
import com.jwt.repo.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Invoice> createInvoice(@Valid @RequestBody Invoice invoice) {
        Invoice savedInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedInvoice);
    }

    // Read all invoices
    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices() {
        List<Invoice> invoices = invoiceRepository.findAll();
        return ResponseEntity.ok().body(invoices);
    }

    // Read an invoice by ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        return invoice.map(value -> ResponseEntity.ok().body(value))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an invoice
    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@Valid @PathVariable Long id, @RequestBody Invoice invoiceDetails) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + id));
        // Update invoice details (replace with your specific fields)
        invoice.setCustomerName(invoiceDetails.getCustomerName());
        invoice.setOrderNumber(invoiceDetails.getOrderNumber()); // Assuming linking to Order model
        invoice.setDueDate(invoiceDetails.getDueDate());
        invoice.setInvoiceAmount(invoiceDetails.getInvoiceAmount());
        invoice.setStatus(invoiceDetails.getStatus()); // Assuming invoice status (Paid, Unpaid, etc.)
        Invoice updatedInvoice = invoiceRepository.save(invoice);
        return ResponseEntity.ok().body(updatedInvoice);
    }

    // Delete an invoice
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInvoice(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceRepository.findById(id);
        if (invoice.isPresent()) {
            invoiceRepository.delete(invoice.get());
            return ResponseEntity.ok().body("Invoice deleted successfully!");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
