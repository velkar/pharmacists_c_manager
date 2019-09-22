package com.app.retail.pharma.support.entities;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="AddInvoice")
public class Invoice implements Serializable {
	
	private static final long serialVersionUID = 8228184427191072705L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final int age;
    private final String ailmentName;
    private final String medicineName;
    private final int intakeCode;
    private final int count;
    private final String consumptionDate;
    private final String expectedCompletionDate;
    private final long contactNumber;
    private final String email;
    
    public Invoice() {
        this.name = "";
        this.age = 0;
        this.medicineName = "";
        this.ailmentName = "";
        this.intakeCode = 0;
        this.count = 0;
        this.consumptionDate = null;
        this.expectedCompletionDate = null;
        this.contactNumber = 0L;
        this.email = "";
    }
    
    public Invoice(String name, int age,String ailmentName,String medicineName,int intakeCode,int count,String consumptionDate,String expectedCompletionDate,long contactNumber, String email) {
        this.name = name;
        this.age = age;
        this.ailmentName = ailmentName;
        this.medicineName = medicineName;
        this.intakeCode = intakeCode;
        this.count = count;
        this.consumptionDate = consumptionDate;
        this.expectedCompletionDate = expectedCompletionDate;
        this.contactNumber = contactNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public int getAge() {
		return age;
	}

	public String getAilmentName() {
		return ailmentName;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public int getIntakeCode() {
		return intakeCode;
	}

	public int getCount() {
		return count;
	}

	public String getConsumptionDate() {
		return consumptionDate;
	}

	public String getExpectedCompletionDate() {
		return expectedCompletionDate;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
        return email;
    }
    
    @Override
    public String toString() {
        //return "User{" + "id=" + id + ", name=" + name + ", email=" + email + '}';
        return "Invoice [id=" + id + ", name=" + name + ", age=" + age+ ", ailmentName=" + ailmentName 
				+ ", medicineName=" + medicineName + ", intakeCode=" + intakeCode+ ", count=" + count 
				+ ", consumptionDate=" + consumptionDate + ", expectedCompletionDate=" + expectedCompletionDate 
				+ ", contactNumber =" + contactNumber + ", email=" + email + "]";
        
    }

}
