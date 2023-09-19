package ContainerClass;

import Port.Port;
import FileIO.*;

import java.io.IOException;
import java.util.ArrayList;

public class Refriderated extends Container{
    private double fuelconsumptionperkmonship = 4.5;
    private double fuelconsumptionperkmontruck = 5.4;

    public Refriderated(){

    }
    public Refriderated(String Cid, String name, double weight, Port port){
        super(Cid, name, weight, port);
    }

    @Override
    public double getFuelconsumptionperkmonship() {
        return 0;
    }

    public static ArrayList<Refriderated> getRefridgerated() throws IOException {
        return FileIOUtil.ReadRefridgeratedFromFile();
    }

    @Override
    public double getFuelconsumptionperkmonship() {
        return fuelconsumptionperkmonship;
    }

    public void setFuelconsumptionperkmonship(double fuelconsumptionperkmonship) {
        this.fuelconsumptionperkmonship = fuelconsumptionperkmonship;
    }

    @Override
    public double getFuelconsumptionperkmontruck() {
        return fuelconsumptionperkmontruck;
    }

    public void setFuelconsumptionperkmontruck(double fuelconsumptionperkmontruck) {
        this.fuelconsumptionperkmontruck = fuelconsumptionperkmontruck;
    }

    public static Refriderated queryRefridgeratedByID(String Cid) throws IOException {
        for (Refriderated container: Refriderated.getRefridgerated()  ){
            if (container.getCid().equals(Cid)){
                return container;
            }
        }
        System.out.println("Container Class.Container does not exist");
        return null;
    }

    public static void sortContainerbyWeight(ArrayList<Refriderated> containerlist, boolean order){
        if (!order){
            for (int i =0; i < containerlist.size(); i++){
                double maxweight = containerlist.get(i).getWeight();
                int index = i;
                Refriderated temp = containerlist.get(i);
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
                Refriderated temp = containerlist.get(i);
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
