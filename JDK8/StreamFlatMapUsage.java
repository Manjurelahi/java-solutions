import java.util.*;
import java.util.stream.*;

class State {
	String name;
	List<String> popularCities = new ArrayList<>();
	
	public State(String name, List<String> popularCities) {
		this.name = name;
		this.popularCities = popularCities;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getPopularCities() {
		return this.popularCities;
	}
	
	public void setPopularCities(List<String> popularCities) {
		this.popularCities = popularCities;
	}	
}

public class StreamFlatMapUsage {
	public static void main(String[] args) {
		State mh = new State("Maharashtra", Arrays.asList("Mumbai", "Pune"));
		State up = new State("Uttar Pradesh", Arrays.asList("Lucknow", "Kanpur", "Banaras"));
		
		Arrays.asList(mh, up).stream().flatMap(state -> state.getPopularCities().stream())
			.forEach(System.out::println);
	}
}

/*
Mumbai
Pune
Lucknow
Kanpur
Banaras
*/