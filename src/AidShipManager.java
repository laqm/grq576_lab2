import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AidShipManager {

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
        String pathFile = "./data/aid_ships.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(pathFile))) {
            String line;
            br.readLine(); // read headline
            while ((line = br.readLine()) != null) {
                aidShipList.add(convertLineToAidShip(line));
            }
        }

    }

    public AidShip findAidShip(String registrationNumber){
        for (AidShip ship: aidShipList){
            if (ship.getRegistrationNumber().equals(registrationNumber)){
                return ship;
            }
        }
        return null;
    }

    public boolean isAidShipExists(String registrationNumber){
        if (findAidShip(registrationNumber) != null){
            return false;
        }
        return true;
    }

    public boolean updateAidShip(AidShip ship){
        //TODO
    }

    public boolean deleteAidShip(String registrationNumber){
        //TODO
    }

    public void saveDataToFile(){
        //TODO
    }

    public AidShip convertLineToAidShip(String line){
        String[] variables = line.split(",");

        String name = variables[0];
        String registrationNumber = variables[1];
        double tonnage = Double.parseDouble(variables[2]);
        int crewSize = Integer.parseInt(variables[3]);
        String port = variables[4];
        String aidType = variables[5];
        int aidCapacity = Integer.parseInt(variables[6]);
        boolean hasHelipad = Boolean.parseBoolean(variables[7]);

        AidShip ship = new AidShip(name, registrationNumber, tonnage, crewSize, port, aidType, aidCapacity, hasHelipad);

        return ship;

    }

    public String convertAidShipToLine(AidShip ship){
        //TODO
    }

    @Override
    public String toString() {
        return "AidShipManager{" +
                "aidShips=" + aidShips +
                '}';
    }
}
