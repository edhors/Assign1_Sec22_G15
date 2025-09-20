class MealAdvice {
	
	private double bodymass;
	private double height;
	private double BMI;
	
	public MealAdvice(double bodymass,double height) {
		
		this.bodymass = bodymass;
		
		this.height	= height;
	}
	
	public double getMass() {
		
		return bodymass;
	}
	
	public double getHeight() {
		
		return height;
	}
	
	public void setMass(double m) {
		
		if (m <= 0) throw new IllegalArgumentException("Weight must be > 0");
		
		this.bodymass = m;
	}
	
	public void setHeight(double h) {
		
		if (h <= 0) throw new IllegalArgumentException("Height must be > 0");
		
		this.height = h;
	}
	
	public void setBMI() {
		
		this.BMI = bodymass / Math.pow(height,2);
	}
	
	public double getBMI() {
		
		return this.BMI;
	}
	
	public String getAdvice() {
		
		if (this.BMI < 18.5) return "Underweight. Enhance your mealplan by adding more calories and daily exercises.";
		
        if (this.BMI < 25.0) return "Normal. Maintain a balanced diet and regular activity.";
        
        if (this.BMI < 30.0) return "Overweight. Create a mild calorie deficit. Set a priority to protein and fiber. Add more dayli activity.";
        
        if (this.BMI < 35.0) return "Obesity I. Focus on a structured calorie deficit, strength + cardio , 3 times a week. ";
        
        if (this.BMI < 40.0) return "Obesity II. Choose a high-protein meal. Walk more and add dayly exercises to avoid health problems";
        
        return "Obesity III. Seek a professional-guided program; combine nutrition therap  and medical support where appropriate.";
		
		
	}
	

}

