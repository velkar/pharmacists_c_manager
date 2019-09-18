package com.app.retail.pharma.support.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.repositories.InvoiceRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {

    private final InvoiceRepository invoiceRepository;

    public Controller(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @GetMapping("/users")
    public List<Invoice> get() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    @PostMapping("/users")
    void addUser(@RequestBody Invoice invoice) {
    	invoiceRepository.save(invoice);
    }
    public void authentication(){
    	
    	
    }   
   /* @GetMapping("/getRecommandation")
    public List<Recommendation> getRecommadation() {
    	return (List<Invoice>) invoiceRepository.findAll();
    }
    @GetMapping("/getNotification")
    public void getNotification() {
    	return (List<Invoice>) invoiceRepository.findAll();
    	
    }*/
    @PostMapping("/addInvoice")
   public void  addNotification(@RequestBody Invoice invoice) {
    	invoiceRepository.save(invoice);
    	
    }
    @PostMapping("/updateNotice")
    public void updateNoticeStatus(@RequestBody Invoice invoice) {
    	invoiceRepository.save(invoice);
    	
    }
   /* @PostMapping("/updateRecommadation")
   public void  updateRecomandationStatus(@RequestBody Recommendation recommandation){
    	
    	invoiceRepository.save(recommandation);
    }*/
    
    
}