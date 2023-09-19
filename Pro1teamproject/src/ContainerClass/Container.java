package ContainerClass;

import FileIO.FileIOUtil;
import Port.Port;
import Users.Utlity;
import VehicleClasses.Vehicle;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Container implements Serializable {
    @Serial
    private static final long
            serialVersionUID = 6529685098267757690L;
    private String cid;
    private String name;
    private double weight;
    //@JsonBackReference (value = "onsitecontainers")
    private  Port currentport;
    //@JsonBackReference (value = "vehicles")
    private final Vehicle currentVehicle = null;
    private double fuelconsumptionperkmonship;
    private double fuelconsumptionperkmontruck;
    private Vehicle currentvehicle;

    public Container(){

    }

    public Container(String Cid, String name, double weight, Port port){
        this.cid = Cid;
        this.name = name;
        this.weight = weight;
        this.currentport = port;
    }


    public boolean equals(Container container) {
        if (container == this) {
            System.out.println("true");
            return true;
        }

        return this.cid.equals(container.cid) && this.name.equals(container.name);


    }

    public String toString(){
        return "ContainerClass.Container id: " + this.cid + "\n" + "ContainerClass.Container name: " + this.name + "\n" + "Current Port.Port: " + this.currentport.getPid() + "Weight: " + this.weight + "\n" + "Per Km Fuel Consumption on Ship " + this.fuelconsumptionperkmonship + "\n" + "Per Km Fuel Consumption on Truck: " + this.fuelconsumptionperkmontruck + "\n" + "\n";}


    public static boolean createNewContainer(int type, String name, Port port, double weight) throws IOException {
        String Cid = "";
        Random randomid = new Random();
        for (int i =0; i<=10; i++){
            Cid = Cid + randomid.nextInt(10);
        }
        File file = new File("container.json");
        System.out.println(type);

        if (type == 0){
            DryStorage container = new DryStorage("DS" + Cid, name, weight, port);
            FileIOUtil.InputObjectIntoFile(container, "drystorage.json");
            port.setNumberofContainersOnsite(port.getNumberofContainersOnsite() + 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + weight);
            FileIOUtil.updatePortFromFile(port);
        }
        if (type == 1){
            OpenTop container = new OpenTop("OT" + Cid, name, weight, port);
            FileIOUtil.InputObjectIntoFile(container, "opentop.json");
            port.setNumberofContainersOnsite(port.getNumberofContainersOnsite() + 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + weight);
            FileIOUtil.updatePortFromFile(port);
        }
        if (type == 2){
            OpenSide container = new OpenSide("OS" + Cid, name, weight, port );
            FileIOUtil.InputObjectIntoFile(container, "openside.json");
            port.setNumberofContainersOnsite(port.getNumberofContainersOnsite() + 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + weight);
            FileIOUtil.updatePortFromFile(port);
        }
        if (type == 3){
            Refriderated container = new Refriderated("RE" + Cid, name, weight, port);
            FileIOUtil.InputObjectIntoFile(container, "refridgerated.json");
            port.setNumberofContainersOnsite(port.getNumberofContainersOnsite() + 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + weight);
            FileIOUtil.updatePortFromFile(port);
        }
        if (type == 4){
            Liquid container = new Liquid("LI" + Cid, name, weight, port);
            FileIOUtil.InputObjectIntoFile(container, "liquid.json");
            port.setNumberofContainersOnsite(port.getNumberofContainersOnsite() + 1);
            port.setCurrentCapacity(port.getCurrentCapacity() + weight);
            FileIOUtil.updatePortFromFile(port);
        }
        return true;

    }

    public String getName(){
        return this.name;
    }
    public String getCid(){
        return this.cid;
    }

    public Port getCurrentport(){
        return this.currentport;
    }

    public Vehicle getCurrentvehicle() {
        return currentvehicle;
    }

    public void setCurrentvehicle(Vehicle vehicle){
        this.currentvehicle = vehicle;
    }

    public double getWeight(){
        return this.weight;
    }

    public double getFuelConsumptionperkmonship(){
        return this.fuelconsumptionperkmonship;
    }

    public abstract double getFuelconsumptionperkmonship();

    public abstract double getFuelconsumptionperkmonship();

    public double getFuelconsumptionperkmontruck(){
        return this.fuelconsumptionperkmontruck;
    }

    public static ArrayList<Container> getContainer() throws IOException {
        ArrayList<Container> containers = new ArrayList<Container>();
        File DSfile = new File("drystorage.json");
        if (DSfile.exists()){
            for (DryStorage container: FileIOUtil.ReadDryStorageFromFile()){
                containers.add((Container) container);
            }
        }
        File OTfile = new File("opentop.json");
        if (OTfile.exists()){
            for (OpenTop container: FileIOUtil.ReadOpenTopFromFile()){
                containers.add((Container) container);
            }
        }

        File OSfile = new File("openside.json");
        if (OSfile.exists()){
            for (OpenSide container: FileIOUtil.ReadOpenSideFromFile()){
                containers.add((Container) container);
            }
        }

        File REfile = new File("refridgerated.json");
        if (REfile.exists()){
            for (Refriderated container: FileIOUtil.ReadRefridgeratedFromFile()){
                containers.add((Container) container);
            }
        }

        File LIfile = new File("liquid.json");
        if (LIfile.exists()){
            for (Liquid container: FileIOUtil.ReadLiquidFromFile()){
                containers.add((Container) container);
            }
        }





        return containers;
    }

    public static void sortContainerByWeight(ArrayList<Container> containerlist, boolean order){
        if (!order){
            for (int i =0; i < containerlist.size(); i++){
                double maxweight = containerlist.get(i).getWeight();
                int index = i;
                Container temp = containerlist.get(i);
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
                double minfuelcapac = containerlist.get(i).getWeight();
                int index = i;
                for (int k = i+1; k < containerlist.size(); k++){
                    if (containerlist.get(k).getWeight() < minfuelcapac){
                        index = k;
                    }
                }
                containerlist.set(i, containerlist.get(index));
            }
        }
    }



    public static Container queryContainerbyID(String Cid) throws IOException {
        for (Container container: Container.getContainer() ){
            if (container.cid.equals(Cid)){
                return container;
            }
        }
        System.out.println("ContainerClass.Container does not exist");
        return null;
    }

    public void enterPort(Port port) throws IOException {
        this.currentport = port;
        FileIOUtil.updateContainerFromFile(this);

    }

    public void leavePort() throws IOException {
        this.currentport = null;
        FileIOUtil.updateContainerFromFile(this);
    }


    public void loadedonVehicle(Vehicle vehicle) throws IOException {
        this.currentvehicle = vehicle;
        FileIOUtil.updateContainerFromFile(this);
    }

    public void loadedoffVehicle() throws IOException {
        this.currentvehicle = null;
        FileIOUtil.updateContainerFromFile(this);
    }

    public static void filteringContainerbyType() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please select the vehicle type you want to filter:\nds: Dry Storage\not: Open Top\nos: Open Side\nre: Refridgerated\nli: ContainerClass.Liquid\nq: Quit");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")){
                break;
            }
            if (selection.equalsIgnoreCase("ds")){
                ArrayList<DryStorage> containers = DryStorage.getDryStorage();
                Utlity.sortingDSContainer(containers);
                System.out.println(Utlity.DSTable(containers));

            }
            else if (selection.equalsIgnoreCase("ot")){
                ArrayList<OpenTop> containers = OpenTop.getOpenTop();
                Utlity.sortingOTContainer(containers);
                System.out.println(Utlity.OTTable(containers));

            }
            else if (selection.equalsIgnoreCase("os")){
                ArrayList<OpenSide> containers = OpenSide.getOpenSide();
                Utlity.sortingOSContainer(containers);
                System.out.println(Utlity.OSTable(containers));

            }
            else if (selection.equalsIgnoreCase("re")) {
                ArrayList<Refriderated> containers = Refriderated.getRefridgerated();
                Utlity.sortingREContainer(containers);
                System.out.println(Utlity.RETable(containers));


            }
            else if (selection.equalsIgnoreCase("li")) {
                ArrayList<Liquid> containers = Liquid.getLiquid();
                Utlity.sortingLIContainer(containers);
                System.out.println(Utlity.LITable(containers));

            }
            else {
                System.out.println("option is not available. Please choose another option");
            }
        }
    }

    public static void filteringContainerbyPortID(ArrayList<Container> containers) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter port id");
        String Pid = scanner.nextLine();
        Port filterport = Port.queryPortbyID(Pid);
        for (int i =0; i < containers.size(); i++){
            if (!filterport.equals(containers.get(i).getCurrentport())){
                containers.remove(containers.get(i));
            }
        }
        Utlity.sortingContainer(containers);
        System.out.println(containers);
    }

    public abstract double getFuelconsumptionperkmontruck();

    public abstract double getFuelconsumptionpekmontruck();
}



