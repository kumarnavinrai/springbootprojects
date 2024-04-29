package com.jwt.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    // Assuming a OneToMany relationship with Order model (optional)
//    @OneToMany(mappedBy = "invoice")  // Assuming "invoice" field in Order model
//    private List<Order> orders;
//
//    @ManyToOne(optional = true)  // Optional invoice association
//    @JoinColumn(name = "invoice_id")
//    private Invoice invoice;

    @Column(name = "invoice_amount")
    private BigDecimal invoiceAmount;

    @Column(name = "created", updatable = false)
    private LocalDateTime created;

    @Column(name = "updated")
    private LocalDateTime updated;

    // Optional fields based on your requirements
    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "order_number")
    private String orderNumber; // Assuming linking to a specific order

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "status")
    private String status; // Assuming invoice status (Paid, Unpaid, etc.)

    // Constructors, getters, and setters (update with new fields)

    public Invoice() {
    }

    public Invoice(List<Order> orders, BigDecimal invoiceAmount) {
//        this.orders = orders;
        this.invoiceAmount = invoiceAmount;
    }

    // Getters and setters for all fields (including new ones)

    public void setInvoiceAmount(BigDecimal invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public BigDecimal getInvoiceAmount() {
        return invoiceAmount;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // ... other existing getters and setters

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", invoiceAmount=" + invoiceAmount +
                ", created=" + created +
                ", updated=" + updated +
                ", customerName='" + customerName + '\'' +
                ", orderNumber='" + orderNumber + '\'' +
                ", dueDate=" + dueDate +
                ", status='" + status + '\'' +
                '}';
    }
}
