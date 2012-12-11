package data.dto;

	import java.io.*;
	import java.sql.*;
	import java.util.*;
	import java.math.*;

	public class Usage implements Cloneable, Serializable {

	    private String facName;
	    private Long num;


	    public Usage () {

	    }

	    public Usage (String facNameIn) {

	          this.facName = facNameIn;

	    }

	    public String getFacName() {
	          return this.facName;
	    }
	    public void setFacName(String facNameIn) {
	          this.facName = facNameIn;
	    }

	    public Long getNum() {
	          return this.num;
	    }
	    public void setNum(Long numIn) {
	          this.num = numIn;
	    }



	    
	    public void setAll(String facNameIn,
	            long numIn,
	            String year1In,
	            String month1In) {
	            this.facName = facNameIn;
	            this.num = numIn;
	      }
	    
	    
	    public boolean hasEqualMapping(Usage valueObject) {

	          if (this.facName == null) {
	                    if (valueObject.getFacName() != null)
	                           return(false);
	          } else if (!this.facName.equals(valueObject.getFacName())) {
	                    return(false);
	          }
	          if (valueObject.getNum() != this.num) {
	                    return(false);
	          }

	          return true;
	    }



	    public String toString() {
	        StringBuffer out = new StringBuffer(this.getDaogenVersion());
	        out.append("\nclass Usage, mapping to table booking\n");
	        out.append("Persistent attributes: \n"); 
	        out.append("facName = " + this.facName + "\n"); 
	        out.append("num = " + this.num + "\n"); 
	        return out.toString();
	    }
	    
	    public Object clone() {
	        Usage cloned = new Usage();

	        if (this.facName != null)
	             cloned.setFacName(new String(this.facName)); 
	        cloned.setNum(this.num); 
	        return cloned;
	    }

	    public String getDaogenVersion() {
	        return "DaoGen version 2.4.1";
	    }

	}

