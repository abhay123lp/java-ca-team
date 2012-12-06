package data.dto;

import java.io.*;
 
public class FacilityType implements Cloneable, Serializable {

	public static final long serialVersionUID=1L;
	
    private int typeID;
    private String typeName;
    private String capacity;
    private String desicription;


    public FacilityType () {

    }

    public FacilityType (int typeIDIn) {
          this.typeID = typeIDIn;
    }

    public int getTypeID() {
          return this.typeID;
    }
    
    public void setTypeID(int typeIDIn) {
          this.typeID = typeIDIn;
    }

    public String getTypeName() {
          return this.typeName;
    }
    public void setTypeName(String typeNameIn) {
          this.typeName = typeNameIn;
    }

    public String getCapacity() {
          return this.capacity;
    }
    public void setCapacity(String capacityIn) {
          this.capacity = capacityIn;
    }

    public String getDesicription() {
          return this.desicription;
    }
    public void setDesicription(String desicriptionIn) {
          this.desicription = desicriptionIn;
    }

    public void setAll(int typeIDIn,
          String typeNameIn,
          String capacityIn,
          String desicriptionIn) {
          this.typeID = typeIDIn;
          this.typeName = typeNameIn;
          this.capacity = capacityIn;
          this.desicription = desicriptionIn;
    }


    public boolean hasEqualMapping(FacilityType valueObject) {
          if (valueObject.getTypeID() != this.typeID) {
                    return(false);
          }
          if (this.typeName == null) {
                    if (valueObject.getTypeName() != null)
                           return(false);
          } else if (!this.typeName.equals(valueObject.getTypeName())) {
                    return(false);
          }
          if (this.capacity == null) {
                    if (valueObject.getCapacity() != null)
                           return(false);
          } else if (!this.capacity.equals(valueObject.getCapacity())) {
                    return(false);
          }
          if (this.desicription == null) {
                    if (valueObject.getDesicription() != null)
                           return(false);
          } else if (!this.desicription.equals(valueObject.getDesicription())) {
                    return(false);
          }

          return true;
    }

    public String toString() {
        StringBuffer out = new StringBuffer();
        out.append("\nclass FacilityType, mapping to table javaca\n");
        out.append("Persistent attributes: \n"); 
        out.append("typeID = " + this.typeID + "\n"); 
        out.append("typeName = " + this.typeName + "\n"); 
        out.append("capacity = " + this.capacity + "\n"); 
        out.append("desicription = " + this.desicription + "\n"); 
        return out.toString();
    }

    public Object clone() {
        FacilityType cloned = new FacilityType();

        cloned.setTypeID(this.typeID); 
        if (this.typeName != null)
             cloned.setTypeName(new String(this.typeName)); 
        if (this.capacity != null)
             cloned.setCapacity(new String(this.capacity)); 
        if (this.desicription != null)
             cloned.setDesicription(new String(this.desicription)); 
        return cloned;
    }

}

