package ContainerClass;

import Port.Port;
import FileIO.*;

import java.io.IOException;
import java.util.ArrayList;

public class OpenTop extends Container{
    private double fuelconsumptionperkmonship = 2.8;
    private double fuelconsumptionperkmontruck = 3.2;

    public  OpenTop(){

    }
    public OpenTop(String Cid, String name, double weight, Port port){
        super(Cid, name, weight, port);
    }

    @Override
    public double getFuelconsumptionperkmonship() {
        return 0;
    }

    public static ArrayList<OpenTop> getOpenTop() throws IOException {
        return FileIOUtil.ReadOpenTopFromFile();
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

    public static OpenTop queryOpenTopbyID(String Cid) throws IOException {
        for (OpenTop container: OpenTop.getOpenTop()  ){
            if (container.getCid().equals(Cid)){
                return container;
            }
        }
        System.out.println("ContainerClass.Container does not exist");
        return null;
    }

    public static void sortContainerbyWeight(ArrayList<OpenTop> containerlist, boolean order){
        if (!order){
            for (int i =0; i < containerlist.size(); i++){
                double maxweight = containerlist.get(i).getWeight();
                int index = i;
                OpenTop temp = containerlist.get(i);
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
                OpenTop temp = containerlist.get(i);
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
