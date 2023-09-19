import FileIO.FileIOUtil;
import Port.Port;
import Users.Port_Manager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("port.json")) {
            // Read the JSON file into a list of Port objects
            Type listType = new TypeToken<List<Port>>() {}.getType();
            List<Port> ports = gson.fromJson(reader, listType);

            // Search for the Port with pid "p1"
            Port port = null;
            for (Port p : ports) {
                if (p.getPid().equals("p3")) {
                    port = p;
                    break;
                }
            }

            // If the Port was found, use it to create a Port_Manager object
            if (port != null) {
                Port_Manager new_user= new Port_Manager("e3", "trung202", "365120", "Port Manager", port);

                // Write the Port_Manager object to a new JSON file
                FileIOUtil.InputObjectIntoFile(new_user, "port_manager.json");
                Menu.program_Run();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



//        Vehicle new_vehicle = new Vehicle("sh1","ship");
//        Vehicle new_vehicle = new Vehicle("sh2","ship");
//        Vehicle new_vehicle = new Vehicle("sh3","ship");
//        Vehicle new_vehicle = new Vehicle("sh4","ship");
//        Vehicle new_vehicle = new Vehicle("sh5","ship");
//        Vehicle new_vehicle = new Vehicle("sh6","ship");
//        Vehicle new_vehicle = new Vehicle("sh7","ship");
//        Vehicle new_vehicle = new Vehicle("sh8","ship");
//        Vehicle new_vehicle = new Vehicle("sh9","ship");
//        Vehicle new_vehicle = new Vehicle("sh10","ship");
//        Vehicle new_vehicle = new Vehicle("btr11","basic truck");
//        Vehicle new_vehicle = new Vehicle("btr12","basic truck");
//        Vehicle new_vehicle = new Vehicle("btr13","basic truck");
//        Vehicle new_vehicle = new Vehicle("btr14","basic truck");
//        Vehicle new_vehicle = new Vehicle("rtr15","reefer truck");
//        Vehicle new_vehicle = new Vehicle("rtr16","reefer truck");
//        Vehicle new_vehicle = new Vehicle("rtr17","reefer truck");
//        Vehicle new_vehicle = new Vehicle("ttr18","tanker truck");
//        Vehicle new_vehicle = new Vehicle("ttr19","tanker truck");
//        Vehicle new_vehicle = new Vehicle("ttr20","tanker truck");