package com.app.retail.pharma.support.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Recommendation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private final String mName;
    private final String aMName;
    
    public Recommendation() {
        this.mName = "";
        this.aMName = "";
    }
    
    public Recommendation(String mName, String aMName) {
        this.mName = mName;
        this.aMName = aMName;
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
        return "User{" + "id=" + id + ", mName=" + mName + ", aMName=" + aMName + '}';
    }

	

}
