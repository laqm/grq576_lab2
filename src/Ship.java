/**
 * Class for creating a ship, an abstract class that implement Navigable
 * @author grq576
 */

public abstract class Ship implements Navigable{
    private String name;
    private String registrationNumber;
    private double tonnage;
    private int crewSize;
    private double currentSpeed;
    private String currentPort;

    /**
     * Creates a ship with all variables
     * @param name
     * @param registrationNumber
     * @param tonnage
     * @param crewSize
     * @param currentSpeed
     * @param currentPort
     */
    public Ship(String name, String registrationNumber, double tonnage, int crewSize, double currentSpeed, String currentPort) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.tonnage = tonnage;
        this.crewSize = crewSize;
        this.currentSpeed = currentSpeed;
        this.currentPort = currentPort;
    }

    /**
     * Creates a ship with some variables
     * @param name
     * @param registrationNumber
     * @param tonnage
     * @param crewSize
     * @param currentPort
     */
    public Ship(String name, String registrationNumber, double tonnage, int crewSize, String currentPort) {
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.tonnage = tonnage;
        this.crewSize = crewSize;
        this.currentSpeed = 0.0;
        this.currentPort = currentPort;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * set name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * set registrationNumber
     * @param registrationNumber
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return tonnage
     */
    public double getTonnage() {
        return tonnage;
    }

    /**
     * set tonnage
     * @param tonnage
     */
    public void setTonnage(double tonnage) {
        this.tonnage = tonnage;
    }

    /**
     * @return crewSize
     */
    public int getCrewSize() {
        return crewSize;
    }

    /**
     * set crewSize
     * @param crewSize
     */
    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }

    /**
     * @return currentSpeed
     */
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * set currentSpeed
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * @return currentPort
     */
    public String getCurrentPort() {
        return currentPort;
    }

    /**
     * set currentPort
     * @param currentPort
     */
    public void setCurrentPort(String currentPort) {
        this.currentPort = currentPort;
    }

    /**
     * docks the ship at a specific port
     * @param port
     */
    public void dock(String port) {
        this.currentPort = port;
        this.currentSpeed = 0.0;
    }

    /**
     * moves the ship to a destination
     * @param destination
     */
    @Override
    public void navigateTo(String destination) {
        setCurrentPort(destination);
    }

    /**
     * prints out class to a string
     * @return string
     */
    @Override
    public String toString() {
        return "Ship [ " +
                "name=" + name +
                ", registrationNumber=" + registrationNumber +
                ", tonnage=" + tonnage +
                ", crewSize=" + crewSize +
                ", currentSpeed=" + currentSpeed +
                ", currentPort=" + currentPort;
    }


}
