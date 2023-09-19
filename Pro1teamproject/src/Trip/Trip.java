package Trip;

import ContainerClass.Container;
import FileIO.FileIOUtil;
import Port.Port;
import VehicleClasses.Vehicle;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class Trip implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private Date dateofarrival;
    private Vehicle vehicle;
    private String tid;
    private String status = "Incomplete";
    private Port dport;
    private Port aport;
    private Date datofarrival;
    private ArrayList<String> tobedeliveredcontainers = new ArrayList<String>();
    private Date dateofdeparture;


    public Trip() {

    }

    public Trip(Vehicle vehicle, String Tid, Port Dport, Port Aport, Date dateofdeparture, Date dateofarrival, ArrayList<String> containers) {
        this.vehicle = vehicle;
        this.tid = Tid;
        this.dport = Dport;
        this.aport = Aport;
        this.dateofarrival = dateofarrival;
        this.dateofdeparture = dateofdeparture;
        this.tobedeliveredcontainers = containers;
    }

    public static ArrayList<Trip> outgoingTripquery(Port port, Date after, Date before) {
        return null;
    }

    public static ArrayList<Trip> incomingTripquery(Port port, Date after, Date before) {
        return null;
    }

    public String toString() {
        return "ContainerClass.OpenTop.Trip.Trip id: " + this.tid + "\n" + "VehicleClasses.Vehicle: " + this.vehicle.getVid() + "\n" + "Status: " + this.status + "\n" + "Departure Port.Port: " + this.dport.getName() + "\n" + "Arrival Port.Port: " + this.aport.getName() + "\n" + "Date of Departure: " + this.dateofdeparture + "\n" + "Date of Arrival: " + this.dateofarrival + "\n" + "\n";
    }

    public boolean equals(Trip trip) {
        if (trip == this) {
            System.out.println("true");
            return true;
        }
        return this.tid.equals(trip.tid) && this.vehicle.equals(trip.vehicle);
    }

    //------------------------------------------Getter--------------------------------------//

    public String getTid() {
        return this.tid;
    }


    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public ArrayList<String> getTobedeliveredcontainers() {
        return this.tobedeliveredcontainers;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Port getDport() {
        return this.dport;
    }

    public Port getAport() {
        return this.aport;
    }

    public Date getDateofdeparture() {
        return dateofdeparture;
    }

    public Date getDateofarrival() {
        return dateofarrival;
    }

    public String getStatus() {
        return status;
    }

    //---------------------------------------------------Setter----------------------------------------//


    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public void setDport(Port dport) {
        this.dport = dport;
    }

    public void setAport(Port aport) {
        this.aport = aport;
    }

    public void setDateofdeparture(Date dateofdeparture) {
        this.dateofdeparture = dateofdeparture;
    }

    public void setDateofarrival(Date dateofarrival) {
        this.dateofarrival = dateofarrival;
    }

    public void setTobedeliveredcontainers(ArrayList<String> tobedeliveredcontainers) {
        this.tobedeliveredcontainers = tobedeliveredcontainers;
    }


    public static ArrayList<Vehicle> checkingvehicleeligibility(Port port, Port portofarrival, Date dateofarrival, Date dateofdeparture, ArrayList<Container> containerlist) throws IOException {
        //this method returns a list of vehicle available to be deployed on the trip. VehicleClasses.Vehicle eligibility is evaluated based on the arrival base's landing ability (False means only accessible to ships) whether a vehicle is capable of finishing a trip given a list of containers and trip length (by calling the successAssement method from the VehicleClasses.Vehicle Class), whether it is on another trip on the given trip duration.
        ArrayList<Vehicle> deployablevehicles = new ArrayList<Vehicle>();
        ArrayList<Vehicle> unavailablevehicles = new ArrayList<Vehicle>();
        ArrayList<Vehicle> vehicles = Vehicle.getVehicles();
        File file = new File("trip.json");
        if (file.length() == 0) {
            System.out.println("true");
            if (portofarrival.isLandingAbility()) {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getCurrentport().equals(port) && vehicle.successAssessment(containerlist, port.distanceCalc(portofarrival))) {
                        deployablevehicles.add(vehicle);
                    }
                }
            } else {
                for (Vehicle vehicle : vehicles) {
                    if (vehicle.getCurrentport().equals(port) && vehicle.getVid().startsWith("SH") && vehicle.successAssessment(containerlist, port.distanceCalc(portofarrival))) {
                        deployablevehicles.add(vehicle);
                    }
                }
            }
        } else {
            System.out.println("false");
            for (Trip trip : FileIOUtil.ReadTripFromFile()) {
                if (trip.getDport().equals(port)) {
                    if ((!dateofdeparture.after(trip.dateofarrival) && !dateofdeparture.before(trip.dateofdeparture)) || ((!dateofarrival.after(trip.dateofarrival) && !dateofarrival.before(trip.dateofdeparture)))) {
                        unavailablevehicles.add(trip.getVehicle());
                    }
                }
            }

            for (Vehicle vehicle : vehicles) {
                if (portofarrival.isLandingAbility()) {
                    if (!unavailablevehicles.contains(vehicle) && vehicle.successAssessment(containerlist, port.distanceCalc(portofarrival)) && vehicle.getCurrentport().equals(port)) {
                        deployablevehicles.add(vehicle);
                    }
                } else {
                    if (!unavailablevehicles.contains(vehicle) && vehicle.successAssessment(containerlist, port.distanceCalc(portofarrival)) && vehicle.getName().startsWith("SH") && vehicle.getCurrentport().equals(port)) {
                        deployablevehicles.add(vehicle);
                    }
                }

            }
        }
        return deployablevehicles;
    }


    //this method will register a trip into the system. It prompts the user to input date and port of departure and arrival, it will then have them choose from a list of available vehicles returned by the checkingvehicleeligibility function. The id of the trip will be randomly generated
    public static Trip registeringTrip(Port port, Date dateofdeparture, Date dateofarrival, Port portofarrival, ArrayList<String> containers, Vehicle selectedvehicle) throws IOException {
        //Randomly generating trip id
        Random generatingid = new Random();
        String Tid = "t";
        for (int i = 0; i <= 10; i++) {
            Tid = Tid + generatingid.nextInt(10);
        }
        Trip newtrip = new Trip(selectedvehicle, Tid, port, portofarrival, dateofdeparture, dateofarrival, containers);
        FileIOUtil.InputObjectIntoFile(newtrip, "trip.json");
        return newtrip;
    }

    public static Trip queryByName(String Tid) throws IOException {
        for (Trip trip : FileIOUtil.ReadTripFromFile()) {
            if (trip.getTid().equals(Tid)) {
                return trip;
            }
        }
        return null;
    }

    public static void sortTripbyDod(ArrayList<Trip> triplist, boolean order) {
        if (!order) {
            for (int i = 0; i < triplist.size(); i++) {
                Date latestdateofdeparture = triplist.get(i).getDateofdeparture();
                int index = i;
                Trip temp = triplist.get(i);
                for (int k = i + 1; k < triplist.size(); k++) {
                    if (triplist.get(k).getDateofdeparture().after(latestdateofdeparture)) {
                        index = k;
                        latestdateofdeparture = triplist.get(k).getDateofdeparture();
                    }
                }
                triplist.set(i, triplist.get(index));
                triplist.set(index, temp);
            }
        } else {
            for (int i = 0; i < triplist.size(); i++) {
                Date earliestdateofdeparture = triplist.get(i).getDateofdeparture();
                int index = i;
                Trip temp = triplist.get(i);
                for (int k = i + 1; k < triplist.size(); k++) {
                    if (triplist.get(k).getDateofdeparture().before(earliestdateofdeparture)) {
                        index = k;
                        earliestdateofdeparture = triplist.get(k).getDateofdeparture();
                    }
                }
                triplist.set(i, triplist.get(index));
                triplist.set(index, temp);
            }
        }
    }

    public static void sortTripbyDoa(ArrayList<Trip> triplist, boolean order) {
        if (!order) {
            for (int i = 0; i < triplist.size(); i++) {
                Date latestdateofarrival = triplist.get(i).getDateofarrival();
                int index = i;
                Trip temp = triplist.get(i);
                for (int k = i + 1; k < triplist.size(); k++) {
                    if (triplist.get(k).getDateofarrival().after(latestdateofarrival)) {
                        index = k;
                        latestdateofarrival = triplist.get(k).getDateofarrival();
                    }
                }
                triplist.set(i, triplist.get(index));
                triplist.set(index, temp);
            }
        } else {
            for (int i = 0; i < triplist.size(); i++) {
                Date earliestdateofarrival = triplist.get(i).getDateofarrival();
                int index = i;
                Trip temp = triplist.get(i);
                for (int k = i + 1; k < triplist.size(); k++) {
                    if (triplist.get(k).getDateofarrival().before(earliestdateofarrival)) {
                        index = k;
                        earliestdateofarrival = triplist.get(k).getDateofarrival();
                    }
                }
                triplist.set(i, triplist.get(index));
                triplist.set(i, triplist.get(index));
            }
        }
    }


    //This method allows Port.Port Manager to view the outgoing trips after/before inputted dates
    public static ArrayList<Trip> outgoingTripquery(Port port, Date after, Date before) throws IOException {
        //Have the users input the interval they would like to query
        ArrayList<Trip> tripfromport = new ArrayList<Trip>();
        ArrayList<Trip> triplist = new ArrayList<Trip>();
        for (Trip o : FileIOUtil.ReadTripFromFile()) {
            triplist.add(o);
        }
        //querying
        //if the user does not enter both before and after filtering dates, the function will return all outgoing trips
        if (after == null && before == null) {
            for (Trip trip : triplist) {
                if (trip.getDport().equals(port)) {
                    tripfromport.add(trip);
                }
            }
        }

        //if the user only enter the after filtering date, the function will return all the outgoing trip after that date
        else if (before == null && !(after == null)) {
            for (Trip trip : triplist) {
                if (trip.dateofdeparture.after(after) && trip.getDport().equals(port)) {
                    tripfromport.add(trip);
                }
            }
        }

        //if the user only enter the after filtering date, the function will return all the outgoing trip before that date
        else if (after == null && !(before == null)) {
            for (Trip trip : triplist) {
                if (trip.dateofdeparture.before(before) && trip.getDport().equals(port)) {
                    tripfromport.add(trip);
                }
            }
        } else {
            for (Trip trip : triplist) {
                if (trip.dateofdeparture.before(before) && trip.dateofdeparture.after(after) && trip.getDport().equals(port)) {
                    tripfromport.add(trip);
                }
            }
        }

        return tripfromport;
    }


    //This method allows Port.Port Manager to see the incoming trip after/before inputted dates.
    public static ArrayList<Trip> incomingTripquery(Port port, Date after, Date before) throws IOException {
        //Have the users input the interval they would like to query
        ArrayList<Trip> tripfromport = new ArrayList<Trip>();
        ArrayList<Trip> triplist = new ArrayList<Trip>();
        for (Trip o : FileIOUtil.ReadTripFromFile()) {
            triplist.add(o);
        }

        //querying
        //if the user does not enter both before and after filtering dates, the function will return all incoming trips
        if (after == null && before == null) {
            for (Trip trip : triplist) {
                if (trip.getAport() == port) {
                    tripfromport.add(trip);
                }
            }
        }
        //if the user only enter the after filtering date, the function will return all the outgoing trip after that date
        else if (before == null && !(after == null)) {
            for (Trip trip : triplist) {
                if (trip.getDateofarrival().after(after) && trip.getAport() == port) {
                    tripfromport.add(trip);
                }
            }
        }

        //if the user only enter the after filtering date, the function will return all the outgoing trip before that date
        else if (after == null && !(before == null)) {
            for (Trip trip : triplist) {
                if (trip.getDateofarrival().before(before) && trip.getAport() == port) {
                    tripfromport.add(trip);
                }
            }
        } else {
            for (Trip trip : triplist) {
                if (trip.dateofarrival.before(before) && trip.dateofarrival.after(after) && trip.getDport().equals(port)) {
                    tripfromport.add(trip);
                }
            }
        }
        return tripfromport;
    }

    public void completeTrip() throws IOException {
        this.setStatus("Complete");
        FileIOUtil.updateTripFromFile(this);
    }


    public static void filteringTripsbyVehicle(ArrayList<Trip> filteredlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter vehicle id");
        String Vid = scanner.nextLine();
        Vehicle filtervehicle = Vehicle.queryVehiclebyID(Vid);
        for (int i = 0; i < filteredlist.size(); i++) {
            if (!filtervehicle.equals(filteredlist.get(i).getVehicle())) {
                filteredlist.remove(filteredlist.get(i));
            }
        }
    }

    public static void filteringTripbyArrivalPort(ArrayList<Trip> filteredlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Arrival Port.Port id");
        String Pid = scanner.nextLine();
        Port filterport = Port.queryPortbyID(Pid);
        for (int i = 0; i < filteredlist.size(); i++) {
            if (!filterport.equals(filteredlist.get(i).getAport())) {
                filteredlist.remove(filteredlist.get(i));
            }
        }
        System.out.println(filteredlist);
    }

    public static void filteringTripbyDeparturePort(ArrayList<Trip> filteredlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter Arrival Port.Port id");
        String Pid = scanner.nextLine();
        Port filterport = Port.queryPortbyID(Pid);
        for (int i = 0; i < filteredlist.size(); i++) {
            if (!filterport.equals(filteredlist.get(i).getport())) {
                filteredlist.remove(filteredlist.get(i));
            }
        }
    }

    private Port getport() {
        return null;
    }

    public static void filteringTripbyStatus(ArrayList<Trip> filteredlist) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("a: See Completed Trips\nb: See Incompleted Trips");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("a")) {
                for (int i = 0; i < filteredlist.size(); i++) {
                    if (filteredlist.get(i).getStatus().equalsIgnoreCase("Incomplete")) {
                        filteredlist.remove(filteredlist.get(i));
                    }
                }
            } else if (selection.equalsIgnoreCase("b")) {
                for (int i = 0; i < filteredlist.size(); i++) {
                    if (filteredlist.get(i).getStatus().equalsIgnoreCase("Complete")) {
                        filteredlist.remove(filteredlist.get(i));
                    }
                }
            } else {
                System.out.println("Option does not exist. Please choose again");
            }
        }
    }
}




