package stexjy.plants.plants;

public enum PlantsType {
	
	HIBISCUS("Hibiscus");
	
	String name;
	
	PlantsType(String name){
		
		this.name = name;
		
	}
	
	public static boolean exists(String type) {
		
		try {
			
			PlantsType.valueOf(type);
			
			return true;
			
		}catch(IllegalArgumentException exc) {}
		
		return false;
		
	}
	
	public String getName() {
		
		return name;
		
	}
	
}
