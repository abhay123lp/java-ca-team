package model;

import java.io.*;
import java.sql.*;
import java.util.*;
import java.math.*;

public class Booking implements Cloneable, Serializable {

    private String bookingID;
    private String userID;
    private String facilityID;
    private java.sql.Date starttime;
    private Integer duration;
    private String status;
    private String priority;
    private String reason;

    public Booking () {

    }

    public Booking (String bookingIDIn) {
          this.bookingID = bookingIDIn;
    }

    public String getBookingID() {
          return this.bookingID;
    }
    public void setBookingID(String bookingIDIn) {
          this.bookingID = bookingIDIn;
    }

    public String getUserID() {
          return this.userID;
    }
    public void setUserID(String userIDIn) {
          this.userID = userIDIn;
    }

    public String getFacilityID() {
          return this.facilityID;
    }
    public void setFacilityID(String facilityIDIn) {
          this.facilityID = facilityIDIn;
    }

    public java.sql.Date getStarttime() {
          return this.starttime;
    }
    public void setStarttime(java.sql.Date starttimeIn) {
          this.starttime = starttimeIn;
    }

    public Integer getDuration() {
          return this.duration;
    }
    public void setDuration(Integer durationIn) {
          this.duration = durationIn;
    }

    public String getStatus() {
          return this.status;
    }
    public void setStatus(String statusIn) {
          this.status = statusIn;
    }

    public String getPriority() {
          return this.priority;
    }
    public void setPriority(String priorityIn) {
          this.priority = priorityIn;
    }

    public String getReason() {
          return this.reason;
    }
    public void setReason(String reasonIn) {
          this.reason = reasonIn;
    }

    public void setAll(String bookingIDIn,
          String userIDIn,
          String facilityIDIn,
          java.sql.Date starttimeIn,
          Integer durationIn,
          String statusIn,
          String priorityIn,
          String reasonIn) {
          this.bookingID = bookingIDIn;
          this.userID = userIDIn;
          this.facilityID = facilityIDIn;
          this.starttime = starttimeIn;
          this.duration = durationIn;
          this.status = statusIn;
          this.priority = priorityIn;
          this.reason = reasonIn;
    }

    public boolean hasEqualMapping(Booking valueObject) {

          if (this.bookingID == null) {
                    if (valueObject.getBookingID() != null)
                           return(false);
          } else if (!this.bookingID.equals(valueObject.getBookingID())) {
                    return(false);
          }
          if (this.userID == null) {
                    if (valueObject.getUserID() != null)
                           return(false);
          } else if (!this.userID.equals(valueObject.getUserID())) {
                    return(false);
          }
          if (this.facilityID == null) {
                    if (valueObject.getFacilityID() != null)
                           return(false);
          } else if (!this.facilityID.equals(valueObject.getFacilityID())) {
                    return(false);
          }
          if (this.starttime == null) {
                    if (valueObject.getStarttime() != null)
                           return(false);
          } else if (!this.starttime.equals(valueObject.getStarttime())) {
                    return(false);
          }
          if (this.duration == null) {
                    if (valueObject.getDuration() != null)
                           return(false);
          } else if (!this.duration.equals(valueObject.getDuration())) {
                    return(false);
          }
          if (this.status == null) {
                    if (valueObject.getStatus() != null)
                           return(false);
          } else if (!this.status.equals(valueObject.getStatus())) {
                    return(false);
          }
          if (this.priority == null) {
                    if (valueObject.getPriority() != null)
                           return(false);
          } else if (!this.priority.equals(valueObject.getPriority())) {
                    return(false);
          }
          if (this.reason == null) {
                    if (valueObject.getReason() != null)
                           return(false);
          } else if (!this.reason.equals(valueObject.getReason())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("[ID= " + this.bookingID); 
        out.append("UserID= " + this.userID); 
        out.append("FacilityID= " + this.facilityID); 
        out.append("Starttime= " + this.starttime); 
        out.append("Duration= " + this.duration); 
        out.append("Status= " + this.status); 
        out.append("Priority= " + this.priority); 
        out.append("Reason= " + this.reason); 
        return out.toString();
    }

    public Object clone() {
        Booking cloned = new Booking();

        if (this.bookingID != null)
             cloned.setBookingID(new String(this.bookingID)); 
        if (this.userID != null)
             cloned.setUserID(new String(this.userID)); 
        if (this.facilityID != null)
             cloned.setFacilityID(new String(this.facilityID)); 
        if (this.starttime != null)
             cloned.setStarttime((java.sql.Date)this.starttime.clone()); 
        if (this.duration != null)
             cloned.setDuration(new Integer(this.duration.intValue())); 
        if (this.status != null)
             cloned.setStatus(new String(this.status)); 
        if (this.priority != null)
             cloned.setPriority(new String(this.priority)); 
        if (this.reason != null)
             cloned.setReason(new String(this.reason)); 
        return cloned;
    }

}

