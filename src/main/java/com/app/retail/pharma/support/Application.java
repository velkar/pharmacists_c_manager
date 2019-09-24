package com.app.retail.pharma.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.retail.pharma.support.entities.Invoice;
import com.app.retail.pharma.support.entities.Recommendation;
import com.app.retail.pharma.support.repositories.InvoiceRepository;
import com.app.retail.pharma.support.repositories.RecommendationRepo;


@SpringBootApplication
public class Application {
	
	@Autowired
    InvoiceRepository invoiceRepository;
	
	@Autowired
	RecommendationRepo recommendationRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    CommandLineRunner init() {
    	
    	String[] medicines = ("Crocin,Cetrizine,DOLO-650").split(",");
    	for(String mName: medicines){
    		Recommendation recommendation = new Recommendation(mName, "Fever", 10);
    		recommendationRepo.save(recommendation);
    	}
    	
    	String[] names = ("Sanjay,Venkat,Steve").split(",");
    	for(String name: names){
    		Invoice invoiceInitObj = new Invoice(name, 31,"fever","crocin",111,20,"25-09-2019","25-09-2019",987616741,name.toLowerCase() + "@gmail.com", "DialForSale", "Dialled");
    		invoiceRepository.save(invoiceInitObj);
    	}
    	return null;
    	
		/*return args -> {
            Stream.of("Crocin", "Cetrizine", "DOLO-650").forEach(mName -> {
            	Recommendation recommendation = new Recommendation(mName, "Fever", 10);
            	recommendationRepo.save(recommendation);
            });
            
            Stream.of("Sanjay", "Venkat", "Steve").forEach(name -> {
            	Invoice invoiceInitObj = new Invoice(name, 31,"fever","crocin",111,20,"21-09-2019","21-09-2019",987616741,name.toLowerCase() + "@gmail.com");
            	invoiceRepository.save(invoiceInitObj);
            });
        };*/
    }
    
}