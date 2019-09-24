package com.app.retail.pharma.support.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.service.PharmacySupportService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
	
	@Autowired
	PharmacySupportService pharmacySupportService;

    @PostMapping("/addinvoice")
    void addUser(@RequestBody Invoice invoice) {
		pharmacySupportService.addInvoice(invoice);
    }
	
	@GetMapping("/home")
    public ArrayList<HashMap<String, Comparable>> notification() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = pharmacySupportService.findCustomerToBeNotified();
		return customerNotificationList;
    }
	
	@GetMapping("/recommendations")
    public ArrayList<HashMap<String, Comparable>> recommendations() {
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = pharmacySupportService.recommendationCheck();
        return customerRecommendationList;
    }
	
	@RequestMapping(value = {"/changestatus/{id}", "/changerstatus/{id}"}, method = RequestMethod.GET)
	@ResponseBody
	public String notificationStatus(@PathVariable("id") long id){
		pharmacySupportService.changeStatus(id);
		return "Updated";
	}
	
}