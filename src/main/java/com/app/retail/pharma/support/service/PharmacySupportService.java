package com.app.retail.pharma.support.service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
import com.app.retail.pharma.support.repositories.InvoiceRepository;
import com.app.retail.pharma.support.repositories.RecommendationRepo;

/*
 * PharmacyService class
 *  
 */
public class PharmacySupportService {

	private final InvoiceRepository invoiceRepository;
	
	private final RecommendationRepo recommendationRepo;

	/**
	 * @param invoiceRepository
	 */
	public PharmacySupportService(InvoiceRepository invoiceRepository, RecommendationRepo recommendationRepo) {
		this.invoiceRepository = invoiceRepository;
		this.recommendationRepo = recommendationRepo;
	}
	
	/**
	 * This method used for adding invoice as notification values
	 * @param invoice
	 */
	public void addInvoice(Invoice invoice) {
		invoiceRepository.save(invoice);
	}
	
	
	
	public ArrayList<HashMap<String, Comparable>> findCustomerToBeNotified() {
		ArrayList<HashMap<String, Comparable>> customerNotificationList = new ArrayList<HashMap<String, Comparable>>();
		String currentDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
		List<Invoice> registeredCustomers = new ArrayList<Invoice>();
		registeredCustomers = fetchNotificationValues();
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
	
	/**
	 * This method used for fetch the notification details
	 * @return
	 */
	public List<Invoice> fetchNotificationValues() {
		return (List<Invoice>) invoiceRepository.findAll();
	}
	
	/**
	 * This method used for fetch the notification details
	 * @return
	 */
	public List<Recommendation> fetchRecommendationValues() {
		return (List<Recommendation>) recommendationRepo.findAll();
	}
	
	public ArrayList<HashMap<String, Comparable>> recommendationCheck(){
		String recommendations = "No Recommendations";
		ArrayList<HashMap<String, Comparable>> customerRecommendationList = new ArrayList<HashMap<String, Comparable>>();
		List<Invoice> customers = new ArrayList<Invoice>();
		customers = fetchNotificationValues();
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
