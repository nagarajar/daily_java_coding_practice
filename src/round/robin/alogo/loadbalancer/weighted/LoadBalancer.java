package round.robin.alogo.loadbalancer.weighted;

import java.util.ArrayList;

public class LoadBalancer {
	
	private ArrayList<Server> al;
	
	public LoadBalancer(ArrayList<Server> al) {
		this.al=al;
	}
	
	public void distributeLoad(Server s, int requestId) {
		s.handleRequest(requestId);
	}
	
}
