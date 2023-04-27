import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;
//public class server extends UnicastRemoteObject implements Adder{
public class server extends UnicastRemoteObject {

    protected server() throws RemoteException {
        super();
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(5555);
//            reg.bind("AddService", new server());
            reg.rebind("ServerFunctions", new ServerFunctions());
            System.out.println("ServerFunction is connected....");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    protected server(int port) throws RemoteException {
        super(port);
    }

    protected server(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf) throws RemoteException {
        super(port, csf, ssf);
    }
//    Adder adder = new AdderImpl();

//    public int add(int n1, int n2) throws RemoteException {
//        return adder.add(n1, n2);
//    }

    public static void main(String[] args) {
//    public void main() {
        Registry reg = null;
        try {
            reg = LocateRegistry.createRegistry(4444);
//            reg.bind("AddService", new server());
            reg.rebind("AddService", new AdderImpl());
            System.out.println("Server is ready....");
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }

    }

