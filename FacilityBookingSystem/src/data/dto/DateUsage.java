package data.dto;

	import java.io.*;
	import java.sql.*;
	import java.util.*;
	import java.math.*;

	public class DateUsage implements Cloneable, Serializable {

		private String tyear;
	    private String tmonth;



	    public DateUsage () {

	    }

	    public DateUsage (String tyearIn) {

	          this.tyear = tyearIn;

	    }


	    public String getTyear() {
	          return this.tyear;
	    }
	    public void setTyear(String tyearIn) {
	          this.tyear = tyearIn;
	    }

	    public String getTmonth() {
	          return this.tmonth;
	    }
	    public void setTmonth(String tmonthIn) {
	          this.tmonth = tmonthIn;
	    }





	    public void setAll(String tyearIn,
	            String tmonthIn) {
	            this.tyear = tyearIn;
	            this.tmonth = tmonthIn;
	      }


	    public boolean hasEqualMapping(DateUsage valueObject) {

	          if (valueObject.getTyear() != this.tyear) {
	                    return(false);
	          }
	          if (this.tmonth == null) {
	                    if (valueObject.getTmonth() != null)
	                           return(false);
	          } else if (!this.tmonth.equals(valueObject.getTmonth())) {
	                    return(false);
	          }

	          return true;
	    }



	    public String toString() {
	        StringBuffer out = new StringBuffer(this.getDaogenVersion());
	        out.append("\nclass DateUsage, mapping to table booking\n");
	        out.append("Persistent attributes: \n"); 
	        out.append("tyear = " + this.tyear + "\n"); 
	        out.append("tmonth = " + this.tmonth + "\n"); 
	        return out.toString();
	    }


	    public Object clone() {
	        DateUsage cloned = new DateUsage();

	        cloned.setTyear(this.tyear); 
	        if (this.tmonth != null)
	             cloned.setTmonth(new String(this.tmonth)); 
	        return cloned;
	    }



	    public String getDaogenVersion() {
	        return "DaoGen version 2.4.1";
	    }
	}

