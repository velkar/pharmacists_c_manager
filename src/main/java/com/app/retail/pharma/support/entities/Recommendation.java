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
    private final String mName;
    private final String aMName;
    private final int stock;
    
    public Recommendation() {
        this.mName = "";
        this.aMName = "";
        this.stock = 0;
    }
    
    public Recommendation(String mName, String aMName, int stock) {
        this.mName = mName;
        this.aMName = aMName;
        this.stock = stock;
    }

    public long getId() {
        return id;
    }
    
    public String getMName() {
        return mName;
    }

    public String getAMName() {
        return aMName;
    }
    
    @Override
    public String toString() {
        //return "User{" + "id=" + id + ", mName=" + mName + ", aMName=" + aMName + '}';
    	return "Recommendation [id=" + id + ", mName=" + mName  
				+ ", aMName =" + aMName + ", stock=" + stock + "]"; 
    }

	

}
