package round.robin.alogo.loadbalancer;

import java.util.ArrayList;

public class HandlerLoadBalancerApp {
	public static void main(String[] args) {
		ArrayList<Server> al = new ArrayList<Server>();
		Server serverA = new Server("A"); 
		Server serverB = new Server("B"); 
		Server serverC = new Server("C"); 
		al.add(serverA);
		al.add(serverB);
		al.add(serverC);
		
		LoadBalancer lb = new LoadBalancer(al);
		
		for(int i=0; i<=15; i++) {
			lb.distributeLoad(i);
		}
	}
}
