package VehicleClasses;

import FileIO.FileIOUtil;
import Port.Port;

import java.io.IOException;
import java.util.ArrayList;

import static VehicleClasses.basictruck.getVid;

public class reefertruck {
    public reefertruck(){

    }
    public reefertruck(String Vid, String name, double fuelCapacity, double carryingCapacity, Port port){
        super(Vid, name, fuelCapacity,carryingCapacity, port);
    }
    public static ArrayList<reefertruck> getReeferTruck() throws IOException {
        return FileIOUtil.ReadReeferFromFile();
    }
    public static reefertruck queryReeferTruckbyId(String Vid) throws IOException {
        reefertruck querytruck = null;
        for (reefertruck truck: reefertruck.getReeferTruck()){
            if (getVid().equals(Vid)){
                querytruck = truck;
            }
        }
        return querytruck;
    }

    public static void sortbyFuelCapacity(ArrayList<reefertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                reefertruck temp = vehiclelist.get(i);
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
            for (int i =0; i < vehiclelist.size(); i++){int index = i;
                reefertruck temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getFuelCapacity() < index){
                        index = (int) vehiclelist.get(k).getFuelCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }

    }

    public static void sortbyMaxCapacity(ArrayList<reefertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                reefertruck temp = vehiclelist.get(i);
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
                reefertruck temp = vehiclelist.get(i);
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
    }

    public static void sortbyCurrentFuel(ArrayList<reefertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                reefertruck temp = vehiclelist.get(i);
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
                reefertruck temp = vehiclelist.get(i);
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

    public double getFuelCapacity() {
        return 0;
    }

    public Port getCurrentport() {
        return null;
    }

    public CharSequence getName() {
        return null;
    }

    public static String getVid() {
        return null;
    }
}
