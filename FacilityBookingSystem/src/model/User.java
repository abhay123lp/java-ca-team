package model;

import java.io.*;

public class User implements Cloneable, Serializable {
	
	private static final long serialVersionUID=1L;
	
    private String userID;
    private String userName;
    private String userPSW;
    private String role;
    private String contactNo;
    private String emailAddress;

    public User () {
    }

    public User (String userIDIn) {
          this.userID = userIDIn;
    }

    public String getUserID() {
          return this.userID;
    }
    
    public void setUserID(String userIDIn) {
          this.userID = userIDIn;
    }

    public String getUserName() {
          return this.userName;
    }
    
    public void setUserName(String userNameIn) {
          this.userName = userNameIn;
    }

    public String getUserPSW() {
          return this.userPSW;
    }
    
    public void setUserPSW(String userPSWIn) {
          this.userPSW = userPSWIn;
    }

    public String getRole() {
          return this.role;
    }
    
    public void setRole(String roleIn) {
          this.role = roleIn;
    }

    public String getContactNo() {
          return this.contactNo;
    }
    
    public void setContactNo(String contactNoIn) {
          this.contactNo = contactNoIn;
    }

    public String getEmailAddress() {
          return this.emailAddress;
    }
    
    public void setEmailAddress(String emailAddressIn) {
          this.emailAddress = emailAddressIn;
    }

    public void setAll(String userIDIn,
          String userNameIn,
          String userPSWIn,
          String roleIn,
          String contactNoIn,
          String emailAddressIn) {
          this.userID = userIDIn;
          this.userName = userNameIn;
          this.userPSW = userPSWIn;
          this.role = roleIn;
          this.contactNo = contactNoIn;
          this.emailAddress = emailAddressIn;
    }
   
    public boolean hasEqualMapping(User user) {
          if (this.userID == null) {
                    if (user.getUserID() != null)
                           return(false);
          } else if (!this.userID.equals(user.getUserID())) {
                    return(false);
          }
          if (this.userName == null) {
                    if (user.getUserName() != null)
                           return(false);
          } else if (!this.userName.equals(user.getUserName())) {
                    return(false);
          }
          if (this.userPSW == null) {
                    if (user.getUserPSW() != null)
                           return(false);
          } else if (!this.userPSW.equals(user.getUserPSW())) {
                    return(false);
          }
          if (this.role == null) {
                    if (user.getRole() != null)
                           return(false);
          } else if (!this.role.equals(user.getRole())) {
                    return(false);
          }
          if (this.contactNo == null) {
                    if (user.getContactNo() != null)
                           return(false);
          } else if (!this.contactNo.equals(user.getContactNo())) {
                    return(false);
          }
          if (this.emailAddress == null) {
                    if (user.getEmailAddress() != null)
                           return(false);
          } else if (!this.emailAddress.equals(user.getEmailAddress())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nclass User, mapping to table UserTable\n");
        out.append("Persistent attributes: \n"); 
        out.append("userID = " + this.userID + "\n"); 
        out.append("userName = " + this.userName + "\n"); 
        out.append("userPSW = " + this.userPSW + "\n"); 
        out.append("role = " + this.role + "\n"); 
        out.append("contactNo = " + this.contactNo + "\n"); 
        out.append("emailAddress = " + this.emailAddress + "\n"); 
        return out.toString();
    }

    public Object clone() {
        User cloned = new User();
        if (this.userID != null)
             cloned.setUserID(new String(this.userID)); 
        if (this.userName != null)
             cloned.setUserName(new String(this.userName)); 
        if (this.userPSW != null)
             cloned.setUserPSW(new String(this.userPSW)); 
        if (this.role != null)
             cloned.setRole(new String(this.role)); 
        if (this.contactNo != null)
             cloned.setContactNo(new String(this.contactNo)); 
        if (this.emailAddress != null)
             cloned.setEmailAddress(new String(this.emailAddress)); 
        return cloned;
    }

    

}


