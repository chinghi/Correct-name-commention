package VehicleClasses;

import FileIO.FileIOUtil;
import Port.Port;

import java.io.IOException;
import java.util.ArrayList;

public class tankertruck {
    private static tankertruck truck;

    public tankertruck(){

    }
    public tankertruck(String Vid, String name, double fuelCapacity, double carryingCapacity, Port port){
        super(Vid, name, fuelCapacity,carryingCapacity, port);
    }
    public static ArrayList<tankertruck> getTankerTruck() throws IOException {
        return FileIOUtil.ReadTankerFromFile();
    }
    public static tankertruck queryTankerTruckbyId(String Vid) throws IOException {
        tankertruck querytruck = null;
        for (truck: tankertruck.getTankerTruck()) {
            if (tankertruck.getVid().equals(Vid));
            querytruck = truck;
            }
        }
        return querytruck;

    public static void sortbyFuelCapacity(ArrayList<tankertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                tankertruck temp = vehiclelist.get(i);
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
                tankertruck temp = vehiclelist.get(i);
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

    public static void sortbyMaxCapacity(ArrayList<tankertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                tankertruck temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCarryingCapacity() > maxCapac){
                        index = k;
                        maxCapac = vehiclelist.get(k).getCarryingcapacity();
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
                tankertruck temp = vehiclelist.get(i);
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

    public double getCarryingcapacity() {
        return 0;
    }

    public static void sortbyCurrentFuel(ArrayList<tankertruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                tankertruck temp = vehiclelist.get(i);
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
                tankertruck temp = vehiclelist.get(i);
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

    public static String getVid() {
        return null;
    }

    public CharSequence getName() {
        return null;
    }

    public Port getCurrentport() {
        return null;
    }
}
