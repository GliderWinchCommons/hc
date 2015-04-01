/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DatabaseUtilities;

import DataObjects.Pilot;
import DataObjects.Sailplane;
import DataObjects.Airfield;
import DataObjects.Runway;
import DataObjects.GliderPosition;
import DataObjects.Winch;
import DataObjects.DrumParameters;
import DataObjects.Parachute;
import DataObjects.WinchPosition;
import DataObjects.Profile;
import ParameterSelection.Capability;
import ParameterSelection.Preference;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * This class provides the methods that allow a user to add and retrieve Pilots,
 * Sailplanes and Airfields from the database as well as update and delete Pilots
 * 
 * @author Alex Williams, Noah Fujioka, dbennett3
 */
public class DatabaseDataObjectUtilities {
    private static String databaseConnectionName = "jdbc:derby:WinchCommonsTest12DataBase;";
    private static String driverName = "org.apache.derby.jdbc.EmbeddedDriver";
    private static String clientDriverName = "org.apache.derby.jdbc.ClientDriver";

    /**
     * Adds the relevant data for a pilot to the database
     * 
     * @param thePilot the pilot to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addPilotToDB(Pilot thePilot) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement pilotInsertStatement = connect.prepareStatement(
                "INSERT INTO Pilot(pilot_id, first_name, last_name, middle_name, flight_weight, capability, preference,"
                        + " emergency_contact_info, emergency_medical_info, optional_info)"
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            pilotInsertStatement.setString(1, thePilot.getPilotId());
            pilotInsertStatement.setString(2, thePilot.getFirstName());
            pilotInsertStatement.setString(3, thePilot.getLastName());
            pilotInsertStatement.setString(4, thePilot.getMiddleName());
            pilotInsertStatement.setString(5, String.valueOf(thePilot.getWeight()));
            pilotInsertStatement.setString(6, String.valueOf(Capability.convertCapabilityStringToNum(thePilot.getCapability())));
            pilotInsertStatement.setString(7, String.valueOf(Preference.convertPreferenceStringToNum(thePilot.getPreference())));
            pilotInsertStatement.setString(8, thePilot.getEmergencyContact());
            pilotInsertStatement.setString(9, thePilot.getMedInfo());
            pilotInsertStatement.setString(10, thePilot.getOptionalInfo());
            pilotInsertStatement.executeUpdate();
            pilotInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a sailplane to the database
     * 
     * @param theSailplane the sailplane to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addSailplaneToDB(Sailplane theSailplane) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)){
            PreparedStatement sailplaneInsertStatement = connect.prepareStatement(
                    "INSERT INTO Sailplane(sailplane_id, n_number, type, "
                            + "max_gross_weight, empty_weight, indicated_stall_speed, "
                            + "max_winching_speed, max_weak_link_strength, max_tension, "
                            + "cable_release_angle, carry_ballast, multiple_seats, "
                            + "optional_info)"
                            + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            sailplaneInsertStatement.setString(1, theSailplane.getId());
            sailplaneInsertStatement.setString(2, theSailplane.getNumber());
            sailplaneInsertStatement.setString(3, theSailplane.getType());
            sailplaneInsertStatement.setString(4, String.valueOf(theSailplane.getMaxGrossWeight()));
            sailplaneInsertStatement.setString(5, String.valueOf(theSailplane.getEmptyWeight()));
            sailplaneInsertStatement.setString(6, String.valueOf(theSailplane.getIndicatedStallSpeed()));
            sailplaneInsertStatement.setString(7, String.valueOf(theSailplane.getMaxWinchingSpeed()));
            sailplaneInsertStatement.setString(8, String.valueOf(theSailplane.getMaxWeakLinkStrength()));
            sailplaneInsertStatement.setString(9, String.valueOf(theSailplane.getMaxTension()));
            sailplaneInsertStatement.setString(10, String.valueOf(theSailplane.getCableReleaseAngle()));
            sailplaneInsertStatement.setString(11, String.valueOf(theSailplane.storeCarryBallast()));
            sailplaneInsertStatement.setString(12, String.valueOf(theSailplane.storeMultipleSeats()));
            sailplaneInsertStatement.setString(13, theSailplane.getOptionalInfo());
            sailplaneInsertStatement.executeUpdate();
            sailplaneInsertStatement.close();
        }catch(SQLException e) {
            //System.out.println("Error adding sailplane to database");
            throw e;
        }
    }
    
    public static void addWinchToDB(Winch theWinch) throws SQLException, ClassNotFoundException 
    {

    }
    
    /**
     * Adds the relevant data for an airfield to the database
     * 
     * @param theAirfield the airfield to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addAirfieldToDB(Airfield theAirfield) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement AirfieldInsertStatement = connect.prepareStatement(
                "INSERT INTO Airfield(airfield_id, name, designator, altitude, "
                + "magnetic_variation, latitude, longitude, optional_info) "
                + "values (?,?,?,?,?,?,?,?)");
            AirfieldInsertStatement.setString(1, theAirfield.getId());
            AirfieldInsertStatement.setString(2, theAirfield.getName());
            AirfieldInsertStatement.setString(3, theAirfield.getDesignator());
            AirfieldInsertStatement.setString(4, String.valueOf(theAirfield.getAltitude()));
            AirfieldInsertStatement.setString(5, String.valueOf(theAirfield.getMagneticVariation()));
            AirfieldInsertStatement.setString(6, String.valueOf(theAirfield.getLatitude()));
            AirfieldInsertStatement.setString(7, String.valueOf(theAirfield.getLongitude()));
            AirfieldInsertStatement.setString(8, theAirfield.getOptionalInfo());
            AirfieldInsertStatement.executeUpdate();
            AirfieldInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a runway to the database
     * 
     * @param theRunway the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addRunwayToDB(Runway theRunway) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement RunwayInsertStatement = connect.prepareStatement(
                "INSERT INTO Runway(runway_id, runway_name, magnetic_heading, parent, parent_id, altitude, optional_info) "
                        + "values (?,?,?,?,?,?,?)");
            RunwayInsertStatement.setString(1, theRunway.getId());
            RunwayInsertStatement.setString(2, theRunway.getName());
            RunwayInsertStatement.setString(3, theRunway.getMagneticHeading());
            RunwayInsertStatement.setString(4, theRunway.getParent());
            RunwayInsertStatement.setString(5, theRunway.getParentId());
            RunwayInsertStatement.setString(6, String.valueOf(theRunway.getAltitude()));
            RunwayInsertStatement.setString(7, theRunway.getOptionalInfo());
            RunwayInsertStatement.executeUpdate();
            RunwayInsertStatement.close();
        }catch(SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a glider position to the database
     * 
     * @param theGliderPosition the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addGliderPositionToDB(GliderPosition theGliderPosition) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement GliderPositionInsertStatement = connect.prepareStatement(
                "INSERT INTO GliderPosition(glider_position_id, position_id, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info) "
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            GliderPositionInsertStatement.setString(1, theGliderPosition.getId());
            GliderPositionInsertStatement.setString(2, theGliderPosition.getGliderPositionId());
            GliderPositionInsertStatement.setString(3, theGliderPosition.getRunwayParent());
            GliderPositionInsertStatement.setString(4, theGliderPosition.getRunwayParentId());
            GliderPositionInsertStatement.setString(5, theGliderPosition.getAirfieldParent());
            GliderPositionInsertStatement.setString(6, theGliderPosition.getAirfieldParentId());
            GliderPositionInsertStatement.setString(7, String.valueOf(theGliderPosition.getAltitude()));
            GliderPositionInsertStatement.setString(8, String.valueOf(theGliderPosition.getLatitude()));
            GliderPositionInsertStatement.setString(9, String.valueOf(theGliderPosition.getLongitude()));
            GliderPositionInsertStatement.setString(10, theGliderPosition.getOptionalInfo());
            GliderPositionInsertStatement.executeUpdate();
            GliderPositionInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a winch position to the database
     * 
     * @param theWinchPosition the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addWinchPositionToDB(WinchPosition theWinchPosition) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement WinchPositionInsertStatement = connect.prepareStatement(
                "INSERT INTO WinchPosition(winch_position_id, name, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info) "
                        + "values (?,?,?,?,?,?,?,?,?,?)");
            WinchPositionInsertStatement.setString(1, theWinchPosition.getId());
            WinchPositionInsertStatement.setString(2, theWinchPosition.getName());
            WinchPositionInsertStatement.setString(3, theWinchPosition.getRunwayParent());
            WinchPositionInsertStatement.setString(4, theWinchPosition.getRunwayParentId());
            WinchPositionInsertStatement.setString(5, theWinchPosition.getAirfieldParent());
            WinchPositionInsertStatement.setString(6, theWinchPosition.getAirfieldParentId());
            WinchPositionInsertStatement.setString(7, String.valueOf(theWinchPosition.getAltitude()));
            WinchPositionInsertStatement.setString(8, String.valueOf(theWinchPosition.getLatitude()));
            WinchPositionInsertStatement.setString(9, String.valueOf(theWinchPosition.getLongitude()));
            WinchPositionInsertStatement.setString(10, theWinchPosition.getOptionalInfo());
            WinchPositionInsertStatement.executeUpdate();
            WinchPositionInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Adds the relevant data for a parachute to the database
     * 
     * @param theParachute the runway to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addParachuteToDB(Parachute theParachute) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement ParachuteInsertStatement = connect.prepareStatement(
                "INSERT INTO Parachute(parachute_id, lift, drag, weight) "
                        + "values (?,?,?,?)");
            ParachuteInsertStatement.setString(1, String.valueOf(theParachute.getParachuteNumber()));
            ParachuteInsertStatement.setString(2, String.valueOf(theParachute.getLift()));
            ParachuteInsertStatement.setString(3, String.valueOf(theParachute.getDrag()));
            ParachuteInsertStatement.setString(4, String.valueOf(theParachute.getWeight()));
            ParachuteInsertStatement.executeUpdate();
            ParachuteInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    
    /**
     * Adds the relevant data for a profile to the database
     * 
     * @param theProfile the profile to add to the database
     * @throws SQLException if table cannot be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded
     */
    public static void addProfileToDB(Profile theProfile) throws SQLException, ClassNotFoundException {
        //Check for DB drivers
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try (Connection connect = DriverManager.getConnection(databaseConnectionName)) {
            PreparedStatement ProfileInsertStatement = connect.prepareStatement(
                "INSERT INTO Profile(id, unitSettings, displayPrefs)"
                        + "values (?,?,?)");
            ProfileInsertStatement.setString(1, theProfile.getID());
            ProfileInsertStatement.setString(2, theProfile.getUnitSettingsForStorage());
            ProfileInsertStatement.setString(3, theProfile.getDisplayPrefsForStorage());
            ProfileInsertStatement.executeUpdate();
            ProfileInsertStatement.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of pilots (and relevant data) from the database
     * 
     * @return the list of pilots in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Pilot> getPilots() throws SQLException, ClassNotFoundException {        
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet thePilots = stmt.executeQuery("SELECT pilot_id, first_name, last_name, middle_name, flight_weight, capability, "
                    + "preference, emergency_contact_info, emergency_medical_info, optional_info "
                    + "FROM Pilot ORDER BY pilot_id");
            List pilots = new ArrayList<Pilot>();
            
            while(thePilots.next()) {
                String pilotId = thePilots.getString(1);
                String pilotFirstName = thePilots.getString(2);
                String pilotLastName = thePilots.getString(3);
                String pilotMiddleName = thePilots.getString(4);
                
                int weight = 0; 
                int capability = 1;
                int preference = 1;
                try {
                    weight = Integer.parseInt(thePilots.getString(5));
                    capability = Integer.parseInt(thePilots.getString(6));
                    preference = Integer.parseInt(thePilots.getString(7));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                Pilot newPilot = new Pilot(pilotId, pilotFirstName, pilotLastName, pilotMiddleName, weight , 
                        Capability.convertCapabilityNumToString(capability), Preference.convertPreferenceNumToString(preference), 
                        thePilots.getString(8), thePilots.getString(9), thePilots.getString(10));
                pilots.add(newPilot);
            }
            thePilots.close();
            stmt.close();
            connect.close();
            return pilots;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Sailplanes (and relevant data) from the database
     * 
     * @return the list of sailplanes in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Sailplane> getSailplanes() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theSailplanes = stmt.executeQuery("SELECT sailplane_id, n_number, type, "
                    + "max_gross_weight, empty_weight, indicated_stall_speed,"
                    + "max_winching_speed, max_weak_link_strength, max_tension, "
                    + "cable_release_angle, carry_ballast, multiple_seats, "
                    + "optional_info "
                    + "FROM Sailplane ORDER BY n_number");
            List sailplanes = new ArrayList<Sailplane>();
            
            while(theSailplanes.next()) {
                String nNumber = theSailplanes.getString(2);
                String type = theSailplanes.getString(3);
                int maxGrossWeight = 0; 
                int emptyWeight = 0;
                int stallSpeed = 0;
                int maxWinchingSpeed = 0;
                int maxWeakLinkStrength = 0;
                int maxTension = 0;
                int cableAngle = 0;
                try {
                    maxGrossWeight = Integer.parseInt(theSailplanes.getString(4));
                    emptyWeight = Integer.parseInt(theSailplanes.getString(5));
                    stallSpeed = Integer.parseInt(theSailplanes.getString(6));
                    maxWinchingSpeed = Integer.parseInt(theSailplanes.getString(7));
                    maxWeakLinkStrength = Integer.parseInt(theSailplanes.getString(8));
                    maxTension = Integer.parseInt(theSailplanes.getString(9));
                    cableAngle = Integer.parseInt(theSailplanes.getString(10));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                boolean ballast = false;
                boolean multipleSeats = false;
                try{
                    ballast = Sailplane.returnCarryBallast(Integer.parseInt(theSailplanes.getString(11)));
                    multipleSeats = Sailplane.returnMultipleSeats(Integer.parseInt(theSailplanes.getString(12)));
                }catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error reading ballast in reading from DB");
                }
                
                Sailplane newSailplane = new Sailplane(nNumber, type,
                        maxGrossWeight, emptyWeight, stallSpeed, maxWinchingSpeed, 
                        maxWeakLinkStrength, maxTension, cableAngle, ballast, multipleSeats, theSailplanes.getString(12));
                newSailplane.setId(theSailplanes.getString(1));
                sailplanes.add(newSailplane);
                
            }
            theSailplanes.close();
            stmt.close();
            connect.close();
            return sailplanes;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Airfields (and relevant data) from the database
     * 
     * @return the list of airfields in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Airfield> getAirfields() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theAirfields = stmt.executeQuery("SELECT airfield_id, name, designator, altitude, "
                + "magnetic_variation, latitude, longitude, optional_info "
                + "FROM Airfield ORDER BY name");
            List airfields = new ArrayList<Airfield>();
            
            while(theAirfields.next()) {
                String name = theAirfields.getString(2);
                String designator = theAirfields.getString(3);
                
                int altitude = 0;
                int magneticVariation = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Integer.parseInt(theAirfields.getString(4));
                    magneticVariation = Integer.parseInt(theAirfields.getString(5));
                    latitude = Float.parseFloat(theAirfields.getString(6));
                    longitude = Float.parseFloat(theAirfields.getString(7));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theAirfields.getString(8);
                
                Airfield newAirfield = new Airfield(name, designator, altitude, magneticVariation,
                        latitude, longitude, optional);
                newAirfield.setId(theAirfields.getString(1));
                airfields.add(newAirfield);
                
            }
            theAirfields.close();
            stmt.close();
            connect.close();
            return airfields;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Runways (and relevant data) from the database
     * 
     * @return the list of runways in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Runway> getRunways() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theRunways = stmt.executeQuery("SELECT runway_id, runway_name, magnetic_heading, parent, parent_id, altitude, optional_info "
                + "FROM Runway ORDER BY runway_id");
            List runways = new ArrayList<Runway>();
            
            while(theRunways.next()) {
                String name = theRunways.getString(2);
                String magneticHeading = theRunways.getString(3);
                String parent = theRunways.getString(4);
                
                int altitude = 0;
                try {
                    altitude = Integer.parseInt(theRunways.getString(6));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theRunways.getString(7);
                          
                Runway newRunway = new Runway(name, magneticHeading, parent, altitude, optional);
                newRunway.setId(theRunways.getString(1));
                newRunway.setParentId(theRunways.getString(5));
                runways.add(newRunway);
                
            }
            theRunways.close();
            stmt.close();
            connect.close();
            return runways;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Glider positions (and relevant data) from the database
     * 
     * @return the list of glider positions in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<GliderPosition> getGliderPositions() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theGliderPositions = stmt.executeQuery("SELECT glider_position_id, position_id, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info "
                + "FROM GliderPosition ORDER BY position_id");
            List positions = new ArrayList<GliderPosition>();
            
            while(theGliderPositions.next()) {
                String id = theGliderPositions.getString(2);
                String runwayParent = theGliderPositions.getString(3);
                String airfieldParent = theGliderPositions.getString(5);
                
                int altitude = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Integer.parseInt(theGliderPositions.getString(7));
                    latitude = Float.parseFloat(theGliderPositions.getString(8));
                    longitude = Float.parseFloat(theGliderPositions.getString(9));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theGliderPositions.getString(10);
                          
                GliderPosition newGliderPosition = new GliderPosition(id, runwayParent, airfieldParent, altitude, latitude, longitude, optional);
                newGliderPosition.setId(theGliderPositions.getString(1));
                newGliderPosition.setRunwayParentId(theGliderPositions.getString(4));
                newGliderPosition.setAirfieldParentId(theGliderPositions.getString(6));
                positions.add(newGliderPosition);
                
            }
            theGliderPositions.close();
            stmt.close();
            connect.close();
            return positions;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Winch positions (and relevant data) from the database
     * 
     * @return the list of winch positions in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<WinchPosition> getWinchPositions() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theWinchPositions = stmt.executeQuery("SELECT glider_position_id, name, runway_parent, runway_parent_id, airfield_parent, airfield_parent_id, altitude, latitude, longitude, optional_info "
                + "FROM WinchPosition ORDER BY name");
            List positions = new ArrayList<WinchPosition>();
            
            while(theWinchPositions.next()) {
                String name = theWinchPositions.getString(2);
                String runwayParent = theWinchPositions.getString(3);
                String airfieldParent = theWinchPositions.getString(5);
                
                int altitude = 0;
                float latitude = 0;
                float longitude = 0;
                try {
                    altitude = Integer.parseInt(theWinchPositions.getString(7));
                    latitude = Float.parseFloat(theWinchPositions.getString(8));
                    longitude = Float.parseFloat(theWinchPositions.getString(9));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
                
                String optional = theWinchPositions.getString(7);
                          
                WinchPosition newWinchPosition = new WinchPosition(name, runwayParent, airfieldParent, altitude, latitude, longitude, optional);
                newWinchPosition.setId(theWinchPositions.getString(1));
                newWinchPosition.setRunwayParentId(theWinchPositions.getString(4));
                newWinchPosition.setAirfieldParentId(theWinchPositions.getString(6));
                positions.add(newWinchPosition);
                
            }
            theWinchPositions.close();
            stmt.close();
            connect.close();
            return positions;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Parachutes (and relevant data) from the database
     * 
     * @return the list of parachutes in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    public static List<Parachute> getParachutes() throws SQLException, ClassNotFoundException {        
        try{
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theParachutes = stmt.executeQuery("SELECT parachute_id, lift, drag, weight "
                + "FROM Parachute ORDER BY parachute_id");
            List parachutes = new ArrayList<Parachute>();
            
            while(theParachutes.next()) {
                
                int id = 0;
                
                float lift = 0;
                float drag = 0;
                int weight = 0;
                try {
                    id = Integer.parseInt(theParachutes.getString(1));
                    lift = Float.parseFloat(theParachutes.getString(2));
                    drag = Float.parseFloat(theParachutes.getString(3));
                    weight = Integer.parseInt(theParachutes.getString(4));
                }catch(NumberFormatException e) {
                    //TODO What happens when the Database sends back invalid data
                    JOptionPane.showMessageDialog(null, "Number Format Exception in reading from DB");
                }
               
                Parachute newParachute = new Parachute(id, lift, drag, weight);
                        
                parachutes.add(newParachute);
                
            }
            theParachutes.close();
            stmt.close();
            connect.close();
            return parachutes;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    /**
     * Pulls the list of Profiles (and relevant data) from the database
     * 
     * @return the list of profiles in the database
     * @throws SQLException if the table in the database can't be accessed
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     */
    
    public static List<Profile> getProfiles() throws SQLException, ClassNotFoundException {        
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theProfiles = stmt.executeQuery("SELECT id, unitSettings,  "
                    + "displayPrefs "
                    + "FROM Profile ORDER BY id");
            List profiles = new ArrayList<Profile>();
            
            while(theProfiles.next()) {
                String profileName = theProfiles.getString(1);
                String[] names = profileName.split("\\s+"); 
                String unitSettings = theProfiles.getString(2);
                String displayPrefs = theProfiles.getString(3);
                Profile newProfile = new Profile(profileName, unitSettings, displayPrefs);
                profiles.add(newProfile);
            }
            theProfiles.close();
            stmt.close();
            connect.close();
            return profiles;
        } catch (SQLException e) {
            throw e;
        }
    }    
    
    public static List<String> getTables() throws SQLException, ClassNotFoundException {        
        try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            Statement stmt = connect.createStatement();
            ResultSet theTables = stmt.executeQuery("SELECT * FROM SYS.SYSTABLES");
            List tables = new ArrayList<String>();
            while(theTables.next()) {
                
                //CHECKS TO SEE IF IT IS A SYSTEM TABLE OR A UNITS TABLE, WHICH WILL BE EXCLUDED
                if(!theTables.getString(2).contains("SYS") && !theTables.getString(2).contains("UNITS"))
                    tables.add(theTables.getString(2));
            }
            
            return tables;
            
        }catch(Exception e) {
            throw e;
        }
    }
    
    /**
     * Update the data for a given pilot in the database
     * 
     * @param pilot the pilot to update the data for
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     * @throws SQLException if the table in the database can't be accessed
     */
    public static void updatePilotEntry(Pilot pilot) throws ClassNotFoundException, SQLException {
         try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            PreparedStatement pilotEditStatement= connect.prepareStatement("UPDATE Pilot "
                                        + "SET weight = ?, "
                                        + " capability = ?, "
                                        + " preference = ?,"
                                        + " emergency_contact_info = ?, "
                                        + " emergency_medical_info = ? "
                                        + "WHERE firstName = ? "
                                        + "AND WHERE lastName = ?");
            pilotEditStatement.setString(1, String.valueOf(pilot.getWeight()));
            pilotEditStatement.setString(2, String.valueOf(Capability.convertCapabilityStringToNum(pilot.getCapability())));
            pilotEditStatement.setString(3, String.valueOf(Preference.convertPreferenceStringToNum(pilot.getPreference())));
            pilotEditStatement.setString(4, pilot.getEmergencyContact());
            pilotEditStatement.setString(5, pilot.getMedInfo());
            pilotEditStatement.setString(6, pilot.getFirstName());
            pilotEditStatement.setString(7, pilot.getLastName());
            pilotEditStatement.executeUpdate();
            pilotEditStatement.close();
            connect.close();
        }catch(SQLException e) {
            throw e;
        }
    }
    
    /**
     * Delete the data for a given pilot from the database
     * 
     * @param pilot the pilot to delete from the database
     * @throws ClassNotFoundException If Apache Derby drivers can't be loaded 
     * @throws SQLException if the table in the database can't be accessed
     */
    public static void deletePilot(Pilot pilot) throws ClassNotFoundException {
       try{
            //Class derbyClass = RMIClassLoader.loadClass("lib/", "derby.jar");
            Class.forName(driverName);
            Class.forName(clientDriverName);
        }catch(java.lang.ClassNotFoundException e) {
            throw e;
        }
        
        try {
            Connection connect = DriverManager.getConnection(databaseConnectionName);
            PreparedStatement pilotEditStatement= connect.prepareStatement("DELETE FROM Pilot "
                    + "WHERE firstName = ? "
                    + "AND WHERE lastName = ?");   
            pilotEditStatement.setString(1, pilot.getFirstName());
            pilotEditStatement.setString(2, pilot.getLastName());
            pilotEditStatement.executeUpdate();
            pilotEditStatement.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    /**
     * Check to see that Pilot table exists
     * 
     * @param dbConnection the connection to the database
     * @return true if Pilot table exists
     * @return false if Pilot table doesn't exist
     * @throws SQLException 
     */
    public static boolean checkForTable(Connection dbConnection) throws SQLException {
        try {
            Statement s = dbConnection.createStatement();
            s.execute("UPDATE Pilot SET firstName = 'A Name', Weight = '000', capability='1', preference='1', emergency_contact_info='None', emergency_medical_info = 'None' where 1=3"); 
        }catch(SQLException sqle) {
            String theError = (sqle).getSQLState();
            if (theError.equals("42X05"))
                return false;
            else if(theError.equals("42X14") || theError.equals("42821")){
                //TODO find a good way to camcle and rerun init program
                throw sqle;
            }
            else
                throw sqle;
        }
        return true;            
    }

    public static List<GliderPosition> getPositions() {
        List positions = new ArrayList<GliderPosition>();
        return positions;
    }
}
