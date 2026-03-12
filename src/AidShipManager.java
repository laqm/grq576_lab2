import java.io.*;
import java.util.ArrayList;

public class AidShipManager {

    String filePath = "./data/aid_ships.csv";

    ArrayList<AidShip> aidShipList;

    public ArrayList<AidShip> getAidShipList() {
        return aidShipList;
    }

    public void setAidShipList(ArrayList<AidShip> aidShips) {
        this.aidShipList = aidShips;
    }

    public AidShipManager(){
        aidShipList = new ArrayList<>();
    }

    public void addAidShip(AidShip ship){
        aidShipList.add(ship);
    }

    public void loadAidShips() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // read header
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                aidShipList.add(convertLineToAidShip(line));
            }
        }

    }

    public AidShip findAidShip(String registrationNumber){
        for (AidShip ship: aidShipList){
//            System.out.println(ship.getRegistrationNumber() +"\t"+registrationNumber);
            if (ship.getRegistrationNumber().equals(registrationNumber)){
                return ship;
            }
        }
        return null;
    }

    public boolean isAidShipExists(String registrationNumber){
        if (findAidShip(registrationNumber) != null){
            return true;
        }
        return false;
    }

    public boolean updateAidShip(AidShip ship) throws  IOException{
        AidShip listShip = findAidShip(ship.getRegistrationNumber());

        String header = "name,registrationNumber,tonnage,crewSize,port,aidType,aidCapacity,hasHelipad";
        if (listShip != null){
            listShip.setName(ship.getName());
            listShip.setTonnage(ship.getTonnage());
            listShip.setCrewSize(ship.getCrewSize());
            listShip.setCurrentPort(ship.getCurrentPort());
            listShip.setAidType(ship.getAidType());
            listShip.setSuppliesOnBoard(ship.getSuppliesOnBoard());
            listShip.setHasHelipad(ship.isHasHelipad());
            saveDataToFile();
            return true;
        }
        return false;
        //TODO
    }

    public boolean deleteAidShip(String registrationNumber) throws IOException{
        AidShip ship = findAidShip(registrationNumber);
        if (ship == null){
            return false;
        }else{
            boolean flag = deleteAidShip(ship);
            return flag;
        }
    }

    public boolean deleteAidShip(AidShip aidShip) throws IOException{
        boolean flag = aidShipList.remove(aidShip);
        saveDataToFile();
        return flag;
    }

    public void saveDataToFile() throws IOException{

        String header = "name,registrationNumber,tonnage,crewSize,port,aidType,aidCapacity,hasHelipad";

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))){
            bw.write(header);
            for(AidShip ship: aidShipList){
                bw.write(convertAidShipToLine(ship));
            }
        }

    }

    public AidShip convertLineToAidShip(String line){
        String[] variables = line.split(",");

        String name = variables[0];
        String registrationNumber = variables[1];
        double tonnage = Double.parseDouble(variables[2]);
        int crewSize = Integer.parseInt(variables[3]);
        String port = variables[4];
        String aidType;
        int aidCapacity;
        boolean hasHelipad;
        try{
            aidType = variables[5];
            aidCapacity = Integer.parseInt(variables[6]);
            hasHelipad = Boolean.parseBoolean(variables[7]);
        }catch (Exception e){
            port = variables[4] + "," + variables[5];
            aidType = variables[6];
            aidCapacity = Integer.parseInt(variables[7]);
            hasHelipad = Boolean.parseBoolean(variables[8]);
        }

        AidShip ship = new AidShip(name, registrationNumber, tonnage, crewSize, port, aidType, aidCapacity, hasHelipad);

        return ship;

    }

    public String convertAidShipToLine(AidShip ship){

        String line = ship.getName() + "," +
                      ship.getRegistrationNumber() + "," +
                      ship.getTonnage() + "," +
                      ship.getCrewSize() + "," +
                      ship.getCurrentPort() + "," +
                      ship.getAidType() + "," +
                      ship.getSuppliesOnBoard() + "," +
                      ship.isHasHelipad() + "\n";

        return line;

    }

    @Override
    public String toString() {
        StringBuilder returnString = new StringBuilder("AidShipManager{aidShips=");
        for (AidShip ship: aidShipList){
            returnString.append(ship.toString());
        }
        returnString.append('}');
        return returnString.toString();
    }
}
