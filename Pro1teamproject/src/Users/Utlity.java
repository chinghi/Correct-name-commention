package Users;

import ContainerClass.*;
import FileIO.FileIOUtil;
import Port.Port;
import Trip.Trip;
import VehicleClasses.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utlity {
    //-------------------------------------------------------------Table Generation----------------------------------------------------//

    public static String managerTable(ArrayList <PortManager> managerlist){
        String table = "-".repeat(60) + "\n" + "|" + " ".repeat(6) + "ID" + " ".repeat(6) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3) + "|" + " ".repeat(3) + "USERNAME" + " ".repeat(3) + "|" + " ".repeat(3) + "PASSWORD" + " ".repeat(2)+ "|\n" + "-".repeat(60);
        for (PortManager manager: managerlist){
            table = table + "|" + " ".repeat(2) + manager.getEid() + " ".repeat(2);
            table = table + "|" + " ".repeat(2) + manager.getPort().getPid() + " ".repeat(2);
            if (manager.getUsername().length() % 2 == 0){
                table = table + "|" + " ".repeat((14 - manager.getUsername().length())/2) + manager.getUsername() + " ".repeat((14 - manager.getUsername().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - manager.getUsername().length())/2 + 1) + manager.getUsername() + " ".repeat((14 - manager.getUsername().length())/2);
            }
            if (manager.getUsername().length() % 2 == 0){
                table = table + "|" + " ".repeat((13 - manager.getPassword().length())/2 + 1) + manager.getPassword() + " ".repeat((13 - manager.getPassword().length())/2) + "|\n";
            }
            else {
                table = table + "|" + " ".repeat((13 - manager.getPassword().length())/2) + manager.getPassword() + " ".repeat((13 - manager.getPassword().length())/2) + "|\n";
            }
            table = table +"-".repeat(60) + "\n";

        }
        return table;
    }

    public static String adminTable(ArrayList<SystemAdmin> adminlist){
        String table = "-".repeat(45) + "\n" + "|" + " ".repeat(6) + "ID" + " ".repeat(6) + "|" + " ".repeat(3) + "USERNAME" + " ".repeat(3) + "|" + " ".repeat(3) + "PASSWORD" + " ".repeat(2)+ "|\n" + "-".repeat(45);
        for (SystemAdmin admin: adminlist){
            table = table + "|" + " ".repeat(2) + admin.getEid() + " ".repeat(2);
            if (admin.getUsername().length() % 2 == 0){
                table = table + "|" + " ".repeat((14 - admin.getUsername().length())/2) + admin.getUsername() + " ".repeat((14 - admin.getUsername().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - admin.getUsername().length())/2 + 1) + admin.getUsername() + " ".repeat((14 - admin.getUsername().length())/2);
            }
            if (admin.getUsername().length() % 2 == 0){
                table = table + "|" + " ".repeat((13 - admin.getPassword().length())/2 + 1) + admin.getPassword() + " ".repeat((13 - admin.getPassword().length())/2) + "|\n";
            }
            else {
                table = table + "|" + " ".repeat((13 - admin.getPassword().length())/2) + admin.getPassword() + " ".repeat((13 - admin.getPassword().length())/2) + "|\n";
            }
            table = table +"-".repeat(45) + "\n";

        }
        return table;
    }
    public static String portTable(ArrayList<Port> ports){
        String table = "-".repeat(79) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " "+ "LANDING"+ " "+ "|" +" LATITUDE " + "|" + "LONGITUDE" + "| CAPACITY |" + "\n" + "-".repeat(79) + "\n";
        for (Port port: ports){
            table = table + "|" + " ".repeat(2) + port.getPid() + " ".repeat(2);
            if (port.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - port.getName().length())/2) + port.getName() + " ".repeat((20 - port.getName().length())/2);
            }
            else {

                table = table + "|" + " ".repeat((20 - port.getName().length())/2 + 1) + port.getName() + " ".repeat((20 - port.getName().length())/2);
            }
            if (port.isLandingAbility()){
                table = table + "|" + " ".repeat(3) + "true" + " ".repeat((2));
            }
            else {
                table = table + "|" + " ".repeat(2) + "false" + " ".repeat((2));
            }
            if (Double.toString(port.getLatitude()).length() % 2 ==0){
                table = table + "|" + " ".repeat((10 - Double.toString(port.getLatitude()).length())/2) + Double.toString(port.getLatitude()) + " ".repeat((10 - Double.toString(port.getLatitude()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((10 - Double.toString(port.getLatitude()).length())/2 + 1) + Double.toString(port.getLatitude()) + " ".repeat((10 - Double.toString(port.getLatitude()).length())/2);
            }
            if (Double.toString(port.getLongtitude()).length() % 2 ==0){
                table = table + "|" + " ".repeat((9 - Double.toString(port.getLongtitude()).length())/2 + 1) + Double.toString(port.getLongtitude()) + " ".repeat((9 - Double.toString(port.getLongtitude()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((9 - Double.toString(port.getLongtitude()).length())/2) + Double.toString(port.getLongtitude()) + " ".repeat((9 - Double.toString(port.getLongtitude()).length())/2);
            }
            if (Double.toString(port.getStoringCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((10 - Double.toString(port.getStoringCapacity()).length())/2) + port.getStoringCapacity() + " ".repeat((10 - Double.toString(port.getStoringCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((10 - Double.toString(port.getStoringCapacity()).length())/2 + 1) + port.getStoringCapacity() + " ".repeat((10 - Double.toString(port.getStoringCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(80) + "\n";
        }
        return  table;

    }
    public static String vehicleTable(ArrayList<Vehicle> vehicles){
        String table = "-".repeat(96) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(3) + "MAX FUEL" + " ".repeat(3) + "|" + " CURRENT FUEL " + "|" + " ".repeat(3) + "CAPACITY" + " ".repeat(2) + "|" + "\n" + "-".repeat(96) + "\n";
        for (Vehicle vehicle: vehicles){
            table = table + "|" + vehicle.getVid() + " ";
            if (vehicle.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2 + 1) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + vehicle.getCurrentport().getPid() + " ".repeat(2);

            if (Double.toString(vehicle.getFuelCapacity()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelcapacity()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2 + 1) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelcapacity()).length())/2);
            }
            if (Double.toString(vehicle.getCurrentfuel()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2 + 1) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);
            }
            if (Double.toString(vehicle.getCarryingCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2 + 1) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(96) + "\n";
        }
        return  table;

    }
    public static String shipTable(ArrayList<ship> vehicles){
        String table = "-".repeat(96) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(3) + "MAX FUEL" + " ".repeat(3) + "|" + " CURRENT FUEL " + "|" + " ".repeat(3) + "CAPACITY" + " ".repeat(2) + "|" + "\n" + "-".repeat(96) + "\n";
        for (ship vehicle: vehicles){
            table = table + "|" + vehicle.getVid() + " ";
            if (vehicle.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2 + 1) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + vehicle.getCurrentport().getPid() + " ".repeat(2);

            if (Double.toString(vehicle.getFuelCapacity()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2 + 1) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            if (Double.toString(vehicle.getCurrentfuel()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2 + 1) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);
            }
            if (Double.toString(vehicle.getCarryingCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2 + 1) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(96) + "\n";
        }
        return  table;

    }
    public static String basicTable(ArrayList<basictruck> vehicles){
        String table = "-".repeat(96) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(3) + "MAX FUEL" + " ".repeat(3) + "|" + " CURRENT FUEL " + "|" + " ".repeat(3) + "CAPACITY" + " ".repeat(2) + "|" + "\n" + "-".repeat(96) + "\n";
        for (basictruck vehicle: vehicles){
            table = table + "|" + vehicle.getVid() + " ";
            if (vehicle.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2 + 1) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + vehicle.getCurrentport().getPid() + " ".repeat(2);

            if (Double.toString(vehicle.getFuelCapacity()).length() % 2 ==0){}
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2 + 1) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            if (Double.toString(vehicle.getCurrentfuel()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2 + 1) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);
            }
            if (Double.toString(vehicle.getCarryingCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2 + 1) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(96) + "\n";
        }
        return  table;

    }
    public static String reeferTable(ArrayList<reefertruck> vehicles){
        String table = "-".repeat(96) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(3) + "MAX FUEL" + " ".repeat(3) + "|" + " CURRENT FUEL " + "|" + " ".repeat(3) + "CAPACITY" + " ".repeat(2) + "|" + "\n" + "-".repeat(96) + "\n";
        for (reefertruck vehicle: vehicles){
            table = table + "|" + vehicle.getVid() + " ";
            if (vehicle.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2 + 1) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + vehicle.getCurrentport().getPid() + " ".repeat(2);

            if (Double.toString(vehicle.getFuelCapacity()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2 + 1) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            if (Double.toString(vehicle.getCurrentfuel()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2 + 1) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);
            }
            if (Double.toString(vehicle.getCarryingCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2 + 1) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(96) + "\n";
        }
        return  table;

    }
    public static String tankerTable(ArrayList<tankertruck> vehicles){
        String table = "-".repeat(96) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(3) + "MAX FUEL" + " ".repeat(3) + "|" + " CURRENT FUEL " + "|" + " ".repeat(3) + "CAPACITY" + " ".repeat(2) + "|" + "\n" + "-".repeat(96) + "\n";
        for (tankertruck vehicle: vehicles){
            table = table + "|" + vehicle.getVid() + " ";
            if (vehicle.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - vehicle.getName().length())/2 + 1) + vehicle.getName() + " ".repeat((20 - vehicle.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + vehicle.getCurrentport().getPid() + " ".repeat(2);

            if (Double.toString(vehicle.getFuelCapacity()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2 + 1) + Double.toString(vehicle.getFuelCapacity()) + " ".repeat((14 - Double.toString(vehicle.getFuelCapacity()).length())/2);
            }
            if (Double.toString(vehicle.getCurrentfuel()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2 + 1) + Double.toString(vehicle.getCurrentfuel()) + " ".repeat((14 - Double.toString(vehicle.getCurrentfuel()).length())/2);
            }
            if (Double.toString(vehicle.getCarryingCapacity()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n"  ;
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(vehicle.getCarryingCapacity()).length())/2 + 1) + vehicle.getCarryingCapacity() + " ".repeat((13 - Double.toString(vehicle.getCarryingCapacity()).length())/2) + "|\n";
            }
            table = table + "-".repeat(96) + "\n";
        }
        return  table;

    }


















    public static String containerTable(ArrayList<Container> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (Container container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                if (container.getCid().startsWith("DS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2) + ((DryStorage) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("OT")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2) + ((OpenTop) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("OS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2) + ((OpenSide) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("RE")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2) + ((Refriderated) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else {
                    table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2) + ((Liquid) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2);
                }


            }
            else {
                if (container.getCid().startsWith("DS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((DryStorage) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("OT")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((OpenTop) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("OS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((OpenSide) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else if (container.getCid().startsWith("RE")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2+ 1) + ((Refriderated) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2);
                }
                else {
                    table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((Liquid) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2);
                }
            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                if (container.getCid().startsWith("DS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2) + ((DryStorage) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 ) + "|\n";
                }
                else if (container.getCid().startsWith("OT")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + ((OpenTop) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else if (container.getCid().startsWith("OS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + ((OpenSide) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else if (container.getCid().startsWith("RE")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + ((Refriderated) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else {
                    table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + ((Liquid) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
            }
            else {
                if (container.getCid().startsWith("DS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((DryStorage) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 ) + "|\n";
                }
                else if (container.getCid().startsWith("OT")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((OpenTop) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else if (container.getCid().startsWith("OS")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((OpenSide) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else if (container.getCid().startsWith("RE")){
                    table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((Refriderated) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
                else {
                    table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((Liquid) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
                }
            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }
    public static String DSTable(ArrayList<DryStorage> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (DryStorage container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2) + ((DryStorage) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2);

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((DryStorage) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmonship()).length())/2);

            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2) + ((DryStorage) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 ) + "|\n";

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((DryStorage) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((DryStorage) container).getFuelconsumptionperkmontruck()).length())/2 ) + "|\n";

            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }
    public static String OTTable(ArrayList<OpenTop> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (OpenTop container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2) + ((OpenTop) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2);



            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((OpenTop) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmonship()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + ((OpenTop) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((OpenTop) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenTop) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";

            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }
    public static String OSTable(ArrayList<OpenSide> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (OpenSide container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                    table = table + "|" + " ".repeat((14 - Double.toString(container.getFuelconsumptionperkmonship()).length())/2) + ((OpenSide) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2);
            }
            else {
                    table = table + "|" + " ".repeat((14 - Double.toString(container.getFuelconsumptionperkmonship()).length())/2 + 1) + ((OpenSide) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmonship()).length())/2);

            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + ((OpenSide) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";

            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((OpenSide) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((OpenSide) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }
    public static String RETable(ArrayList<Refriderated> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (Refriderated container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2) + ((Refriderated) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2);
            }

            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2+ 1) + ((Refriderated) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmonship()).length())/2);

            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + ((Refriderated) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((Refriderated) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Refriderated) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";

            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }
    public static String LITable(ArrayList<Liquid> containers){
        String table = "-".repeat(111) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" + " ".repeat(8) + "NAME"+ " ".repeat(8) + "|" + " ".repeat(4)+ "PORT ID"+ " ".repeat(3)+ "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(4) + "WEIGHT" + " ".repeat(4) + "|" + " ".repeat(3) + "SHIP L/KM" + " ".repeat(2) + "|" + " ".repeat(2) + "TRUCK L/KM" + " " +"|\n" + "-".repeat(111)+"\n";
        for (Liquid container: containers){
            table = table + "|" + container.getCid() + " ";
            if (container.getName().length() % 2 == 0){
                table = table + "|" + " ".repeat((20 - container.getName().length())/2) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            else {
                table = table + "|" + " ".repeat((20 - container.getName().length())/2 + 1) + container.getName() + " ".repeat((20 - container.getName().length())/2);
            }
            table = table + "|" + " ".repeat(2) + container.getCurrentport().getPid() + " ".repeat(2);

            if(container.getCurrentvehicle() == null){
                table = table + "|" + " ".repeat(5) + "NULL" + " ".repeat(5);
            }
            else{
                table = table + "|" + container.getCurrentvehicle().getVid() + " ";
            }

            if (Double.toString(container.getWeight()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(container.getWeight()).length())/2 + 1) + container.getWeight() + " ".repeat((14 - Double.toString(container.getWeight()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmonship()).length() % 2 ==0){
                table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2) + ((Liquid) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2);
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2 + 1) + ((Liquid) container).getFuelconsumptionperkmonship() + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmonship()).length())/2);
            }
            if (Double.toString(container.getFuelconsumptionperkmontruck()).length() % 2 == 0 ){
                table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + ((Liquid) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
            }
            else {
                table = table + "|" + " ".repeat((14 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2 + 1) + ((Liquid) container).getFuelconsumptionperkmontruck() + " ".repeat((12 - Double.toString(((Liquid) container).getFuelconsumptionperkmontruck()).length())/2) + "|\n";
            }
            table = table + "-".repeat(111) + "\n";
        }
        return  table;

    }

    public static String tripTable(ArrayList<Trip> triplist){
        String table = "-".repeat(134) + "\n" + "|" + " ".repeat(6) + "ID"+ " ".repeat(6) + "|" +" ".repeat(2) + "VEHICLE ID" + " ".repeat(2) + "|" + " ".repeat(3) + "DPORT ID" + " ".repeat(2) + "|" + " ".repeat(3) + "DPORT ID" + " ".repeat(2) + "|" + " ".repeat(6) + "DATE OF DEPARTURE" + " ".repeat(6) + "|" + " ".repeat(7) + "DATE OF ARRIVAL" + " ".repeat(6) +"|" + " ".repeat(3) + "STATUS" + " ".repeat(3) + "|\n"+  "-".repeat(134) + "\n";
        for (Trip trip: triplist){
            table = table + "|" + " " + trip.getTid() + " ";
            table = table + "|" + trip.getVehicle().getVid() + " ";
            for (Port port : Arrays.asList(trip.getDport(), trip.getAport())) {
                table = table + "|" + " ".repeat(2) + port.getPid() + " ".repeat(2);
            }
            SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
            String Dod = dateFormatter.format(trip.getDateofdeparture());
            String Doa = dateFormatter.format(trip.getDateofarrival());
            if (Dod.length() % 2 == 0){
                table = table + "|" + " ".repeat(((29 - Dod.length())/2 + 1)) + Dod + " ".repeat((29 - Dod.length())/2);
            }
            else{
                table = table + "|" + " ".repeat(( 29 - Dod.length()/2)) + Dod + " ".repeat((29 - Dod.length())/2);
            }
            if (Doa.length() % 2 == 0){
                table = table + "|" + " ".repeat(((29 - Doa.length())/2 + 1)) + Doa + " ".repeat((29- Doa.length())/2);
            }
            else {
                table = table + "|" + " ".repeat(((29 - Doa.length())/2 + 1)) + Doa + " ".repeat((29 - Doa.length())/2);
            }
            table = table + "|" + " ".repeat((12 - trip.getStatus().length())/2 ) + trip.getStatus() + " ".repeat((12 - trip.getStatus().length())/2) + "|\n" + "-".repeat(134) + "\n";




        }
        return table;
    }




    //Y-N verification
    public static boolean yesOrno(String string){
        Scanner scanner = new Scanner(System.in);
        String rep = "";
        while (true){
            System.out.println(string);
            rep = scanner.nextLine();
            if (rep.equalsIgnoreCase("y") || rep.equalsIgnoreCase("n")){
                if (rep.equalsIgnoreCase("y")){
                    return true;
                }
                else {
                    return false;
                }

            }
            else {
                System.out.println("Option does not exist. Please enter again");
            }
        }

    }
    //--------------------------------------------Sorting Ports-----------------------------------------------------//
    public static void sortingPort(ArrayList<Port> ports){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the ports by storing capacity? (Y or N) ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending false: descending)");
                boolean order = scanner.nextBoolean();
                Port.sortPortbyStoringCapacity(ports, order);
                break;
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }
    //--------------------------------------------Sorting VehicleClasses.Vehicle---------------------------------------------------//
    public static void sortingVehicle(ArrayList<Vehicle> vehicles){
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                while (true){
                    System.out.println("Please select the property you want to sort the list by:\n1: Max Carrying Capacity\n2: Fuel Capacity\n3: Current Fuel ");
                    selection = scanner.nextInt();
                    System.out.println("What order you would like to sort your list? (true: ascending false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 1){
                        Vehicle.sortVehiclebyMaxCapacity(vehicles, order);
                        break;
                    }
                    else if (selection == 2){
                        Vehicle.sortVehiclebyFuelCapacity(vehicles, order);
                        break;

                    }
                    else if (selection == 3){
                        Vehicle.sortVehiclebyCurrentFuel(vehicles, order);
                        break;
                    }
                    else{
                        System.out.println("option does not exist. Please choose again");
                    }
                }
                scanner.nextLine();
                System.out.println(vehicles);
                System.out.println("Would you like to continue sorting? Y-N");
                response = scanner.nextLine();
                if (response.equals("N")){
                    break;
                }

            }
            else {
                System.out.println("Option does not exist. Please choose again");
            }
        }

    }

    public static void sortingByShip(ArrayList<ship> vehicles){
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                while (true){
                    System.out.println("Please select the property you want to sort the list by:\n1: Max Carrying Capacity\n2: Fuel Capacity\n3: Current Fuel\n0: Quite ");
                    selection = scanner.nextInt();
                    System.out.println("What order you would like to sort your list? (true: ascending false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 0){
                        break;
                    }
                    else if (selection == 1){
                        ship.sortbyMaxCapacity(vehicles, order);
                    }
                    else if (selection == 2){
                        ship.sortbyFuelCapacity(vehicles, order);
                    }
                    else if (selection == 3){
                        ship.sortbyCurrentFuel(vehicles, order);
                    }
                    else{
                        System.out.println("option does not exist. Please choose again");
                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }

    public static void sortingBasicTruck(ArrayList<basictruck> vehicles){
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                while (true){
                    System.out.println("Please select the property you want to sort the list by:\n1: Max Carrying Capacity\n2: Fuel Capacity\n3: Current Fuel\n0: Quit ");
                    selection = scanner.nextInt();
                    System.out.println("What order you would like to sort your list? (true: ascending false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 0){
                        break;
                    }
                    if (selection == 1){
                        basictruck.sortbyMaxCapacity(vehicles, order);
                    }
                    else if (selection == 2){
                        basictruck.sortbyFuelCapacity(vehicles, order);

                    }
                    else if (selection == 3){
                        basictruck.sortbyCurrentFuel(vehicles, order);
                    }
                    else{
                        System.out.println("option does not exist. Please choose again");
                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }


    public static void sortingReefer(ArrayList<reefertruck> vehicles){
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                while (true){
                    System.out.println("Please select the property you want to sort the list by:\n1: Max Carrying Capacity\n2: Fuel Capacity\n3: Current Fuel\n0: Quit ");
                    selection = scanner.nextInt();
                    System.out.println("What order you would like to sort your list? (true: ascending false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 0){
                        break;
                    }
                    if (selection == 1){
                        reefertruck.sortbyMaxCapacity(vehicles, order);
                    }
                    else if (selection == 2){
                        reefertruck.sortbyFuelCapacity(vehicles, order);
                    }
                    else if (selection == 3){
                        reefertruck.sortbyCurrentFuel(vehicles, order);
                    }
                    else{
                        System.out.println("option does not exist. Please choose again");
                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please choose again");
            }
        }
    }

    public static void sortingTanker(ArrayList<tankertruck> vehicles){
        int selection = 0;
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                while (true){
                    System.out.println("Please select the property you want to sort the list by:\n1: Max Carrying Capacity\n2: Fuel Capacity\n3: Current Fuel\n0: Quit ");
                    selection = scanner.nextInt();
                    System.out.println("What order you would like to sort your list? (true: ascending false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 0){
                        break;
                    }
                    if (selection == 1){
                        tankertruck.sortbyMaxCapacity(vehicles, order);
                    }
                    else if (selection == 2){
                        tankertruck.sortbyFuelCapacity(vehicles, order);
                    }
                    else if (selection == 3){
                        tankertruck.sortbyCurrentFuel(vehicles, order);
                    }
                    else{
                        System.out.println("option does not exist. Please choose again");
                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please try again");
            }
        }
    }

    //---------------------------------------Sorting Containers------------------------------------------//

    public static void sortingContainer(ArrayList<Container> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {

                while (true){
                    System.out.println("By what order would you like to sort the list? (t: ascending f: descending)");
                    String selection = scanner.nextLine();
                    if (selection.equalsIgnoreCase("t")){
                        Container.sortContainerByWeight(containers, true);
                        break;
                    }
                    else if (selection.equalsIgnoreCase("f")){
                        Container.sortContainerByWeight(containers, false);
                        break;
                    }
                    else {
                        System.out.println("Option does not exist. Please try again");

                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }

    public static void sortingDSContainer(ArrayList<DryStorage> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending false: descending)");
                boolean order = scanner.nextBoolean();
                DryStorage.sortContainerbyWeight(containers, order);
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }

    }
    public static void sortingOTContainer(ArrayList<OpenTop> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending false: descending)");
                boolean order = scanner.nextBoolean();
                OpenTop.sortContainerbyWeight(containers, order);
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }
    public static void sortingOSContainer(ArrayList<OpenSide> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending  false: descending)");
                boolean order = scanner.nextBoolean();
                OpenSide.sortContainerbyWeight(containers, order);
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }
    public static void sortingREContainer(ArrayList<Refriderated> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending  false: descending)");
                boolean order = scanner.nextBoolean();
                Refriderated.sortContainerbyWeight(containers, order);
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }
    public static void sortingLIContainer(ArrayList<Liquid> containers){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list by weight? (Y or N) ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("By what order would you like to sort the list? (true: ascending  false: descending)");
                boolean order = scanner.nextBoolean();
                Liquid.sortContainerbyWeight(containers, order);
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
    }

    //---------------------------------------------------Sorting ContainerClass.OpenTop.Trip.Trip-------------------------------------------------------//
    public static void sortingTrip(ArrayList<Trip> triplist){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Would you like to sort the list? (Y or M) ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("n")){
                break;
            }
            else if (response.equalsIgnoreCase("y")) {
                System.out.println("Please choose the property you would like to sort this list by:\n1: Date of Departure\n2: Date of Arrival\n0: Quit");
                while (true){
                    int selection = scanner.nextInt();
                    System.out.println("In which order would you like to sort this list? (true: ascending  false: descending");
                    boolean order = scanner.nextBoolean();
                    if (selection == 0){
                        break;
                    }
                    else if (selection == 1 ){
                        Trip.sortTripbyDod(triplist, order);
                    }
                    else if (selection == 2){
                        Trip.sortTripbyDod(triplist, order);
                    }
                    else {
                        System.out.println("Option does not exist. Please choose again");
                    }
                }
            }
            else {
                System.out.println("Option does not exist. Please choose again");
            }

        }
    }

    //---------------------------------------------------------------Filter Methods------------------------------------------------------//

    public static boolean viewManager(ArrayList<PortManager> managers) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Press p if you do want to filter by current port, s if you want to search manager by ID, and q to quit");
            String selection = scanner.nextLine();
            scanner.nextLine();
            if (selection.equalsIgnoreCase("q")){
                break;
            }
            else if (selection.equalsIgnoreCase("p")){
                PortManager.filteringManagerbyPort(managers);
            }
            else if (selection.equalsIgnoreCase("s")){
                System.out.println("Please enter manager ID");
                String Eid = scanner.nextLine();
                System.out.println(PortManager.queryManagerbyID(Eid));
            }
            else {
                System.out.println("Option does not exist. Please choose again.");
            }
        }
        System.out.println(Utlity.managerTable(managers));
        return true;


    }

    public static boolean viewAdmin(ArrayList<SystemAdmin> admins){
        System.out.println(adminTable(admins));
        return true;
    }

    public static boolean viewVehicle(ArrayList<Vehicle> vehicles) throws IOException {
        //VehicleClasses.Vehicle can be filtered by: type(Check the Vid, each type has a distinct id pattern)
        //VehicleClasses.Vehicle can be sorted by: fuelcapacity, current fuel, carrying capacity
        Scanner scanner = new Scanner(System.in);
        Utlity.sortingVehicle(vehicles);
        System.out.println(Utlity.vehicleTable(vehicles));

        while (true){
            vehicles = Vehicle.getVehicles();
            System.out.println("Press t if you want to filter by type, p if you do want to filter by current port, s to search for vehicle by ID, and q to quit");
            String selection = scanner.nextLine();
            scanner.nextLine();
            if (selection.equalsIgnoreCase("q")){
                break;
            }
            else if (selection.equalsIgnoreCase("t")){
                Vehicle.filteringVehiclebyType();
            }
            else if (selection.equalsIgnoreCase("p")){
                Vehicle.filteringVehiclebyPortID(vehicles);
            }
            else if (selection.equalsIgnoreCase("s")){
                System.out.println("Please enter Vehicle ID");
                String Vid = scanner.nextLine();
                System.out.println(Vehicle.queryVehiclebyID(Vid));
            }
            else {
                System.out.println("option is not available. Please choose another option");
            }

        }
        return true;
    }

    public static boolean viewContainers(ArrayList<Container> containerlist) throws IOException {
        //ContainerClass.Container can be filtered by: type(Check the Cid, each type has a distinct id pattern)
        //ContainerClass.Container can be sorted by: weight
        Scanner scanner = new Scanner(System.in);
        Utlity.sortingContainer(containerlist);
        System.out.println(Utlity.containerTable(containerlist));
        while (true){
            containerlist = Container.getContainer();
            System.out.println("Press t if you want to filter by type, p if you do want to filter by current port, s if you want to search container by ID, and q to quit");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")){
                break;
            }
            else if (selection.equalsIgnoreCase("t")){
                Container.filteringContainerbyType();
            }
            else if (selection.equalsIgnoreCase("p")){
                Container.filteringContainerbyPortID(containerlist);
            }
            else if (selection.equalsIgnoreCase("s")){
                System.out.println("Please enter container ID");
                String Cid = scanner.nextLine();
                System.out.println(Container.queryContainerbyID(Cid));
            }

            else {
                System.out.println("option is not available. Please choose another option");
            }

        }
        return true;
    }

    private static boolean containerTable(ArrayList<Container> containerlist) {
        return false;
    }


    public static boolean viewPort(ArrayList<Port> portlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Utlity.sortingPort(portlist);
        while (true){
            System.out.println("Choose ft if you want to filter ports by their landing ability, s if you want to search Port by ID, and q if you do not");
            String response = scanner.nextLine();
            if (response.equalsIgnoreCase("q")){
                System.out.println(Utlity.portTable(portlist));
                break;
            }
            else if (response.equalsIgnoreCase("ft")){
                Port.filteringPortsbyLandingAbility(portlist);
            }
            else if (response.equalsIgnoreCase("s")){
                System.out.println("Please enter Port ID");
                String Pid = scanner.nextLine();
                System.out.println(Port.queryPortbyID(Pid));
            }
            else {
                System.out.println("Option does not exist. Please choose again");
            }

        }

        return true;
    }

    public static boolean viewTrips(ArrayList<Trip> filteredlist) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Utlity.tripTable(filteredlist));
        while (true){
            filteredlist = FileIOUtil.ReadTripFromFile();
            System.out.println("Press f if you want to filter by type and q if you do not want to filter");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("q")){
                break;
            }
            else if (selection.equalsIgnoreCase("f")){
                while (true){
                    System.out.println("What would you like to filter by:\nv: VehicleClasses.Vehicle\npa: Port.Port of Arrival\npd: Port.Port of Departure\nst: status\nq: Quit");
                    selection = scanner.nextLine();
                    if (selection.equalsIgnoreCase("q")){
                        break;
                    }
                    else if (selection.equalsIgnoreCase("v")){
                        Trip.filteringTripsbyVehicle(filteredlist);
                    }
                    else if (selection.equalsIgnoreCase("pa")) {
                        Trip.filteringTripbyArrivalPort(filteredlist);

                    }
                    else if (selection.equalsIgnoreCase("pd")){
                        Trip.filteringTripbyDeparturePort(filteredlist);

                    }
                    else if (selection.equalsIgnoreCase("s")){
                        System.out.println("Please enter trip ID");
                        String Tid = scanner.nextLine();
                        System.out.println(Trip.queryByName(Tid));
                    }
                    else {
                        System.out.println("Option does not exist. Please enter again");
                    }
                }
            }
            else if (selection.equalsIgnoreCase("st")){
                Trip.filteringTripbyStatus(filteredlist);
            }
            else {
                System.out.println("Option does not exist. Please choose again");
            }
            Utlity.sortingTrip(filteredlist);
            System.out.println(filteredlist);


        }

        return true;

    }


    public static void sortingReefer() {
        sortingReefer(null);
    }

    public static void sortingTanker() {
        sortingTanker(null);
    }

}

