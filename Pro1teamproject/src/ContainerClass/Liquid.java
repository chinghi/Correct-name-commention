package ContainerClass;

import Port.Port;
import FileIO.*;
import java.io.IOException;
import java.util.ArrayList;

public abstract class Liquid extends Container{
    public Liquid(){

    }
    private double fuelconsumptionperkmonship = 4.8;
    private double fuelconsumptionperkmontruck = 5.3;
    public Liquid(String Cid, String name, double weight, Port port){
        super(Cid, name, weight, port);
    }
    public static ArrayList<Liquid> getLiquid() throws IOException {
        return FileIOUtil.ReadLiquidFromFile();
    }
    public static Liquid queryLiquidByID(String Cid) throws IOException {
        for (Liquid container: Liquid.getLiquid()  ){
            if (container.getCid().equals(Cid)){
                return container;
            }
        }
        System.out.println("Container_Class.Container does not exist");
        return null;
    }

    public static void sortContainerbyWeight(ArrayList<Liquid> containers, boolean order) {

    }

    @Override
    public double getFuelconsumptionperkmonship() {
        return fuelconsumptionperkmonship;
    }

    public void setFuelconsumptionperkmonship(double fuelconsumptionperkmonship) {
        this.fuelconsumptionperkmonship = fuelconsumptionperkmonship;
    }

    @Override
    public double getFuelconsumptionpekmontruck() {
        return fuelconsumptionperkmontruck;
    }

    public void setFuelconsumptionperkmontruck(double fuelconsumptionperkmontruck) {
        this.fuelconsumptionperkmontruck = fuelconsumptionperkmontruck;
    }

    public static void sortContainerbyWeight(ArrayList<Liquid> containerlist, boolean order){
        if (!order){
            for (int i =0; i < containerlist.size(); i++){
                double maxweight = containerlist.get(i).getWeight();
                int index = i;
                Liquid temp = containerlist.get(i);
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
                Liquid temp = containerlist.get(i);
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
