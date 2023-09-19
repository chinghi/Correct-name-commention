package VehicleClasses;

import FileIO.FileIOUtil;
import Port.Port;

import java.io.IOException;
import java.util.ArrayList;

public class basictruck {
    private double carryingCapacity;
    private double currentfuel;

    public basictruck(){

    }
    public basictruck(String Vid, String name, double fuelCapacity, double carryingCapacity, Port port){
        super(Vid, name, fuelCapacity, carryingCapacity, port);
    }
    public static ArrayList<basictruck> getBasicTruck() throws IOException {
        return FileIOUtil.ReadBasicTruckFromFile();
    }
    public static basictruck queryBasicTruckbyId(String Vid) throws IOException {
        basictruck querytruck = null;
        for (basictruck truck: basictruck.getBasicTruck()){
            if (truck.getVid().equals(Vid)){
                querytruck = truck;
            }
        }
        return querytruck;
    }

    public static void sortbyFuelCapacity(ArrayList<basictruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                basictruck temp = vehiclelist.get(i);
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
                basictruck temp = vehiclelist.get(i);
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

    public static void sortbyMaxCapacity(ArrayList<basictruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                basictruck temp = vehiclelist.get(i);
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
                basictruck temp = vehiclelist.get(i);
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

    public static void sortbyCurrentFuel(ArrayList<basictruck> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                basictruck temp = vehiclelist.get(i);
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
                basictruck temp = vehiclelist.get(i);
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


    public double getFuelCapacity() {
        return getFuelCapacity();
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.setFuelCapacity(fuelCapacity);
    }

    public double getCarryingCapacity() {
        return getCarryingCapacity();
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }

    public double getCurrentfuel() {
        return getCurrentfuel();
    }

    public void setCurrentfuel(double currentfuel) {
        this.currentfuel = currentfuel;
    }

    public static String getVid() {
        return getVid();
    }

    public void setVid(Vehicle.Vehicle vid) {
        this.setVid(vid);
    }

    public CharSequence getName() {
        return null;
    }

    public Port getCurrentport() {
        return null;
    }
}
