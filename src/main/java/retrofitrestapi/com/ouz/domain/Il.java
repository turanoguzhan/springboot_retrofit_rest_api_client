package retrofitrestapi.com.ouz.domain;

import java.io.Serializable;

public class Il implements Serializable{
	
	int ID;
	String NAME;
	int PARENT_ID;
	double minlongitude;
	double minlatitude;
	double maxlongitude;
	double maxlatitude;
	
	public Il() {
		super();
	}
	
	public Il(int iD, String nAME, int pARENT_ID, double minlongitude, double minlatitude, double maxlongitude,
			double maxlatitude) {
		super();
		ID = iD;
		NAME = nAME;
		PARENT_ID = pARENT_ID;
		this.minlongitude = minlongitude;
		this.minlatitude = minlatitude;
		this.maxlongitude = maxlongitude;
		this.maxlatitude = maxlatitude;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String nAME) {
		NAME = nAME;
	}
	public int getPARENT_ID() {
		return PARENT_ID;
	}
	public void setPARENT_ID(int pARENT_ID) {
		PARENT_ID = pARENT_ID;
	}
	public double getMinlongitude() {
		return minlongitude;
	}
	public void setMinlongitude(double minlongitude) {
		this.minlongitude = minlongitude;
	}
	public double getMinlatitude() {
		return minlatitude;
	}
	public void setMinlatitude(double minlatitude) {
		this.minlatitude = minlatitude;
	}
	public double getMaxlongitude() {
		return maxlongitude;
	}
	public void setMaxlongitude(double maxlongitude) {
		this.maxlongitude = maxlongitude;
	}
	public double getMaxlatitude() {
		return maxlatitude;
	}
	public void setMaxlatitude(double maxlatitude) {
		this.maxlatitude = maxlatitude;
	}
	@Override
	public String toString() {
		return "Il [ID=" + ID + ", NAME=" + NAME + ", PARENT_ID=" + PARENT_ID + ", minlongitude=" + minlongitude
				+ ", minlatitude=" + minlatitude + ", maxlongitude=" + maxlongitude + ", maxlatitude=" + maxlatitude
				+ "]";
	}
	
	

}
