package round.robin.alogo.loadbalancer;

public class Server {
	
	private String name;
	
	public Server(String name) {
		this.name=name;
	}
	
	public void handleRequest(int requestId) {
		System.out.println("Server"+name+" is currently handling the request "+requestId);
	}
}
