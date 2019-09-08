package com.app.retail.pharma.support.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.retail.pharma.support.entities.Invoice;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long>{}
