package round.robin.alogo.loadbalancer.weighted;

import java.util.ArrayList;

public class HandleWeightedRoundRobinLB {
	//Q: Design a program for Weighted Round Robin Algorithm
	public static void main(String[] args) {
		int currentIndex=0;
		ArrayList<Server> al = new ArrayList<Server>();
		Server s1 = new Server("Server A", 3);
		Server s2 = new Server("Server B", 2);
		Server s3 = new Server("Server C", 1);
//		Server s4 = new Server("Server D", 5);
		al.add(s1);
		al.add(s2);
		al.add(s3);
//		al.add(s4);
		
		LoadBalancer lb = new LoadBalancer(al);
		
		for(int i=0; i<15;) {
			Server s = al.get(currentIndex);
			for(int j=0; j<s.getWeight();j++) {
				if(i<15)
					lb.distributeLoad(s, i++);
			}
			currentIndex=(currentIndex+1)%al.size();
		}
	}
}
