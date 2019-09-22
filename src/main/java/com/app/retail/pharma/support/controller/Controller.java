package com.app.retail.pharma.support.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
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

    @GetMapping("/hello")
    public String getHello() {
        return "Hi";
    }
    
	@PostMapping("/addingInvoice")
    void addUser(@RequestBody Invoice invoice) {
		//invoiceRepository.save(invoice);
		pharmacySupportService.addInvoice(invoice);
    }
	
	@GetMapping("/home")
    public ArrayList<HashMap<String, Comparable>> notification() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = pharmacySupportService.findCustomerToBeNotified();
        return customerNotificationList;
    }
	
	@GetMapping("/dashboard")
    public ArrayList<HashMap<String, Comparable>> recommendations() {
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = pharmacySupportService.recommendationCheck();
        return customerRecommendationList;
    }
	
	@GetMapping("/kowshik")
    public String getkowshik() {
        return "Hikowshik";
    }
	
	/*public ArrayList<HashMap<String, Comparable>> findCustomerToBeNotified() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = new ArrayList<HashMap<String, Comparable>>();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		List<Invoice> registeredCustomers = new ArrayList<Invoice>();
		registeredCustomers = (List<Invoice>) invoiceRepository.findAll();
		for(Invoice invoice: registeredCustomers){
			if(invoice.getExpectedCompletionDate().equalsIgnoreCase(currentDate)){
				HashMap<String, Comparable> customerMap = new HashMap<String, Comparable>();
				customerMap.put("CustomerName", invoice.getName());
				customerMap.put("MedicineName", invoice.getMedicineName());
				customerMap.put("ContactNumber", invoice.getContactNumber());
				customerMap.put("Email", invoice.getEmail());
				customerNotificationList.add(customerMap);
			}
		}
		return customerNotificationList;
	}
	
	public ArrayList<HashMap<String, Comparable>> recommendationCheck(){
		String recommendations = "No Recommendations";
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = new ArrayList<HashMap<String, Comparable>>();
		List<Invoice> customers = new ArrayList<Invoice>();
		customers = (List<Invoice>) invoiceRepository.findAll();
		Recommendation warehoused = new Recommendation();
		for(Invoice invoice: customers){
			HashMap<String, Comparable> recommendationMap = new HashMap<String, Comparable>();
			recommendationMap.put("CustomerName", invoice.getName());
			recommendationMap.put("ContactNumber", invoice.getContactNumber());
			recommendationMap.put("Email", invoice.getEmail());
			recommendationMap.put("Recommendations", getByMedicineName(invoice.getMedicineName(), invoice.getCount(), invoice.getAilmentName()));
			customerRecommendationList.add(recommendationMap);
		}
		return customerRecommendationList;
	}
	
	public String getByMedicineName(String medicineName, int count, String ailmentName){
		List<Recommendation> stockedMedicine = new ArrayList<Recommendation>();
		stockedMedicine = (List<Recommendation>) recommendationRepo.findAll();
		for(Recommendation medicine: stockedMedicine){
			if(medicine.getMedicineName().equalsIgnoreCase(medicineName) && medicine.getStock()<count){
				List<Recommendation> recommended = getByAilmentName(stockedMedicine, ailmentName);
				for(Recommendation recommendation: recommended){
					if(recommendation.getStock()>count){
						return "Recommend "+recommendation.getMedicineName()+" over "+medicineName;
					}
				}
				return "No Stock Available";
			}
		}
		return "No Recommendations";
	}
	
	public List<Recommendation> getByAilmentName(List<Recommendation> stockedMedicine, String ailmentName){
		List<Recommendation> ailmentMedicine = new ArrayList<Recommendation>();
		for(Recommendation medicine: stockedMedicine){
			if(medicine.getAilmentName().equalsIgnoreCase(ailmentName)){
				ailmentMedicine.add(medicine);
			}
		}
		return ailmentMedicine;
	}*/
    
}