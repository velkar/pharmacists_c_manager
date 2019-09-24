package com.app.retail.pharma.support.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.repositories.InvoiceRepository;
import com.app.retail.pharma.support.repositories.RecommendationRepo;
import com.app.retail.pharma.support.service.PharmacySupportService;

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class Controller {
	
	@Autowired
    InvoiceRepository invoiceRepository;
	
	@Autowired
	RecommendationRepo recommendationRepo;
	
	PharmacySupportService pharmacySupportService;

    @PostMapping("/addingInvoice")
    void addUser(@RequestBody Invoice invoice) {
		pharmacySupportService = new PharmacySupportService(invoiceRepository, recommendationRepo);
		pharmacySupportService.addInvoice(invoice);
    }
	
	@GetMapping("/home")
    public ArrayList<HashMap<String, Comparable>> notification() {
		pharmacySupportService = new PharmacySupportService(invoiceRepository, recommendationRepo);
		ArrayList<HashMap<String, Comparable>> customerNotificationList = pharmacySupportService.findCustomerToBeNotified();
		return customerNotificationList;
    }
	
	@GetMapping("/recommendations")
    public ArrayList<HashMap<String, Comparable>> recommendations() {
		pharmacySupportService = new PharmacySupportService(invoiceRepository, recommendationRepo);
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = pharmacySupportService.recommendationCheck();
        return customerRecommendationList;
    }
	
}