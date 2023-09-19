package ContainerClass;

import Port.Port;
import FileIO.*;

import java.io.IOException;
import java.util.ArrayList;

public abstract class OpenSide extends Container{
    private double fuelconsumptionperkmonship = 2.7;
    private double fuelconsumptionperkmontruck = 3.2;

    public OpenSide(){

    }
    public OpenSide(String Cid, String name, double weight, Port port){
        super(Cid, name, weight, port);
    }
    public static ArrayList<OpenSide> getOpenSide() throws IOException {
        return FileIOUtil.ReadOpenSideFromFile();
    }

    public static void sortContainerbyWeight(ArrayList<OpenSide> containers, boolean order) {
    }

    @Override
    public double getFuelconsumptionperkmonship() {
        return fuelconsumptionperkmonship;
    }

    @Override
    public double getFuelconsumptionperkmontruck() {
        return fuelconsumptionperkmontruck;
    }

    public void setFuelconsumptionperkmonship(double fuelconsumptionperkmonship) {
        this.fuelconsumptionperkmonship = fuelconsumptionperkmonship;
    }

    public void setFuelconsumptionperkmontruck(double fuelconsumptionperkmontruck) {
        this.fuelconsumptionperkmontruck = fuelconsumptionperkmontruck;
    }

    public static OpenSide queryOpenSideByID(String Cid) throws IOException {
        for (OpenSide container: OpenSide.getOpenSide()  ){
            if (container.getCid().equals(Cid)){
                return container;
            }
        }
        System.out.println("ContainerClass.Container does not exist");
        return null;
    }

    public static void sortContainerbyWeight(ArrayList<OpenSide> containerlist, boolean order){
        if (!order){
            for (int i =0; i < containerlist.size(); i++){
                double maxweight = containerlist.get(i).getWeight();
                int index = i;
                OpenSide temp = containerlist.get(i);
                for (int k = i+1; k < containerlist.size(); k++){
                    if (containerlist.get(k).getWeight() > maxweight){
                        index = k;
                        maxweight = containerlist.get(k).getWeight();
                    }
                }
                containerlist.set(i, containerlist.get(index));
                containerlist.set(index, temp);
            }
        }
        else {
            for (int i =0; i < containerlist.size(); i++){
                double minWeight = containerlist.get(i).getWeight();
                int index = i;
                OpenSide temp = containerlist.get(i);
                for (int k = i+1; k < containerlist.size(); k++){
                    if (containerlist.get(k).getWeight() < minWeight){
                        index = k;
                        minWeight = containerlist.get(k).getWeight();
                    }
                }
                containerlist.set(i, containerlist.get(index));
                containerlist.set(index, temp);
            }
        }

    }
}
