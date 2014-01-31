/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DataObjects;

/**
 *
 * @author garreola-gutierrez
 */
public class Airfield {
    String name;
    String designator;
    String location;
    String altitude;
    String magneticVariation;
    String runway;
    String position;
    String magneticHeading;
    String positionMaximumLength;
    String positionSlope;
    String positionCenterlineOffset;
    
    public Airfield(){
    }
    @Override
    public String toString(){
        return name;
    }
    
    public Airfield(String name1, String designator1, String location1, String altitude1, 
                    String magneticVariation1, String runway, String magneticHeading1,
                    String position1, String positionMaximumLength1, String positionSlope1, 
                    String positionCenterlineOffset1){
       name = name1;
       designator = designator1; 
       location = location1;
       altitude = altitude1;
       magneticVariation = magneticVariation1;
       magneticHeading = magneticHeading1;
       position = position1;
       positionMaximumLength = positionMaximumLength1;
       positionSlope = positionSlope1;
       positionCenterlineOffset = positionCenterlineOffset1;
              }
   /**
    * This method can change the name and makes the 
    * name part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  name1  the String that is designated to name 
    *                of the Airfield object
    */
    public void setName(String name1){
        name = name1;
    }
    
   /**
    * Returns an Airfield object name to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the name of Airfield object
    */
    public String getName(){
       return name; 
    }
    
   /**
    * This method can change the designator and makes the 
    * designator part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  designator1  the String that is designated 
    *                      to designator of the Airfield object
    */
    public void setDesignator(String designator1){
        designator = designator1;
    }
    
   /**
    * Returns an Airfield object designator to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the designator of Airfield object
    */
    public String getDesignator(){
       return designator; 
    }
    
   /**
    * This method can change the location and makes the 
    * location part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  location1  the String that is designated to location 
    *                    of the Airfield object
    */
    public void setLocation(String location1){
        location = location1;
    }
    
   /**
    * Returns an Airfield object location.to be displayed 
    * This method always returns immediately,only if airfield exists. 
    * @return      the location of Airfield object
    */
    public String getLocation(){
       return location; 
    }
   /**
    * This method can change the altitude and makes the 
    * altitude part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  altitude1  the String that is designated to altitude 
    *                    of the Airfield object
    */
    public void setAltitude(String altitude1){
        altitude = altitude1;
    }
    
   /**
    * Returns an Airfield object altitude to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the altitude of Airfield object
    */
    public String getAltitude(){
       return altitude; 
    }
    
   /**
    * This method can change the magnetic variation and makes the 
    * magnetic variation part of the Airfield object.
    * This method always works, only if airfield already
    * exists.
    *
    * @param  magneticVariation1  the String that is designated to
    *                             magnetic variation of the 
    *                             Airfield object
    */
    public void setMagneticVariation(String magneticVariation1){
        magneticVariation = magneticVariation1;
    }
    
   /**
    * Returns an Airfield object magnetic variation to be displayed. 
    * This method always returns immediately,only if airfield exists. 
    * @return      the magnetic variation of Airfield object
    */
    public String getMagneticVariation(){
       return magneticVariation; 
    }
}
