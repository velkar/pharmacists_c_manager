package com.app.retail.pharma.support.service;

import java.util.List;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.repositories.InvoiceRepository;

/*
 * 
 *  
 */
public class PharmacySupportService {

	private final InvoiceRepository invoiceRepository;

	/**
	 * 
	 * @param invoiceRepository
	 */
	public PharmacySupportService(InvoiceRepository invoiceRepository) {
		this.invoiceRepository = invoiceRepository;
	}

	/**
	 * This method is used for user authentication 
	 * 
	 * @return
	 */

	public List<Invoice> authentication() {

		return (List<Invoice>) invoiceRepository.findAll();
	}

	/**
	 * This method used for add all notification
	 * @param invoice
	 */
	public void addNotificationValues(Invoice invoice) {

		invoiceRepository.save(invoice);
	}

	/**
	 * This method used for fetch the recommandation detailds
	 * @return
	 */
	public List<Invoice> fetchRecommandationValues() {

		return (List<Invoice>) invoiceRepository.findAll();
	}

	/**
	 * 
	 * @return
	 */
	public List<Invoice> fetNotificationValues() {

		return (List<Invoice>) invoiceRepository.findAll();
	}

	/**
	 * This method used for updateNoticeValues
	 * @param invoice
	 */
	public void updateNoticeValues(Invoice invoice) {

		invoiceRepository.save(invoice);
	}

	/*
	 * public void updateRecommandationValues(Recommendation recommandation) {
	 * invoiceRepository.save(recommandation); }
	 */
}
