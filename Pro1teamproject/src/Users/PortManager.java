package Users;

import ContainerClass.*;
import FileIO.FileIOUtil;
import Port.Port;
import Trip.Trip;
import VehicleClasses.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import static FileIO.FileIOUtil.ReadManagerFromFile;

public class PortManager extends User{
    private Port port;
    public PortManager(){

    }



    public PortManager (String Eid, String username, String password, String role, Port port){
        super(Eid, username, password, role);
        this.port = port;
    }

    public static void addPortManager(String username, String password, Port port) throws IOException {
        String Eid = "";
        Random random = new Random();
        for (int i = 1; i<=10; i++){
            Eid = Eid + random.nextInt(10);
        }
        PortManager newuser = new PortManager(Eid, username, password, "Port Manager", port);
        FileIOUtil.InputObjectIntoFile(newuser, "portmanager.json");
    }

    public String toString(){
        return "username: " + this.getPassword() + "\n" + "port: " + this.port.getName() + "\n" + "Employee ID: " + this.getEid();
    }

    //----------------------------------------Getter-------------------------------------//
    public Port getPort(){
        return this.port;
    }
    //----------------------------------------Setter-------------------------------------//
    public void setPort(Port port) {
        this.port = port;
    }

    public static PortManager queryManagerByID(String Eid) throws IOException {
        for (PortManager manager: ReadManagerFromFile()){
            if (manager.getEid().equals(Eid)){
                return manager;
            }
        }
        System.out.println("EID not found");
        return null;
    }
    public static void filteringManagerByPort(ArrayList<PortManager> filteredlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Port id");
        String Pid = scanner.nextLine();
        Port filterport = Port.queryPortbyID(Pid);
        for (int i =0; i < filteredlist.size(); i++){
            if (!filterport.equals(filteredlist.get(i).getPort())){
                filteredlist.remove(filteredlist.get(i));
            }
        }
    }

    public static PortManager login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter your Eid");
            String Eid = scanner.nextLine();
            PortManager verification = queryManagerbyID(Eid);
            if (verification!= null) {
                String password = scanner.nextLine();
                if (!verification.getPassword().equals(password)){
                    System.out.println("Incorrect Password");
                }
                else{
                    return verification;
                }
            }
        }




    }

    //This method allows Port.Port Manager to view the outgoing trips after/before inputted dates
    public void outgoingTripquery() throws IOException {
        Date after = null;
        Date before = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to filter by date after? (Y-N)");
        if (scanner.nextLine().equals("Y")){
            do {
                System.out.println("Please enter the year");
                int year = scanner.nextInt();
                System.out.println("Please enter the month");
                int month = scanner.nextInt();
                System.out.println("Please enter the date");
                int date = scanner.nextInt();
                after = new Date(year, month, date);
                scanner.nextLine();
            } while (Utlity.yesOrno("Filter After: " + after + ". " + "Would you like to enter again? (Y-N)"));
            System.out.println("Would you like to filter by date before? (Y-N)");
            if (scanner.nextLine().equals("Y")){

            }
            while (true){
                System.out.println("Please enter the year");
                int year = scanner.nextInt();
                System.out.println("Please enter the month");
                int month = scanner.nextInt();
                System.out.println("Please enter the date");
                int date = scanner.nextInt();
                before = new Date(year,month,date);
                scanner.nextLine();
                if (!Utlity.yesOrno("Filter Before " + before + ". " + "Would you like to enter again? (Y-N)" )){
                    break;
                }
            }
            boolean b;
            if (Utlity.viewTrips(Trip.outgoingTripquery(this.port, after, before))) b = true;
            else {
                b = false;
            }


        }

    }
    //This method allows Port.Port Manager to see the incoming trip after/before inputted dates.
    public void incomingTripquery() throws IOException {
        Date after = null;
        Date before = null;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter the year");
            int year = scanner.nextInt();
            System.out.println("Please enter the month");
            int month = scanner.nextInt();
            System.out.println("Please enter the date");
            int date = scanner.nextInt();
            after = new Date(year,month,date);
            scanner.nextLine();
            if (!Utlity.yesOrno("Filter After: " + after + ". " + "Would you like to enter again? (Y-N)" )){
                break;
            }

        }
        System.out.println("Would you like to filter by date before? (Y-N)");
        if (scanner.nextLine().equals("Y")){

        }
        while (true){
            System.out.println("Please enter the year");
            int year = scanner.nextInt();
            System.out.println("Please enter the month");
            int month = scanner.nextInt();
            System.out.println("Please enter the date");
            int date = scanner.nextInt();
            before = new Date(year,month,date);
            scanner.nextLine();
            if (!Utlity.yesOrno("Filter Before " + before + ". " + "Would you like to enter again? (Y-N)" )){
                break;
            }
        }
        boolean b;
        if (Utlity.viewTrips(Trip.incomingTripquery(this.port, after, before))) b = true;
        else b = false;
    }

    //this method is called when the port manager wants to register a new trip. It will call the registeringTrip method from the ContainerClass.OpenTop.Trip.Trip class in its body
    public void RegisteringTrip() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Date dateofdeparture = new Date();
        Date dateofarrival = new Date();
        Port portofarrival = new Port();
        ArrayList<Container> containers = new ArrayList<Container>();
        ArrayList<String> containerId = new ArrayList<String>();
        Vehicle selectedvehicle = null;
        while (true){
            System.out.println("Please input the departure year of the trip");
            int year = scanner.nextInt();
            System.out.println("Please input the departure month of the trip");
            int month = scanner.nextInt();
            System.out.println("Please input the departure day of the trip");
            int date = scanner.nextInt();
            dateofdeparture = new Date(year, month-1, date);
            scanner.nextLine();
            if (!Utlity.yesOrno("Date of departure: " + dateofdeparture + ". " + "Would you like to enter again? (Y-N)" )){
                break;
            }
        }
        while (true){
            System.out.println("Please input the arrival year of the trip");
            int year = scanner.nextInt();
            System.out.println("Please input the arrival month of the trip");
            int month = scanner.nextInt();
            System.out.println("Please input the arrival day of the trip");
            int date = scanner.nextInt();
            dateofarrival = new Date(year, month-1, date);
            scanner.nextLine();
            if (!Utlity.yesOrno("Date of arrival: " + dateofarrival + ". " + "Would you like to enter again? (Y-N)" )){
                break;
            }


        }

        while (true){
            System.out.println("Please enter the Id of the destination port");
            String Pid = scanner.next();
            scanner.nextLine();
            portofarrival = Port.queryPortbyID(Pid);
            if (!Utlity.yesOrno("Please check if the following Port.Port is correct.\n" + portofarrival +"\n" + "Would you like to enter again? (Y-N)" )){
                break;
            }
        }

        while (true){
            containers = new ArrayList<Container>();
            while (true){
                System.out.println("Please select the container you would like to load");
                String Cid = scanner.nextLine();
                Container container = Container.queryContainerbyID(Cid);
                containers.add(container);
                containerid.add(Cid);
                if (!Utlity.yesOrno("Would you like to add more containers? (Y-N)" )){
                    break;
                }
            }
            if (!Utlity.yesOrno("Please check if the following containers are correct.\n" + containers +"\n" + "Would you like to enter again? (Y-N)" )){
                break;
            }
        }

        while (true){
            //Check vehicle availability
            ArrayList<Vehicle> deployablevehicles = new ArrayList<Vehicle>();
            deployablevehicles = Trip.checkingvehicleeligibility(this.port, portofarrival, dateofarrival, dateofdeparture, containers);
            //Choose VehicleClasses.Vehicle
            String prompt = "Please select from the following vehicles ";
            for (int i =0; i <deployablevehicles.size(); i++){
                prompt = prompt + i + ": " + deployablevehicles.get(i).getName() + "\n";
            }
            System.out.println(Utlity.vehicleTable(deployablevehicles));
            System.out.println(prompt);
            int selection = scanner.nextInt();
            selectedvehicle = deployablevehicles.get(selection);
            if (!Utlity.yesOrno("Please check if the following vehicle is correct.\n" + selectedvehicle +"\n" + "Would you like to enter again? (Y-N)" )){
                break;
            }
        }
        Trip.registeringTrip(this.port, dateofdeparture, dateofarrival, portofarrival, containerid, selectedvehicle);
    }
    //This method is called at the commencement of each outgoing trip. It will check the vehicle out of the port.
    public void commenceTrip() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the id of the trip");
        String Tid = scanner.nextLine();
        Trip trip = Trip.queryByName(Tid);
        Port mainport = Port.queryPortbyID(this.port.getPid());
        trip.getVehicle().depart(trip);
        double totalWeight = 0;
        for (String id: trip.getTobedeliveredcontainers()){
            totalWeight = totalWeight + Container.queryContainerbyID(id).getWeight();
        }
        mainport.setNumberofVehiclesOnsite((int) (mainport.getNumberofVehiclesOnsite() - 1));
        mainport.setNumberofContainersOnsite(mainport.getNumberofContainersOnsite() - trip.getTobedeliveredcontainers().size());
        mainport.setCurrentCapacity(mainport.getCurrentCapacity() - totalWeight);
        FileIOUtil.updatePortFromFile(mainport);
    }
    //this method is called after a vehicle reaches its destination port and finishes its trip. It will check the vehicle into the port
    public void completeTrip() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the id of the trip");
        String Tid = scanner.nextLine();
        Trip trip = Trip.queryByName(Tid);
        trip.completeTrip();
        Port mainport = Port.queryPortbyID(this.port.getPid());
        trip.getVehicle().arrive(mainport);
        double totalWeight = 0;
        for (String id: trip.getTobedeliveredcontainers()){
            totalWeight = totalWeight + Container.queryContainerbyID(id).getWeight();
        }
        mainport.setNumberofVehiclesOnsite((int) (mainport.getNumberofVehiclesOnsite() - 1));
        mainport.setNumberofContainersOnsite(mainport.getNumberofContainersOnsite() - trip.getTobedeliveredcontainers().size());
        mainport.setCurrentCapacity(mainport.getCurrentCapacity() - totalWeight);
        FileIOUtil.updatePortFromFile(mainport);
    }
    //this method is called when the port manager wants to load containers off a vehicle
    public void loadingContainersOnVehicle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the id of the trip");
        String tid = scanner.nextLine();
        Trip trip = Trip.queryByName(tid);
        ArrayList<String> containersToBeLoadedOn = trip.getTobedeliveredcontainers();
        for (String containerId: containersToBeLoadedOn){
            if (containerid.startsWith("DS")){
                DryStorage container = DryStorage.queryDryStoragebyID(containerid);
                FileIOUtil.updateContainerFromFile(container);
            }
            else if (containerid.startsWith("OT")){
                OpenTop container = OpenTop.queryOpenTopbyID(containerid);
                container.loadedonVehicle(trip.getVehicle());
            }
            else if (containerid.startsWith("OS")){
                OpenSide container = OpenSide.queryOpenSidebyID(containerid);
                container.loadedonVehicle(trip.getVehicle());
            }
            else if (containerid.startsWith("RE")){
                Refriderated container = Refriderated.queryRefridgeratedbyID(containerid);
                container.loadedonVehicle(trip.getVehicle());
            }
            else {
                Liquid container = Liquid.queryLiquidbyID(containerid);
                container.loadedonVehicle(trip.getVehicle());
            }


        }
    }
    public void loadingContainerOffVehicle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input the id of the trip");
        String tid = scanner.nextLine();
        Trip trip = Trip.queryByName(tid);
        ArrayList<String> containersToBeLoadedOn = trip.getTobedeliveredcontainers();
        for (String containerId: containersToBeLoadedOn){
            if (containerId.startsWith("DS")){
                DryStorage container = DryStorage.queryDryStoragebyID(containerId);
                container.loadedoffVehicle();
            }
            else if (containerId.startsWith("OT")){
                OpenTop container = OpenTop.queryOpenTopbyID(containerId);
                container.loadedoffVehicle();
            }
            else if (containerId.startsWith("OS")){
                OpenSide container = OpenSide.queryOpenSidebyID(containerId);
                container.loadedoffVehicle();
            }
            else if (containerid.startsWith("RE")){
                Refriderated container = Refriderated.queryRefridgeratedbyID(containerId);
                container.loadedoffVehicle();
            }
            else {
                Liquid container = Liquid.queryLiquidbyID(containerId);
                container.loadedoffVehicle();
            }
        }
    }

    public void viewVehicleOnSite() throws IOException {
        ArrayList<Vehicle> vehicles = Vehicle.getVehicles();
        for (int i =0; i< vehicles.size(); i++){
            if (vehicles.get(i).getCurrentport().equals(this.port)){
                vehicles.remove(vehicles.get(i));
            }
        }
        Utlity.viewVehicle(vehicles);

    }

    public void viewContainersOnSite() throws IOException {
        ArrayList<Container> containers = Container.getContainer();
        for (int i = 0; i < containers.size(); i++){
            if (containers.get(i).getCurrentport().equals(this.port)){
                containers.remove(containers.get(i));
            }
        }
        Utlity.viewContainers(containers);
    }
    public boolean removeTrip() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Trip removetrip = new Trip();
        System.out.println("Please enter the id of the container you would like to remover");
        while (true){
            String Tid = scanner.nextLine();
            removetrip = Trip.queryByName(Tid);
            if (removetrip != null){
                break;
            }
            else {
                System.out.println("Please enter another id.");
            }
            FileIOUtil.removeTripFromFile(removetrip);

        }
        return true;
    }

    public boolean updateTrip() throws IOException {
        Trip updatetrip = new Trip();
        Trip updatedtrip;
        updatedtrip = null;
        FileIOUtil.updateTripFromFile(updatedtrip);
        return true;
    }
}
