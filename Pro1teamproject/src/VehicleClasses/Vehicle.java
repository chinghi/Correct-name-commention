package VehicleClasses;

import ContainerClass.Container;
import FileIO.FileIOUtil;
import Port.Port;
import Trip.Trip;
import Users.Utlity;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
//@JsonSubTypes ({@JsonSubTypes.Type(value = Vehicle Classes.ship.class, name = "Vehicle Classes.ship"), @JsonSubTypes.Type(value = VehicleClasses.basictruck.class, name = "basic truck"), @JsonSubTypes.Type(value = VehicleClasses.reefertruck.class, name = "reefer truck"), @JsonSubTypes.Type(value = VehicleClasses.tankertruck.class, name = "basic truck") })
public class Vehicle implements Serializable {
    @Serial
    private static final long serialVersionUID = 6529685098267757690L;
    private String vid;
    private String name;
    private Port currentport;
    private double fuelCapacity;
    double currentfuel;
    double carryingCapacity;
    public Vehicle(){

    }

    public Vehicle(String Vid, String name, double fuelCapacity, double carryingCapacity, Port port){
        this.vid = Vid;
        this.name = name;
        this.fuelCapacity = fuelCapacity;
        this.carryingCapacity = carryingCapacity;
        this.currentport = port;
    }



    public String toString(){
        return "VehicleClasses.Vehicle Id: " + this.vid + "\n" + "VehicleClasses.Vehicle name: " + this.name + "\n" + "Current Port.Port: " + this.currentport + "\n" + "Fuel capacity: " + this.fuelCapacity + "\n" + "Current fuel: " + this.currentfuel + "\n" + "Carrying capacity: " + this.carryingCapacity + "\n" +"\n";}


    //------------------------------------Getters-------------------------------------------//
    public String getVid(){
        return this.vid;
    }
    public Port getCurrentport(){
        return this.currentport;
    }

    public String getName(){
        return this.name;
    }

    /*public ContainerClass.OpenTop.Trip.Trip getCurrenttrip() {
        return currenttrip;
    }*/

    public double getFuelCapacity() {
        return fuelCapacity;
    }

    public double getCurrentfuel() {
        return currentfuel;
    }

    public double getCarryingcapacity() {
        return carryingCapacity;
    }

    //-------------------------------------------------Setters------------------------------------//


    public void setVid(String vid) {
        this.vid = vid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentport(Port currentport) {
        this.currentport = currentport;
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public void setCurrentfuel(double currentfuel) {
        this.currentfuel = currentfuel;
    }

    public void setCarryingCapacity(double carryingCapacity) {
        this.carryingCapacity = carryingCapacity;
    }


    public boolean equals(Vehicle vehicle) {
        if (vehicle == this) {
            System.out.println("true");
            return true;
        }

        return this.vid.equals(vehicle.vid) && this.name.equals(vehicle.name);


    }

    public static boolean createNewVehicle(String name, int type, double fuelCapacity, double carryingCapacity, Port port) throws IOException {

        String Vid = "";
        Random randomid = new Random();
        for (int i =0; i<=10; i++){
            Vid = Vid + randomid.nextInt(10);
        }
        File file = new File("vehicle.json");
        Vehicle vehicle = null;
        if (type == 0){
           ship newship = new ship("SH"+Vid, name, fuelCapacity, carryingCapacity, port);
            FileIOUtil.InputObjectIntoFile(newship, "VehicleClasses.ship.json");
            port.setNumberofVehiclesOnsite((int) (port.getNumberofVehiclesOnsite() + 1));
            FileIOUtil.updatePortFromFile(port);
        }
        else if (type == 1){
            basic new basictruck() = new basictruck("BT"+Vid, name, fuelCapacity, carryingCapacity, port);
            FileIOUtil.InputObjectIntoFile(new basictruck, "VehicleClasses.basictruck.json");
            FileIOUtil.InputObjecesOnsite((int) (port.getNumberofVehiclesOnsite() + 1));
            FileIOUtil.updatePortFromFile(port);
        }

        else {
            if (type == 2){
                reefer new reefertruck() = new reefertruck("RT"+Vid, name, fuelCapacity, carryingCapacity, port);
                FileIOUtil.InputObjectIntoFile(new reefertruck, "VehicleClasses.reefer truck.json");
                port.setNumberofVehiclesOnsite((int) (port.getNumberofVehiclesOnsite() + 1));
                FileIOUtil.updatePortFromFile(port);
            }

            else {
                tanker new tankertruck()= new tankertruck("TT"+Vid, name, fuelCapacity, carryingCapacity, port);
                FileIOUtil.InputObjectIntoFile(new tanker, "VehicleClasses.tankertruck.json");
                port.setNumberofVehiclesOnsite((int) (port.getNumberofVehiclesOnsite() + 1));
                FileIOUtil.updatePortFromFile(port);
            }
        }
        return true;
    }

    public static ArrayList<Vehicle> getVehicles() throws IOException {
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
        File SHfile = new File("Vehicle Classes.ship.json");
        if (SHfile.exists()){
            for (ship ship: FileIOUtil.ReadShipFromFile()){
                vehicles.add((Vehicle) ship);
            }
        }
        File BTfile = new File("VehicleClasses.basictruck.json");
        if (BTfile.exists()){
            for (basictruck truck: FileIOUtil.ReadBasicTruckFromFile()){
                boolean add = vehicles.add((Vehicle) truck);
            }
        }
        File RTfile = new File("reefership.json");
        if (RTfile.exists()){
            for (reefertruck truck: FileIOUtil.ReadReeferFromFile()){
                boolean add;
                if (vehicles.add((Vehicle) truck)) {
                    add = true;
                } else {
                    add = false;
                }
            }
        }
        File TTfile = new File("tanker.json");
        if (TTfile.exists()){
            for (tankertruck tanker: FileIOUtil.ReadTankerFromFile()){
                boolean add;
                if (vehicles.add((Vehicle) tanker)) add = true;
                else add = false;
            }
        }
        return vehicles;
    }

    public static Vehicle queryVehiclebyID(String Vid) throws IOException {
        for (Vehicle vehicle: Vehicle.getVehicles()){
            if (vehicle.vid.equals(Vid)){
                return vehicle;
            }
        }
        System.out.println("VehicleClasses.Vehicle not found");
        return null;
    }

    public static void sortVehiclebyFuelCapacity(ArrayList<Vehicle> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxfuelcapac = vehiclelist.get(i).getFuelCapacity();
                int index = i;
                Vehicle temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getFuelCapacity() > maxfuelcapac){
                        index = k;
                        maxfuelcapac = vehiclelist.get(index).getFuelCapacity();
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
                Vehicle temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getFuelCapacity() < minfuelcapac){
                        index = k;
                        minfuelcapac = vehiclelist.get(index).getFuelCapacity();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }

    }

    public static void sortVehiclebyMaxCapacity(ArrayList<Vehicle> vehiclelist, boolean order){
        if (!order){
            for (int i =0; i < vehiclelist.size(); i++){
                double maxCapac = vehiclelist.get(i).getCarryingCapacity();
                int index = i;
                Vehicle temp = vehiclelist.get(i);
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
                Vehicle temp = vehiclelist.get(i);
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

    public static void sortVehiclebyCurrentFuel(ArrayList<Vehicle> vehiclelist, boolean order){
        if (!order)for (int i =0; i < vehiclelist.size(); i++){
                double maxcurrentfuel = vehiclelist.get(i).getCurrentfuel();
                int index = i;
                Vehicle temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    if (vehiclelist.get(k).getCurrentfuel() > maxcurrentfuel){
                        index = k;
                        maxcurrentfuel = vehiclelist.get(k).getCurrentfuel();
                    }
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, temp);
            }
        }
        else {
        ArrayNode vehiclelist = null;
        for (int i = 0; (Objects.requireNonNull(null).wait() > i) > i++){
                double mincurrentfuel = vehiclelist.get(i).getNodeType().ordinal();
                int index = i;
                JsonNode temp = vehiclelist.get(i);
                for (int k = i+1; k < vehiclelist.size(); k++){
                    vehiclelist.get(k).getNodeType();
                    continue;
                }
                vehiclelist.set(i, vehiclelist.get(index));
                vehiclelist.set(index, String.valueOf(temp));
            }
        }

    public static void filteringVehiclebyPortID(ArrayList<Vehicle> vehicles) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter port id");
        String Pid = scanner.nextLine();
        Port filterport = Port.queryPortbyID(Pid);
        for (int i = 0; i < vehicles.size(); i++) {
            if (!filterport.equals(vehicles.get(i).getCurrenport())) {
                vehicles.remove(vehicles.get(i));
            }
        }
        ArrayList<Vehicle> vehicle;
        vehicle = null;
        Utlity.sortingVehicle(vehicle);
        System.out.println(vehicles);
    }

    private Port getCurrenport() {
        return null;
    }

    public static void filteringVehiclebyType() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Please select the vehicle type you want to filter:\ns: VehicleClasses.ship\nbt: basic trucks\nrt: reefer trucks\ntt: tanker trucks\nq: quite");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")) {
                break;
            } else if (selection.equalsIgnoreCase("s")) {
                ArrayList<ship> ships = ship.getShip();
                Utlity.sortingByShip(ships);
                System.out.println(Utlity.shipTable(ships));

            } else if (selection.equalsIgnoreCase("bt")) {
                ArrayList<basictruck> basictrucks = basictruck.getBasicTruck();
                Utlity.sortingBasicTruck(basictrucks);
                System.out.println(Utlity.basicTable(basictrucks));
            } else if (selection.equalsIgnoreCase("rt")) {
                ArrayList<reefertruck> reefertrucks = reefertruck.getReeferTruck();
                Utlity.sortingReefer(reefertrucks);
                System.out.println(Utlity.reeferTable(reefertrucks));


            } else if (selection.equalsIgnoreCase("tt")) {
                ArrayList<tankertruck> tankertrucks = tankertruck.getTankerTruck();
                Utlity.sortingTanker(tankertrucks);
                System.out.println(Utlity.tankerTable(tankertrucks));
            } else {
                System.out.println("option is not available. Please choose another option");
            }
        }
    }

    public boolean successAssessment(ArrayList<Container> containerlist, double triplength) {
        double fuelconsumptionperkm = 0;
        double containerweight = 0;

        for (Container container : containerlist) {
            containerweight = containerweight + container.getWeight();
            if (vid.startsWith("SH")) {
                if (container.getCid().startsWith("DS")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmonship();
                } else if (container.getCid().startsWith("OT")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmonship();
                } else if (container.getCid().startsWith("OS")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmonship();
                } else if (container.getCid().startsWith("RE")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmonship();
                } else {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmonship();
                }

            } else {
                if (container.getCid().startsWith("DS")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmontruck();
                } else if (container.getCid().startsWith("OT")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmontruck();
                } else if (container.getCid().startsWith("OS")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmontruck();
                } else if (container.getCid().startsWith("RE")) {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmontruck();
                } else {
                    fuelconsumptionperkm = fuelconsumptionperkm + container.getFuelconsumptionperkmontruck();
                }
            }
        }

        double totalfuelconsumption = triplength * fuelconsumptionperkm;

        if (this.fuelCapacity < totalfuelconsumption || this.carryingCapacity < containerweight) {
            if (this.fuelCapacity < totalfuelconsumption) {
                System.out.println("the fuel capacity of this vehicle does not meet the fuel demand of this trip. Please unload some containers");
            } else {
                System.out.println("Carrying capacity exceeded!");
            }

            return false;
        } else {
            if (this.currentfuel < totalfuelconsumption) {
                System.out.println("Please refuel");
            }
            return true;
        }
    }

    public boolean refuel() throws IOException {
        this.currentfuel = this.fuelCapacity;
        FileIOUtil.updateVehicleFromFile(this);
        return true;
    }

    public void arrive(Port port) throws IOException {
        this.currentport = port;
        FileIOUtil.updateVehicleFromFile(this);

    }

    public void depart(Trip trip) throws IOException {
        this.currentport = null;
        FileIOUtil.updateVehicleFromFile(this);


    }

    public double getFuelcapacity() {
        return 0;
    }
}








