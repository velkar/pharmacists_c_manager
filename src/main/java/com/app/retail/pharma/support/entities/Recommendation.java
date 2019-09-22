package com.app.retail.pharma.support.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcm_recommendation")
public class Recommendation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String medicineName;
    private final String ailmentName;
    private final int stock;
    
    public Recommendation() {
        this.medicineName = "";
        this.ailmentName = "";
        this.stock = 0;
    }
    
    public Recommendation(String medicineName, String ailmentName, int stock) {
        this.medicineName = medicineName;
        this.ailmentName = ailmentName;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }
    
    public String getMedicineName() {
		return medicineName;
	}

	public String getAilmentName() {
		return ailmentName;
	}
	
	public int getStock() {
		return stock;
	}

	@Override
    public String toString() {
        //return "User{" + "id=" + id + ", medicineName=" + medicineName + ", ailmentName=" + ailmentName + '}';
    	return "Recommendation [id=" + id + ", medicineName=" + medicineName  
				+ ", ailmentName =" + ailmentName + ", stock=" + stock + "]"; 
    }

	

}
