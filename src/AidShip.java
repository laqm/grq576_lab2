/**
 * Class for creating an aid ship, extends Ship and implement EmergencySupport
 * @author grq576
 */

public class AidShip extends Ship implements EmergencySupport{

    private String aidType;
    private int suppliesOnBoard;
    private boolean hasHelipad;

    /**
     * Creates an Aid ship without current speed
     * @param name
     * @param registrationNumber
     * @param tonnage
     * @param crewSize
     * @param currentPort
     * @param aidType
     * @param suppliesOnBoard
     * @param hasHelipad
     */
    public AidShip(String name, String registrationNumber, double tonnage, int crewSize, String currentPort, String aidType, int suppliesOnBoard, boolean hasHelipad) {
        super(name, registrationNumber, tonnage, crewSize, currentPort);
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    /**
     * Creates an Aid ship with all variables
     * @param name
     * @param registrationNumber
     * @param tonnage
     * @param crewSize
     * @param currentSpeed
     * @param currentPort
     * @param aidType
     * @param suppliesOnBoard
     * @param hasHelipad
     */
    public AidShip(String name, String registrationNumber, double tonnage, int crewSize, double currentSpeed, String currentPort, String aidType, int suppliesOnBoard, boolean hasHelipad) {
        super(name, registrationNumber, tonnage, crewSize, currentSpeed, currentPort);
        this.aidType = aidType;
        this.suppliesOnBoard = suppliesOnBoard;
        this.hasHelipad = hasHelipad;
    }

    /**
     * @return aidType
     */
    public String getAidType() {
        return aidType;
    }

    /**
     * set aidType
     * @param aidType
     */
    public void setAidType(String aidType) {
        this.aidType = aidType;
    }

    /**
     * @return suppliesOnBoard
     */
    public int getSuppliesOnBoard() {
        return suppliesOnBoard;
    }

    /**
     * set suppliesOnBoard
     * @param suppliesOnBoard
     */
    public void setSuppliesOnBoard(int suppliesOnBoard) {
        this.suppliesOnBoard = suppliesOnBoard;
    }

    /**
     * @return hasHelipad
     */
    public boolean isHasHelipad() {
        return hasHelipad;
    }

    /**
     * sets hasHelipad
     * @param hasHelipad
     */
    public void setHasHelipad(boolean hasHelipad) {
        this.hasHelipad = hasHelipad;
    }

    /**
     * docks ship at port and unloads supplies
     * @param port
     */
    @Override
    public void dock(String port) {
        super.dock(port);
        unloadSupplies();
    }

    /**
     * sets supplies to zero
     */
    private void unloadSupplies(){
        this.suppliesOnBoard = 0;
    }

    /**
     * prints out class to a string
     * @return string
     */
    @Override
    public String toString() {
        return  super.toString() +
                ", aidType=" + aidType +
                ", suppliesOnBoard=" + suppliesOnBoard +
                ", hasHelipad=" + hasHelipad +
                " ]";
    }

    /**
     * Deploys aid, specifically supplies of specified type
     */
    @Override
    public void deployAid() {
        System.out.println("Aid Ship " + getName() + " is deploying " +
                            suppliesOnBoard + " units of " + aidType + " aid.");
        suppliesOnBoard = 0;
    }

    /**
     *  creates and returns EmergencyReadinessReport
     * @return EmergencyReadinessReport
     */
    @Override
    public String getEmergencyReadinessReport() {

        return "Ship Emergency Report:" +
                "\nName: " + getName() +
                "\nAid Type: " + aidType +
                "\nSupplies on Board: " + suppliesOnBoard +
                "\nHelipad: " + (hasHelipad ? "Available" : "Not Available");

    }

}
