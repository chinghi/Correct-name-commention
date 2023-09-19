package VehicleClasses;

import FileIO.FileIOUtil;
import Port.Port;

import java.io.IOException;
import java.util.ArrayList;

public class ship {
    public ship(){

    }
    public ship(String Vid, String name, double fuelCapacity, double carryingCapacity, Port port){
        super(Vid, name, fuelCapacity, carryingCapacity, port);
    }

    public static ArrayList<ship> getShip() throws IOException {
        return FileIOUtil.ReadShipFromFile();
    }
    public static ship queryShipbyId(String Vid) throws IOException {
        ship queryship = null;
        for (ship ship: ship.getShip()){
            if (ship.getVid().equals(Vid)){
                queryship = ship;
            }
        }
        return queryship;
    }

    public Vehicle getVid() {
        return null;
    }

    public static void sortbyFuelCapacity(ArrayList<ship> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getFuelCapacity() > maxfuelcapac){
                        index = k;
                        maxfuelcapac = vehiclelist.get(k).getFuelCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }
        else {
            for (int i =0; i < vehiclelist.size(); i++){
                double minfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getFuelCapacity() < minfuelcapac){
                        index = k;
                        minfuelcapac = vehiclelist.get(k).getFuelCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }

    }

    public double getFuelCapacity() {
        return 0;
    }

    public static void sortbyMaxCapacity(ArrayList<ship> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCarryingCapacity() > maxCapac){
                        index = k;
                        maxCapac = vehiclelist.get(k).getCarryingCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }
        else {
            for (int i =0; i < vehiclelist.size(); i++){
                double minCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCarryingCapacity() < minCapac){
                        index = k;
                        minCapac = vehiclelist.get(k).getCarryingCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }

    }

    public double getCarryingCapacity() {
        return 0;
    };

    public static void sortbyCurrentFuel(ArrayList<ship> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCurrentfuel() > maxCurrentfuel){
                        index = k;
                        maxCurrentfuel = vehiclelist.get(k).getCurrentfuel();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }
        else {
            for (int i =0; i < vehiclelist.size(); i++){
                double minCurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                ship temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCurrentfuel() < minCurrentfuel){
                        index = k;
                        minCurrentfuel = vehiclelist.get(k).getCurrentfuel();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }

    }

    public double getCurrentfuel() {
        return 0;
    }

    public Port getCurrentport() {
        return null;
    }

    public CharSequence getName() {
        return null;
    }
}
