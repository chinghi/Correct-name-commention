package Users;

import ContainerClass.Container;
import FileIO.FileIOUtil;
import Port.Port;
import VehicleClasses.Vehicle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SystemAdmin extends User{
    public SystemAdmin(){

    }
    public SystemAdmin(String Eid, String username, String password, String role){
        super(Eid,username, password, role);
    }
    public static SystemAdmin queryAdminbyID(String Eid) throws IOException {
        for (SystemAdmin admin: FileIOUtil.ReadAdminFromFile()){
            if (admin.getEid().equals(Eid)){
                return admin;
            }
        }
        System.out.println("EID not found");
        return null;
    }

    public static SystemAdmin login() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Please enter your Eid");
            String Eid = scanner.nextLine();
            SystemAdmin verification = queryAdminbyID(Eid);
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

    //-----------------------------------------------CREATE METHODS----------------------------------------------------//
    public static void addSystemAdmin() throws IOException {
        String username;
        String password;
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input your username here: ");
            username = scanner.nextLine();
            if (!Utlity.yesOrno("Username: " + username + "." + "Would you like to input again? (Y or N)" )){
                break;
            }
        }

        while (true){
            System.out.println("Please input your password here: ");
            password = scanner.nextLine();
            if (!Utlity.yesOrno("Password: " + password + "." + "Would you like to input again? (Y or N)" )){
                break;
            }
        }

        String Eid = "";
        Random random = new Random();
        for (int i = 1; i<=10; i++){
            Eid = Eid + random.nextInt(10);
        }

        SystemAdmin newuser = new SystemAdmin(Eid, username, password, "Admin");
        FileIOUtil.InputObjectIntoFile(newuser, "systemadmin.json");

    }

    public static void addManager() throws IOException {
        String username;
        String password;
        Port port = new Port();
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Please input your username here: ");
            username = scanner.nextLine();
            if (!Utlity.yesOrno("Username: " + username + "." + "Would you like to input again? (Y or N)" )){
                break;
            }
        }

        while (true){
            System.out.println("Please input your password here: ");
            password = scanner.nextLine();
            if (!Utlity.yesOrno("Password: " + password + "." + "Would you like to input again? (Y or N)" )){
                break;
            }
        }

        while (true){
            String prompt = "Please assign the new manager to a port: ";
            for (int i = 0; i < FileIOUtil.ReadPortFromFile().size(); i++){
                prompt = prompt + i +": "+ (FileIOUtil.ReadPortFromFile().get(i)).getName() + " ";
            }
            System.out.println(prompt);
            int selection = scanner.nextInt();
            scanner.nextLine();
            port = FileIOUtil.ReadPortFromFile().get(selection);
            if (!Utlity.yesOrno("Please check port detail:\n" + password + "\n" + "Would you like to choose another port? (Y or N)" )){
                break;
            }

        }
        PortManager.addPortManager(username, password, port);
    }
    public static Port addPort() throws IOException {
        String name = "";
        double latitude = 0;
        double longtitude = 0;
        double storingcapacity = 0;
        boolean landingability = false;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Please input the name of the new port: ");
            name = scanner.nextLine();
            if (!Utlity.yesOrno("Port.Port name: " + name + ". " + "Would you like to enter again? (Y or N)")) {
                break;
            }
        }

        while (true) {
            String hemisphere = "";
            double degree = 0;
            double minute = 0;
            double second = 0;
            while (true) {
                System.out.println("Please input the port latitude (N or S)");
                System.out.println("Please Choose Hemisphere");
                hemisphere = scanner.nextLine();
                System.out.println("Please input degree (maximum 180)");
                degree = scanner.nextDouble();
                System.out.println("Please input minute");
                minute = scanner.nextDouble();
                System.out.println("Please input second");
                second = scanner.nextDouble();
                scanner.nextLine();
                double totaldegree = (double) Math.round((degree + minute / 60 + second / 3600) * 100) / 100;
                if (totaldegree <= 180) {
                    if (hemisphere.equals("N")) {
                        latitude = totaldegree;
                    } else {
                        latitude = -totaldegree;
                    }
                    break;
                } else {
                    System.out.println("Incorrect latitude. Please enter again");
                }
            }
            if (!Utlity.yesOrno("Port.Port latitude: " + degree + " degree " + minute + " minutes " + second + " seconds " + hemisphere + ". " + "Would you like to enter again? (Y-N)")) {
                break;
            }
        }

        while (true) {
            String hemisphere = "";
            double degree = 0;
            double minute = 0;
            double second = 0;
            while (true) {
                System.out.println("Please input the port longtitude");
                System.out.println("Please Choose Hemisphere (W or E)");
                hemisphere = scanner.nextLine();
                System.out.println("Please input degree (maximum 180)");
                degree = scanner.nextDouble();
                System.out.println("Please input minute");
                minute = scanner.nextDouble();
                System.out.println("Please input second");
                second = scanner.nextDouble();
                scanner.nextLine();
                double totaldegree = (double) Math.round((degree + minute / 60 + second / 3600) * 100) / 100;
                if (totaldegree <= 180) {
                    if (hemisphere.equals("E")) {
                        longtitude = totaldegree;
                    } else {
                        longtitude = -totaldegree;
                    }
                    break;
                } else {
                    System.out.println("Incorrect latitude. Please enter again");
                }
            }
            if (!Utlity.yesOrno("Port.Port longtitude: " + degree + " degree " + minute + " minutes " + second + " seconds" + hemisphere + ". " + "Would you like to enter again? (Y or N)")) {
                break;
            }
        }

        double storingCapacity;
        while (true) {
            System.out.println("PLease input its storing capacity");
            storingCapacity = scanner.nextDouble();
            scanner.nextLine();
            if (!Utlity.yesOrno("Port.Port storing capacity: " + storingCapacity + ". " + "Would you like to enter again? (Y or N)")) {
                break;
            }
        }

        boolean landingAbility;
        while (true) {
            System.out.println("Please input its landing ability");
            landingAbility = scanner.nextBoolean();
            scanner.nextLine();
            if (!Utlity.yesOrno("Port.Port landing ability: " + landingAbility + ". " + "Would you like to enter again? (Y or N)")) {
                break;
            }
        }

        return Port.createNewPort(name, latitude, longtitude, storingCapacity, landingAbility);
    }
    public static boolean addVehicle() throws IOException {
        String name ="";
        int type = 0;
        double fuelCapacity = 0;
        double carryingCapacity = 0;
        Port port = new Port();
        Scanner scanner = new Scanner(System.in);
        String vehicletype = "";
        while (true){
            System.out.println("Please input the name of the vehicle");
            name = scanner.nextLine();
            if (!Utlity.yesOrno("VehicleClasses.Vehicle name: " + name + ". " + "Would you like to enter again? (Y or N)")){
                break;
            }

        }
        while (true){
            System.out.println("Choose 0 for VehicleClasses.ship, 1 for basic truck, 2 for reefer truck, 3 for tanker truck");
            type = scanner.nextInt();
            if (type == 0){
                vehicletype = "VehicleClasses.ship";
            }
            else if (type == 1){
                vehicletype = "basic truck";
            }
            else if (type == 2){
                vehicletype= "reefer truck";
            }
            else {
                vehicletype = "tanker truck";
            }
            scanner.nextLine();
            if (!Utlity.yesOrno("VehicleClasses.Vehicle type: " + vehicletype + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }
        }

        while (true){
            System.out.println("Please input the fuel capacity of the vehicle");
            fuelCapacity = scanner.nextDouble();
            scanner.nextLine();
            if (!Utlity.yesOrno("Fuel capacity: " + fuelCapacity + ". " + "Would you like to enter again? (Y or N)")){
                break;
            }

        }

        while (true){
            System.out.println("Please input the carrying capacity of the vehicle");
            carryingCapacity = scanner.nextDouble();
            scanner.nextLine();
            if (!Utlity.yesOrno("Carrying capacity: " + carryingCapacity + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }

        }
        while (true){
            while (true){
                System.out.println("Please input the ID of the port you would like to assign this vehicle to");
                String Pid = scanner.next();
                scanner.nextLine();
                port = Port.queryPortbyID(Pid);
                if (!port.isLandingAbility() && type!=0){
                    System.out.println("Trucks cannot be assigned to this port. Please select another port");
                }
                else {
                    break;
                }
            }
            if (!Utlity.yesOrno("Please check if the following port is correct\n" +port + "\n" + "Would you like to enter again? (Y-N)")){
                break;
            }

        }
        Vehicle.createNewVehicle(name, type, fuelCapacity, carryingCapacity, port);
        return true;

    }
    public static boolean addContainer() throws IOException {
        int type = 0;
        String name = "";
        Port port = new Port();
        double weight = 0;
        Scanner scanner = new Scanner(System.in);
        String Pid = "";

        while (true){
            String containertype = "";
            while (true){
                System.out.println("Choose 0 for Dry Storage, 1 for Open Top, 2 for Open Side, 3 for Refridgerated, 4 for ContainerClass.Liquid");
                type = scanner.nextInt();
                if (type >=0 && type <= 4){
                    break;
                }
            }
            if (type == 0){
                containertype = "Dry Storage";
            }
            else if (type == 1){
                containertype = "Open Top";
            }
            else if (type == 2){
                containertype = "Open Side";
            }
            else if (type == 3) {
                containertype = "Refridgerated";
            }
            else {
                containertype = "ContainerClass.Liquid";
            }
            scanner.nextLine();
            if (!Utlity.yesOrno("ContainerClass.Container type: " + containertype + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }
        }

        while (true){
            System.out.println("Please enter container name");
            name = scanner.nextLine();
            if (!Utlity.yesOrno("ContainerClass.Container name: " + name + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }

        }
        while (true){
            System.out.println("Please input the ID of the port you would like to assign this container to");
            Pid = scanner.nextLine();
            port = Port.queryPortbyID(Pid);
            if (!Utlity.yesOrno("Please check Port.Port detail \n" + port + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }
        }

        while (true){
            System.out.println("Please enter container weight");
            weight = scanner.nextDouble();
            scanner.nextLine();
            if (!Utlity.yesOrno("ContainerClass.Container weight: " + weight + ". " + "Would you like to enter again? (Y-N)")){
                break;
            }
        }

        Container.createNewContainer(type, name, port, weight);
        //newcontainer.getCurrentport().acceptcontainers(newcontainer);
        return true;

    }
    //--------------------------------------------------READ METHODS---------------------------------------------------//
    //Ask Users.User if they want to filter. If yes, ask by what key they would like to filter.
    //Ask Users.User if they want to sort. If yes, ask what key they would like to sort by and what direction
    //print result
    //the method to read from list for each class has been provided
    public static boolean viewManager() throws IOException {
        //There is no need to filter or sort managers
        ArrayList<PortManager> tobeprintedlist = FileIOUtil.ReadManagerFromFile();
        Utlity.viewManager(tobeprintedlist);
        return true;
    }

    public static boolean viewAdmin() throws IOException {
        ArrayList<SystemAdmin> admins = FileIOUtil.ReadAdminFromFile();
        Utlity.viewAdmin(admins);
        return true;
    }

    public static boolean viewPort() throws IOException {
        ArrayList<Port> portlist = FileIOUtil.ReadPortFromFile();
        Utlity.viewPort(portlist);
        return true;
    }

    public static boolean viewVehicle() throws IOException {
        //VehicleClasses.Vehicle can be filtered by: type(Check the Vid, each type has a distinct id pattern)
        //VehicleClasses.Vehicle can be sorted by: fuelcapacity, current fuel, carrying capacity
        ArrayList<Vehicle> vehicles = Vehicle.getVehicles();
        Utlity.viewVehicle(vehicles);
        return true;
    }

    public static boolean viewContainers() throws IOException {
        //ContainerClass.Container can be filtered by: type(Check the Cid, each type has a distinct id pattern)
        //ContainerClass.Container can be sorted by: weight
        ArrayList<Container> containerlist = Container.getContainer();
        Utlity.viewContainers(containerlist);
        return true;
    }

    public static boolean viewAllTrips() throws IOException {
        Utlity.viewTrips(FileIOUtil.ReadTripFromFile());
        return true;
    }



    //--------------------------------------------------UPDATE METHODS--------------------------------------------------//

    //Ask user the id of the object they would like to update
    // Then ask them which key they would like to update

    public static boolean updateManager() throws IOException {
        PortManager updatemanager = new PortManager();
        FileIOUtil.updateManagerFromFile(updatemanager);
        return true;
    }

    public static void updateAdmin() throws IOException {
        SystemAdmin updateadmin = new SystemAdmin();
        FileIOUtil.updateAdminFromFile(updateadmin);
    }

    public static void updatePort() throws IOException {
        Port updateport = new Port();
        FileIOUtil.updatePortFromFile(updateport);
    }

    public static void updateVehicle() throws IOException {
        Vehicle updatevehicle = null;
        FileIOUtil.updateVehicleFromFile(updatevehicle);
    }

    public static boolean updateContainer() throws IOException {
        Container updatecontainer = new Container();
        FileIOUtil.updateVehicleFromFile(updatecontainer);
        return true;
    }




    //--------------------------------------------------DELETE METHODS--------------------------------------------------//

    public static boolean removeManager() throws IOException {
        Scanner scanner = new Scanner(System.in);
        PortManager removemanager= new PortManager();
        while (true){
            System.out.println("Please enter the id of the manager you would like to remover");
            String Eid = scanner.nextLine();
            removemanager = PortManager.queryManagerbyID(Eid);
            if (removemanager != null){
                break;
            }
            else{
                System.out.println("Please enter another id");
            }
        }
        FileIOUtil.removeManagerFromFile(removemanager);
        return true;
    }
    public static boolean removePort() throws IOException {
        Scanner scanner = new Scanner(System.in);

        Port removeport = new Port();
        while (true){
            System.out.println("Please enter the id of the port you would like to remover");
            String Pid = scanner.nextLine();
            removeport = Port.queryPortbyID(Pid);
            if (removeport != null){
                break;
            }
            else {
                System.out.println("Please enter another id.");
            }
        }
        FileIOUtil.removePortFromFile(removeport);
        return true;
    }

    public static boolean removeVehicle() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Vehicle removevehicle = null;
        while (true){
            System.out.println("Please enter the id of the vehicle you would like to remover");
            String Vid = scanner.nextLine();
            removevehicle = Vehicle.queryVehiclebyID(Vid);
            if (removevehicle != null){
                break;
            }
            else {
                System.out.println("Please enter another id.");
            }
        }

        FileIOUtil.removeVehicleFromFile(removevehicle);
        return true;
    }

    public static boolean removeContainer() throws IOException {
        Scanner scanner = new Scanner(System.in);
        Container removecontainer = new Container();
        System.out.println("Please enter the id of the container you would like to remover");
        while (true){
            String Cid = scanner.nextLine();
            removecontainer = Container.queryContainerbyID(Cid);
            if (removecontainer != null){
                break;
            }
            else {
                System.out.println("Please enter another id.");
            }
            FileIOUtil.removeContainerFromFile(removecontainer);

        }
        return true;

    }

    public static boolean removeSystemAdmin() throws IOException {
        Scanner scanner = new Scanner(System.in);
        SystemAdmin removeadmin = new SystemAdmin();
        System.out.println("Please enter the id of the container you would like to remover");
        while (true){
            String Eid = scanner.nextLine();
            removeadmin = SystemAdmin.queryAdminbyID(Eid);
            if (removeadmin != null){
                break;
            }
            else {
                System.out.println("Please enter another id.");
            }
            FileIOUtil.removeAdminFromFile(removeadmin);

        }
        return true;

    }


}

