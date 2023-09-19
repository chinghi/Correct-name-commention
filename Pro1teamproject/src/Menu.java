import Users.PortManager;
import Users.Port_Manager;
import Users.SystemAdmin;
import java.io.IOException;
import java.util.Scanner;

public class Menu {

    public static void program_Run() throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Who do you want to login as?\na: Port Manger\nb: System Admin");
            String selection = scanner.nextLine();
            if (selection.equalsIgnoreCase("a")){
                Port_Manager port_manager = Port_Manager.login();
                Portmanteaurun(port_manager, false);

            }
            else if (selection.equalsIgnoreCase("b")){
                SystemAdmin.login();
                Admin_run(false);
            }
            else{
                System.out.println("Option does not exist. Please try again");
            }
        }


    }
    public static boolean Admin_run(boolean _exit) throws IOException {
        if (_exit) {
            System.out.println("Quiting application");
            return true;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("What would you like to do?\na: add Manager\nb: add Port.Port\nc: add Vehicle_Classes.Vehicle\nd: add Container_Class.Container\ne: view manager\nf: view ports\ng: view vehicles\nh: view containers\ni: update manager info\nj: update port info\nk: update vehicle info\nl: update container info\nm: remove manager\nn: remove port\no: remove vehicle\np: remove container\ns: view trip\nt: add System Admin\nu: view System Admin\nv: update System Admin\nw: remove System Admin\nq: quit");
        String selection = scanner.nextLine();
        if (selection.equalsIgnoreCase("a")) {
            SystemAdmin.addManager();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("b")) {
            SystemAdmin.addPort();
            System.out.println("Press 1 to return to the menu and 0 to quit the application");
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("c")) {
            SystemAdmin.addVehicle();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("d")) {
            SystemAdmin.addContainer();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        } else if (selection.equalsIgnoreCase("e")) {
            SystemAdmin.viewManager();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        } else if (selection.equalsIgnoreCase("f")) {
            SystemAdmin.viewPort();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        } else if (selection.equalsIgnoreCase("g")) {
            SystemAdmin.viewVehicle();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("h")) {
            SystemAdmin.viewContainers();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("i")) {
            SystemAdmin.updateManager();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        } else if (selection.equalsIgnoreCase("j")) {
            SystemAdmin.updatePort();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("k")) {
            SystemAdmin.updateVehicle();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("l")) {
            SystemAdmin.updateContainer();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("m")) {
            SystemAdmin.removeManager();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("n")) {
            SystemAdmin.removePort();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("o")) {
            SystemAdmin.removeVehicle();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }

        else if (selection.equalsIgnoreCase("p")) {
            SystemAdmin.removeContainer();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if(selection.equalsIgnoreCase("s")){
            SystemAdmin.viewAllTrips();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if(selection.equalsIgnoreCase("w")){
            SystemAdmin.removeSystem_Admin();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if(selection.equalsIgnoreCase("t")){
            SystemAdmin.addSystemAdmin();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if(selection.equalsIgnoreCase("u")){
            SystemAdmin.viewAdmin();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if(selection.equalsIgnoreCase("v")){
            SystemAdmin.updateAdmin();
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if (selection.equalsIgnoreCase("q")){
            return Admin_run(true);
        }
        else {
            System.out.println("Option does not exist.");
            while (true) {
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")) {
                    return Admin_run(false);
                } else if (_quit.equalsIgnoreCase("q")) {
                    return Admin_run(true);
                } else {
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
    }






    public static boolean PortManteaurun(PortManager manager, boolean _exit) throws IOException {
        if (_exit){
            System.out.println("Quiting application");
            return true;
        }
        Scanner scanner = new Scanner(System.in);


        System.out.println("What would you like to do?\na: Commence Container_Class.Open_Top.Trip.Trip\nb: Complete Container_Class.Open_Top.Trip.Trip\nc: Loading Containers on Vehicle_Classes.Vehicle\nd: Loading Containers off Vehicle_Classes.Vehicle\ne: Incoming Trips Query\nf: Outgoing Trips Query\ng: Registering Trips\nt: update trip\nu: remove trip\nq: quit" );
        String selection = scanner.nextLine();
        if (selection.equalsIgnoreCase("a")){
            manager.commenceTrip();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if (selection.equalsIgnoreCase("b")){
            manager.completeTrip();
            System.out.println("Press 1 to return to the menu and 0 to quit the application");
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        }
        else if (selection.equalsIgnoreCase("c")){
            manager.loadingContainersonVehicle();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        }
        else if (selection.equalsIgnoreCase("d")){
            manager.loadingContaineroffVehicle();
            System.out.println("Press 1 to return to the menu and 0 to quit the application");
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        }
        else if (selection.equalsIgnoreCase("e")){
            manager.incomingTrip_query();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        }
        else if (selection.equalsIgnoreCase("f")) {
            manager.outgoingTrip_query();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        }
        else if (selection.equalsIgnoreCase("g")) {
            manager.RegisteringTrip();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("t")) {
            manager.updateTrip();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }

        } else if (selection.equalsIgnoreCase("u")) {
            manager.removeTrip();
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }



        } else if (selection.equalsIgnoreCase("q")) {
            return Portmanteaurun(manager, true);

        }
        else{
            while (true){
                System.out.println("Press r to return to the menu and q to quit the application");
                String _quit = scanner.nextLine();
                if (_quit.equalsIgnoreCase("r")){
                    return Portmanteaurun(manager, false);
                }
                else if (_quit.equalsIgnoreCase("q")) {
                    return Portmanteaurun(manager, true);
                }
                else{
                    System.out.println("Option does not exit. Please choose again");
                }
            }
        }

    }
}
