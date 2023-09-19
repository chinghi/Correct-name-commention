package FileIO;

import ContainerClass.*;
import Port.Port;
import Trip.Trip;
import Users.PortManager;
import Users.SystemAdmin;
import VehicleClasses.basictruck;
import VehicleClasses.reefertruck;
import VehicleClasses.ship;
import VehicleClasses.tankertruck;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.ArrayList;

public class FileIOUtil {

    public static ArrayList<Object> ReadObjectFromFile(String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filename);
        ArrayList<Object> list = new ArrayList<Object>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Object>>() {
        });
        return list;
    }
    public static ArrayList<Port> ReadPortFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("port.json");
        ArrayList<Port> list = new ArrayList<Port>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Port>>() {});
        return list;
    }
    //---------------------------------------------Read From Files-------------------------------------------------//
    public static ArrayList<ship> ReadShipFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("VehicleClasses.ship.json");
        ArrayList<ship> list = new ArrayList<ship>();
        list = mapper.readValue(file, new TypeReference<ArrayList<ship>>() {});
        return list;
    }
    public static ArrayList<basictruck> ReadBasicTruckFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("VehicleClasses.basictruck.json");
        ArrayList<basictruck> list = new ArrayList<basictruck>();
        list = mapper.readValue(file, new TypeReference<ArrayList<basictruck>>() {});
        return list;
    }
    public static ArrayList<reefertruck> ReadReeferFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("VehicleClasses.reefertruck.json");
        ArrayList<reefertruck> list = new ArrayList<reefertruck>();
        list = mapper.readValue(file, new TypeReference<ArrayList<reefertruck>>() {});
        return list;
    }
    public static ArrayList<tankertruck> ReadTankerFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("VehicleClasses.tankertruck.json");
        ArrayList<tankertruck> list = new ArrayList<tankertruck>();
        list = mapper.readValue(file, new TypeReference<ArrayList<tankertruck>>() {});
        return list;
    }
    public static ArrayList<Container> ReadContainerFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("container.json");
        ArrayList<Container> list = new ArrayList<Container>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Container>>() {});
        return list;
    }
    public static ArrayList<DryStorage> ReadDryStorageFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("drystorage.json");
        ArrayList<DryStorage> list = new ArrayList<DryStorage>();
        list = mapper.readValue(file, new TypeReference<ArrayList<DryStorage>>() {});
        return list;
    }
    public static ArrayList<OpenTop> ReadOpenTopFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("opentop.json");
        ArrayList<OpenTop> list = new ArrayList<OpenTop>();
        list = mapper.readValue(file, new TypeReference<ArrayList<OpenTop>>() {});
        return list;
    }
    public static ArrayList<OpenSide> ReadOpenSideFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("openside.json");
        ArrayList<OpenSide> list = new ArrayList<OpenSide>();
        list = mapper.readValue(file, new TypeReference<ArrayList<OpenSide>>() {});
        return list;
    }
    public static ArrayList<Refriderated> ReadRefridgeratedFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("refridgerated.json");
        ArrayList<Refriderated> list = new ArrayList<Refriderated>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Refriderated>>() {});
        return list;
    }
    public static ArrayList<Liquid> ReadLiquidFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("liquid.json");
        ArrayList<Liquid> list = new ArrayList<Liquid>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Liquid>>() {});
        return list;
    }


    public static ArrayList<Trip> ReadTripFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("trip.json");
        ArrayList<Trip> list = new ArrayList<Trip>();
        list = mapper.readValue(file, new TypeReference<ArrayList<Trip>>() {});
        return list;
    }
    public static ArrayList<PortManager> ReadManagerFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("portmanager.json");
        ArrayList<PortManager> list = new ArrayList<PortManager>();
        list = mapper.readValue(file, new TypeReference<ArrayList<PortManager>>() {});
        return list;
    }

    public static ArrayList<SystemAdmin> ReadAdminFromFile() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File("systemadmin.json");
        ArrayList<SystemAdmin> list = new ArrayList<SystemAdmin>();
        list = mapper.readValue(file, new TypeReference<ArrayList<SystemAdmin>>() {});
        return list;
    }

    public static void InputObjectIntoFile(Object object, String filename) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(filename);
        if (file.exists() ){
            ArrayList<Object> list2 = FileIOUtil.ReadObjectFromFile(filename);
            list2.add(object);
            mapper.writeValue(file, list2);
        }
        else {
            ArrayList<Object> list = new ArrayList<Object>();
            list.add(object);
            mapper.writeValue(file, list);
        }
    }
    //------------------------------------------Update Method-------------------------------------------//

    public static void updatePortFromFile(Port port) throws IOException {
        File file = new File("port.json");
        ArrayList<Port> list = FileIOUtil.ReadPortFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(port)){
                list.set(i, port);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }
    public static void updateTripFromFile(Trip trip) throws IOException {
        File file = new File("trip.json");
        ArrayList<Trip> list = FileIOUtil.ReadTripFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(trip)){
                list.set(i, trip);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void updateManagerFromFile(PortManager manager) throws IOException {
        File file = new File("Portmanager.json");
        ArrayList<PortManager> list = FileIOUtil.ReadManagerFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(manager)){
                list.set(i, manager);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void updateAdminFromFile(SystemAdmin admin) throws IOException {
        File file = new File("systemadmin.json");
        ArrayList<SystemAdmin> list = FileIOUtil.ReadAdminFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(admin)){
                list.set(i, admin);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }


    public static void updateVehicleFromFile(Object object) throws IOException {
        if (object instanceof ship){
            File file = new File("VehicleClasses.ship.json");
            ArrayList<ship> list = FileIOUtil.ReadShipFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((ship) object)){
                    list.set(i, (ship) object);
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);

        }
        else if (object instanceof basictruck){
            File file = new File("VehicleClasses.basictruck.json");
            ArrayList<basictruck> list = FileIOUtil.ReadBasicTruckFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((basictruck) object)){
                    list.set(i, (basictruck) object);
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof reefertruck){
            File file = new File("VehicleClasses.reefertruck.json");
            ArrayList<reefertruck> list = FileIOUtil.ReadReeferFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((reefertruck) object)){
                    list.set(i, (reefertruck) object);
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof tankertruck){
            File file = new File("VehicleClasses.tankertruck.json");
            ArrayList<tankertruck> list = FileIOUtil.ReadTankerFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((tankertruck) object)){
                    list.set(i, (tankertruck) object);
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }

    }
    public static void updateContainerFromFile(Object object) throws IOException {
        if (object instanceof DryStorage){
            File file = new File("drystorage.json");
            ArrayList<DryStorage> list = FileIOUtil.ReadDryStorageFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((DryStorage) object)){
                    list.set(i, (DryStorage) object);
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);

        }
        else if (object instanceof OpenTop){
            File file = new File("opentop.json");
            ArrayList<OpenTop> list = FileIOUtil.ReadOpenTopFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((OpenTop) object)){
                    list.set(i, (OpenTop) object);
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof OpenSide){
            File file = new File("openside.json");
            ArrayList<OpenSide> list = FileIOUtil.ReadOpenSideFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((OpenSide) object)){
                    list.set(i, (OpenSide) object);
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof Refriderated){
            File file = new File("refridgerated.json");
            ArrayList<Refriderated> list = FileIOUtil.ReadRefridgeratedFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((Refriderated) object)){
                    list.set(i, (Refriderated) object);
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else {
            File file = new File("liquid.json");
            ArrayList<Liquid> list = FileIOUtil.ReadLiquidFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((Liquid) object)){
                    list.set(i, (Liquid) object);
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }

    }

//----------------------------------------------Remove Methods-----------------------------------------------//

    public static void removePortFromFile(Port port) throws IOException {
        File file = new File("port.json");
        ArrayList<Port> list = FileIOUtil.ReadPortFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(port)){
                list.remove(list.get(i));
                break;
            }
        }
        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void removeManagerFromFile(PortManager manager) throws IOException {
        File file = new File("Portmanager.json");
        ArrayList<PortManager> list = FileIOUtil.ReadManagerFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(manager)){
                list.remove(manager);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void removeAdminFromFile(SystemAdmin admin) throws IOException {
        File file = new File("systemadmin.json");
        ArrayList<SystemAdmin> list = FileIOUtil.ReadAdminFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(admin)){
                list.remove(admin);
                break;
            }
        }

        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void removeTripFromFile(Trip trip) throws IOException {
        File file = new File("port.json");
        ArrayList<Trip> list = FileIOUtil.ReadTripFromFile();
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).equals(trip)){
                list.remove(list.get(i));
                break;
            }
        }
        file.delete();
        file.createNewFile();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, list);

    }

    public static void removeVehicleFromFile(Object object) throws IOException {
        if (object instanceof ship){
            File file = new File("VehicleClasses.ship.json");
            ArrayList<ship> list = FileIOUtil.ReadShipFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((ship) object)){
                    list.remove(list.get(i));
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);

        }
        else if (object instanceof basictruck){
            File file = new File("VehicleClasses.basictruck.json");
            ArrayList<basictruck> list = FileIOUtil.ReadBasicTruckFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((basictruck) object)){
                    list.remove(list.get(i));
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof reefertruck){
            File file = new File("VehicleClasses.reefertruck.json");
            ArrayList<reefertruck> list = FileIOUtil.ReadReeferFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((reefertruck) object)){
                    list.remove(list.get(i));
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof tankertruck){
            File file = new File("VehicleClasses.tankertruck.json");
            ArrayList<tankertruck> list = FileIOUtil.ReadTankerFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((tankertruck) object)){
                    list.remove(list.get(i));
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }

    }

    public static void removeContainerFromFile(Object object) throws IOException {
        if (object instanceof DryStorage){
            File file = new File("drystorage.json");
            ArrayList<DryStorage> list = FileIOUtil.ReadDryStorageFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((DryStorage) object)){
                    list.remove(list.get(i));
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);

        }
        else if (object instanceof OpenTop){
            File file = new File("opentop.json");
            ArrayList<OpenTop> list = FileIOUtil.ReadOpenTopFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((OpenTop) object)){
                    list.remove(list.get(i));
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof OpenSide){
            File file = new File("openside.json");
            ArrayList<OpenSide> list = FileIOUtil.ReadOpenSideFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((OpenSide) object)){
                    list.remove(list.get(i));
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else if (object instanceof Refriderated){
            File file = new File("refridgerated.json");
            ArrayList<Refriderated> list = FileIOUtil.ReadRefridgeratedFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((Refriderated) object)){
                    list.remove(list.get(i));
                    break;
                }
            }

            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }
        else {
            File file = new File("liquid.json");
            ArrayList<Liquid> list = FileIOUtil.ReadLiquidFromFile();
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).equals((Liquid) object)){
                    list.remove(list.get(i));
                    break;
                }
            }
            file.delete();
            file.createNewFile();
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(file, list);
        }

    }

    public static void InputObjecesOnsite(int i) {
    }

    public static OpenSide[] ReadOpenSideFromFile() {
        return new OpenSide[0];
    }
}






