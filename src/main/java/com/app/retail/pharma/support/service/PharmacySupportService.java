package com.app.retail.pharma.support.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
import com.app.retail.pharma.support.repositories.InvoiceRepository;
import com.app.retail.pharma.support.repositories.RecommendationRepo;

@Service
public class PharmacySupportService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
	
	@Autowired
	RecommendationRepo recommendationRepo;

	/**
	 * Adding invoice
	 * @param invoice
	 */
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	/**
	 * This method used for fetching the notification details
	 * @return List<Invoice>
	 */
	public List<Invoice> fetchNotificationValues() {
		return (List<Invoice>) invoiceRepository.findAll();
	}
	
	/**
	 * This method used for fetching the recommendation details
	 * @return List<Recommendation>
	 */
	public List<Recommendation> fetchRecommendationValues() {
		return (List<Recommendation>) recommendationRepo.findAll();
	}
	
	public void updateNotificationStatus(Invoice invoice, String status){
		invoice.setNotification_status(status);
		invoiceRepository.save(invoice);
	}
	
	public void updateRecommendationStatus(Invoice invoice, String status){
		invoice.setRecommendation_status(status);
		invoiceRepository.save(invoice);
	}
	
	public void changeStatus(long id){
		List<Invoice> registeredCustomers = fetchNotificationValues();
		for(Invoice invoice: registeredCustomers){
			if(Long.compare(id, invoice.getId()) == 0){
				String status = "Dialled";
				updateNotificationStatus(invoice, status);
			}
		}
	}
	
	public void changeRecommendationStatus(long id){
		List<Invoice> registeredCustomers = fetchNotificationValues();
		for(Invoice invoice: registeredCustomers){
			if(Long.compare(id, invoice.getId()) == 0){
				String status = "Dialled";
				updateRecommendationStatus(invoice, status);
			}
		}
	}
	
	/**
	 * Notification
	 * 	- Prepares list of customers to be notified to buy their medicine, as their expected completion date is nearer
	 * @returns ArrayList<HashMap<String, Comparable>>
	 */
	public ArrayList<HashMap<String, Comparable>> findCustomerToBeNotified() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = new ArrayList<HashMap<String, Comparable>>();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		List<Invoice> registeredCustomers = new ArrayList<Invoice>();
		// TODO : Need to change this to query specific data instead of all data
		registeredCustomers = fetchNotificationValues();
		for(Invoice invoice: registeredCustomers){
			if(invoice.getExpectedCompletionDate().equalsIgnoreCase(currentDate)){
				if(invoice.getNotification_status().equalsIgnoreCase("NA")){
					String status = "DialForSale";
					updateNotificationStatus(invoice, status);
				}
				HashMap<String, Comparable> customerMap = new HashMap<String, Comparable>();
				customerMap.put("Id", invoice.getId());
				customerMap.put("CustomerName", invoice.getName());
				customerMap.put("MedicineName", invoice.getMedicineName());
				customerMap.put("ContactNumber", invoice.getContactNumber());
				customerMap.put("Email", invoice.getEmail());
				customerMap.put("Status", invoice.getNotification_status());
				customerNotificationList.add(customerMap);
			}
		}
		return customerNotificationList;
	}
	
	/**
	 * Recommendation
	 * 	- Prepares list of customers with the recommended set of medicine
	 * @returns ArrayList<HashMap<String, Comparable>>
	 */
	public ArrayList<HashMap<String, Comparable>> recommendationCheck(){
		String recommendations = "No Recommendations";
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = new ArrayList<HashMap<String, Comparable>>();
		List<Invoice> customers = new ArrayList<Invoice>();
		customers = fetchNotificationValues();
		Recommendation warehoused = new Recommendation();
		for(Invoice invoice: customers){
			if(invoice.getNotification_status().equalsIgnoreCase("NA")){
				String status = "DialToConfirm";
				updateRecommendationStatus(invoice, status);
			}
			HashMap<String, Comparable> recommendationMap = new HashMap<String, Comparable>();
			recommendationMap.put("CustomerName", invoice.getName());
			recommendationMap.put("ContactNumber", invoice.getContactNumber());
			recommendationMap.put("Email", invoice.getEmail());
			recommendationMap.put("Recommendations", getByMedicineName(invoice.getMedicineName(), invoice.getCount(), invoice.getAilmentName()));
			recommendationMap.put("Status", invoice.getRecommendation_status());
			customerRecommendationList.add(recommendationMap);
		}
		return customerRecommendationList;
	}
	
	/**
	 * Recommendation Message
	 * 	- Generates Recommendation Message, based on the ailment of each user and stock availability of that particular medicine
	 * @param String medicineName, int count, String ailmentName
	 * @returns String
	 */
	public String getByMedicineName(String medicineName, int count, String ailmentName){
		List<Recommendation> stockedMedicine = new ArrayList<Recommendation>();
		stockedMedicine = fetchRecommendationValues();
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
	
	/**
	 * getByAilmentName
	 * 	- Fetches the list of medicine with the customer's ailment
	 * @param List<Recommendation> stockedMedicine, String ailmentName
	 * @returns List<Recommendation>
	 */
	public List<Recommendation> getByAilmentName(List<Recommendation> stockedMedicine, String ailmentName){
		List<Recommendation> ailmentMedicine = new ArrayList<Recommendation>();
		for(Recommendation medicine: stockedMedicine){
			if(medicine.getAilmentName().equalsIgnoreCase(ailmentName)){
				ailmentMedicine.add(medicine);
			}
		}
		return ailmentMedicine;
	}
			
}
