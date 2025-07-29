package round.robin.alogo.loadbalancer;

import java.util.ArrayList;

public class LoadBalancer {
	
	private ArrayList<Server> al;
	private int currentIndex = 0;
	
	public LoadBalancer(ArrayList<Server> al) {
		this.al = al;
	}
	
	public void distributeLoad(int requestId) {
		Server s = al.get(currentIndex);
		s.handleRequest(requestId);
		currentIndex = (currentIndex+1)%al.size(); //Imp logic for round robin
	}
}
