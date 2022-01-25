package ExerciseOne;

public class TrustReturn {
	private String tan;
	private double pi;
	private double ri;
	private String city;
	private String not;
	private String provience;
	
	
	public TrustReturn(String tan, double pi, double ri, String city, String not, String provience) {
		this.tan = tan;
		this.pi = pi;
		this.ri = ri;
		this.city = city;
		this.not = not;
		this.provience = provience;
	}
	
	public TrustReturn() {
	}

	public String getTan() {
		return tan;
	}
	public void setTan(String tan) {
		this.tan = tan;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public double getRi() {
		return ri;
	}
	public void setRi(double ri) {
		this.ri = ri;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getNot() {
		return not;
	}
	public void setNot(String not) {
		this.not = not;
	}
	public String getProvience() {
		return provience;
	}
	public void setProvience(String provience) {
		this.provience = provience;
	}

	@Override
	public String toString() {
		return "Trust account [tan=" + tan + ", pi=" + pi + ", ri=" + ri + ", city=" + city + ", not=" + not + ", provience="
				+ provience + "]";
	}
	
	public String toWriteFile() {
		return "tan=" + tan + ", pi=" + pi + ", ri=" + ri + ", city=" + city + ", not=" + not + ", provience="
				+ provience;
	}
	
	
}
