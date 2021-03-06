/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 * This Class stores the data about a Runway
 * 
 * @author garreola-gutierrez, matt dargen, dbennett3, Noah Fujioka
 */
public class Runway {
    String id;
    String runwayName;
    float magneticHeading;
    String parent;
    String parentId;
    float altitude;
    String optionalInfo;
    
    public Runway(String runwayName, float magneticHeading, String parent, float altitude, String optional){
       this.runwayName = runwayName;
       this.magneticHeading = magneticHeading;
       this.parent = parent;
       this.altitude = altitude;
       this.optionalInfo = optional;
    }
    
    public String getId(){
        if (id != null){
            return id;
        }
        else{
            id = "";
            return id;
        }
    }
    
    public void setId(String newId){
        id = newId;
    }
    
    public String getName(){
       return runwayName; 
    }
    
    public float getMagneticHeading(){
       return magneticHeading; 
    }
    
    public String getParent() {
        return parent;
    }
    
    public String getParentId(){
        if (parentId != null){
            return parentId;
        }
        else{
            parentId = "";
            return parentId;
        }
    }
    
    public void setParentId(String newParentId){
        parentId = newParentId;
    }    
    
    public float getAltitude() {
        return altitude;
    }
    
    public String getOptionalInfo() {
        return optionalInfo;
    }
    
    public String toString() {
      return runwayName;
    } 
}
