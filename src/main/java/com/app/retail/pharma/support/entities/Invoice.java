package com.app.retail.pharma.support.entities;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String name;
    private final int age;
    private final String aMName;
    private final String mName;
    private final int intakeCode;
    private final int count;
    private final Date consumptionDate;
    private final Date expectedCompletionDate;
    private final long contactNumber;
    private final String email;
    
    public Invoice() {
        this.name = "";
        this.age = 0;
        this.aMName = "";
        this.mName = "";
        this.intakeCode = 0;
        this.count = 0;
        this.consumptionDate = null;
        this.expectedCompletionDate = null;
        this.contactNumber = 0L;
        this.email = "";
    }
    
    public Invoice(String name, int age,String aMName,String mName,int intakeCode,int count,Date consumptionDate,Date expectedCompletionDate,long contactNumber, String email) {
        this.name = name;
        this.age = age;
        this.aMName = aMName;
        this.mName = mName;
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

	public String getaMName() {
		return aMName;
	}

	public String getmName() {
		return mName;
	}

	public int getIntakeCode() {
		return intakeCode;
	}

	public int getCount() {
		return count;
	}

	public Date getConsumptionDate() {
		return consumptionDate;
	}

	public Date getExpectedCompletionDate() {
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
        return "Invoice [id=" + id + ", name=" + name + ", age=" + age+ ", aMName=" + aMName 
				+ ", mName=" + mName + ", intakeCode=" + intakeCode+ ", count=" + count 
				+ ", consumptionDate=" + consumptionDate + ", expectedCompletionDate=" + expectedCompletionDate 
				+ ", contactNumber =" + contactNumber + ", email=" + email + "]";
        
    }

}