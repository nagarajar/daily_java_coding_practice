package round.robin.alogo.loadbalancer.weighted;

public class Server {
	private String name;
	private int weight;
	
	public Server(String name, int weight) {
		this.name=name;
		this.weight=weight;
	}
	
	public void handleRequest(int requestId) {
		System.out.println(this.name + " weighted : "+this.weight+" -> is currently handling request: "+requestId);
	}
	
	public int getWeight() {
		return this.weight;
	}
}
