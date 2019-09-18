package com.app.retail.pharma.support.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
import com.app.retail.pharma.support.service.PharmacySupportService;

/*
 * 
 *  Controller Class for Pharmacy
 *  
 *  Created by
 *  
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {
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

}