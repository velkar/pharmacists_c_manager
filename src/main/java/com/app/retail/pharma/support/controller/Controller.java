package com.app.retail.pharma.support.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
=======
>>>>>>> a52a26587a6c7bbb8dd34df509077e06bd4b08d7
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
<<<<<<< HEAD
import com.app.retail.pharma.support.repositories.InvoiceRepository;
import com.app.retail.pharma.support.repositories.RecommendationRepo;
=======
import com.app.retail.pharma.support.service.PharmacySupportService;

/*
 * 
 *  Controller Class for Pharmacy
 *  
 *  Created by
 *  
 */
>>>>>>> a52a26587a6c7bbb8dd34df509077e06bd4b08d7

@RestController
@CrossOrigin(origins = "https://localhost:4200")
public class Controller {
<<<<<<< HEAD
	
	@Autowired
    InvoiceRepository invoiceRepository;
	
	@Autowired
	RecommendationRepo recommendationRepo;

    @GetMapping("/hello")
    public String getHello() {
        return "Hi";
    }
    
	@PostMapping("/addingInvoice")
    void addUser(@RequestBody Invoice invoice) {
		invoiceRepository.save(invoice);
    }
	
	@GetMapping("/home")
    public ArrayList<HashMap<String, Comparable>> notification() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = findCustomerToBeNotified();
        return customerNotificationList;
    }
	
	public ArrayList<HashMap<String, Comparable>> findCustomerToBeNotified() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = new ArrayList<HashMap<String, Comparable>>();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		List<Invoice> registeredCustomers = new ArrayList<Invoice>();
		registeredCustomers = (List<Invoice>) invoiceRepository.findAll();
		for(Invoice invoice: registeredCustomers){
			if(invoice.getExpectedCompletionDate().equalsIgnoreCase(currentDate)){
				HashMap<String, Comparable> customerMap = new HashMap<String, Comparable>();
				customerMap.put("CustomerName", invoice.getName());
				customerMap.put("MedicineName", invoice.getmName());
				customerMap.put("ContactNumber", invoice.getContactNumber());
				customerMap.put("Email", invoice.getEmail());
				customerNotificationList.add(customerMap);
			}
		}
		return customerNotificationList;
	}
    
=======
	public PharmacySupportService pharmacySupport;

	/**
	 * 
	 * @param supportService
	 */
	public Controller(PharmacySupportService supportService) {
		this.pharmacySupport = supportService;
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/users")
	public List<Invoice> getUser() {
		return pharmacySupport.authentication();
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getRecommandation")
	public List<Invoice> getRecommadation() {
		return (List<Invoice>) pharmacySupport.fetchRecommandationValues();
	}

	/**
	 * 
	 * @return
	 */
	@GetMapping("/getNotification")
	public List<Invoice> getNotification() {
		return (List<Invoice>) pharmacySupport.fetNotificationValues();
	}

	/**
	 * 
	 * @param invoice
	 */
	@PostMapping("/addInvoice")
	public void addNotification(@RequestBody Invoice invoice) {
		pharmacySupport.addNotificationValues(invoice);
	}

	/**
	 * 
	 * @param invoice
	 */
	@PostMapping("/updateNotice")
	public void updateNoticeStatus(@RequestBody Invoice invoice) {
		pharmacySupport.updateNoticeValues(invoice);
	}

	/**
	 * 
	 * @param recommandation
	 */
	/*@PostMapping("/updateRecommadation")
	public void updateRecomandationStatus(
			@RequestBody Recommendation recommandation) {

		pharmacySupport.updateRecommandationValues(recommandation);
	}*/

>>>>>>> a52a26587a6c7bbb8dd34df509077e06bd4b08d7
}