package Port;

import FileIO.FileIOUtil;
import Users.Utlity;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Port implements Serializable {
    private static final long serialVersionUID = 6529685098267757690L;
    private String pid;
    private double latitude;
    private double longtitude;
    private String name;
    private double storingCapacity;
    private boolean landingAbility;
    private int numberofVehiclesOnsite = 0;
    private int numberofContainersOnsite = 0;
    private double currentCapacity= 0;

    public boolean equals(Port port) {
        if (port == this) {
            System.out.println("true");
            return true;
        }

        return this.pid.equals(port.pid) && this.name.equals(port.name) && this.latitude == port.latitude  && this.longtitude == port.longtitude;


    }

    public  Port(){

    }

    public Port(String Pid, double latitude, double longtitude, String name, double storingcapacity, boolean landingability){
        this.pid = Pid;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.name = name;
        this.storingCapacity = storingcapacity;
        this.landingAbility = landingability;
    }
    public String toString(){
        return "Port.Port id: " + this.pid + "\n" + "Port.Port name: "+ this.name + "\n" + "Port.Port latitude: " + this.latitude + "\n" + "Port.Port longtitude: " + this.longtitude + "\n" + "Storing capacity: "+ this.storingCapacity + "\n" + "Landing ability: " + this.landingAbility + "\n" + "\n";}

    public static Port createNewPort(String name, double latitude, double longtitude, double storingcapacity, boolean landingability) throws IOException {
        String Pid = "";
        Random random = new Random();
        for (int i = 1; i<=10; i++){
            Pid = Pid + random.nextInt(10);
        }
        Port newport = new Port(Pid, latitude, longtitude, name, storingcapacity, landingability);
        FileIOUtil.InputObjectIntoFile(newport, "port.json");
        return newport;

    }

    public static Port queryPortbyID(String Pid) throws IOException {
        for (Port port: FileIOUtil.ReadPortFromFile()){
            if (port.pid.equals(Pid)){
                return port;
            }
        }
        System.out.println("This port does not exist");
        return null;
    }
    //--------------------------------------------Getters-----------------------------------------//


    public String getPid() {
        return pid;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String getName() {
        return name;
    }

    public double getStoringCapacity() {
        return storingCapacity;
    }

    public boolean isLandingAbility() {
        return landingAbility;
    }

    //-----------------------------------------------------Setters---------------------------------------------//


    public void setPid(String pid) {
        this.pid = pid;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStoringCapacity(double storingCapacity) {
        this.storingCapacity = storingCapacity;
    }

    public void setLandingAbility(boolean landingAbility) {
        this.landingAbility = landingAbility;
    }

    public double distanceCalc(Port targetPort){
        double distance = (3440.1 * Math.acos((Math.sin(this.latitude * (Math.PI/180)) * Math.sin(targetPort.latitude * (Math.PI/180))) + Math.cos(this.latitude * (Math.PI/180)) * Math.cos(targetPort.latitude * (Math.PI/180)) * Math.cos(this.longtitude * (Math.PI/180) - targetPort.longtitude * (Math.PI/180)))) * 1.852 ;
        distance = (double) Math.round(distance * 100)/100;
        return distance;
    }

    public static void sortPortbyStoringCapacity(ArrayList<Port> portlist, boolean order){
        if (!order){
            for (int i =0; i < portlist.size(); i++){
                double maxcapac = portlist.get(i).getStoringCapacity();
                Port temp = portlist.get(i);
                int index = i;
                for (int k = i+1; k < portlist.size(); k++){
                    if (portlist.get(k).getStoringCapacity() > maxcapac){
                        index = k;
                    }
                }
                portlist.set(i, portlist.get(index));
                portlist.set(index, temp);
            }
        }
        else {
            for (int i =0; i < portlist.size(); i++){
                double mincapac = portlist.get(i).getStoringCapacity();
                Port temp = portlist.get(i);
                int index = i;
                for (int k = i+1; k < portlist.size(); k++){
                    if (portlist.get(k).getStoringCapacity() < mincapac){
                        index = k;
                    }
                }
                portlist.set(i, portlist.get(index));
                portlist.set(index, temp);
            }
        }

    }

    public static void filteringPortsbyLandingAbility(ArrayList<Port> portlist){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter landing ability (t: true  f: false)");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("t")){
                for (int i =0; i< portlist.size(); i++){
                    if (!portlist.get(i).isLandingAbility()){
                        portlist.remove(portlist.get(i));
                    }
                }
                Utlity.sortingPort(portlist);
                break;
            }
            else if (response.equalsIgnoreCase("f")){
                for (int i =0; i< portlist.size(); i++){
                    if (portlist.get(i).isLandingAbility()){
                        portlist.remove(portlist.get(i));
                    }
                }
                Utlity.sortingPort(portlist);
                break;
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }

        }
    }


    public double getNumberofVehiclesOnsite() {
        return 0;
    }

    public void setNumberofVehiclesOnsite(int i) {
    }

    public void setNumberofContainersOnsite(double v) {
    }

    public double getNumberofContainersOnsite() {
        return 0;
    }

    public double getCurrentCapacity() {
        return 0;
    }

    public void setCurrentCapacity(double v) {
    }
}
