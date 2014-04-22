package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;


@Entity( name = "TABSTATEM0" )
@Service
public class TabState {
	
	@Id	
	@Column(name = "STADATID",unique = true, nullable = false)
	private int datid;	
	
	@Column(name = "STACTRY")
	String staCtry;
	
	@Column(name = "STACDE") 
	String staCde;
	
	@Column(name = "STANAME")
    String staName;
	
	@Column(name = "STAGEOID")
    int staGeoId;
    
	@Column(name = "STACRTDT")
    Date staCrtDt;
	
	@Column(name = "STACRTUSR") 
	String staCrtUsr;
	
	@Column(name = "STACHGDT")
    Date staChgDt;
    
	@Column(name = "STACHGUSR") 
	String staChgUsr;

	public int getDatid() {
		return datid;
	}

	public void setDatid(int datid) {
		this.datid = datid;
	}

	public String getStaCtry() {
		return staCtry;
	}

	public void setStaCtry(String staCtry) {
		this.staCtry = staCtry;
	}

	public String getStaCde() {
		return staCde;
	}

	public void setStaCde(String staCde) {
		this.staCde = staCde;
	}

	public String getStaName() {
		return staName;
	}

	public void setStaName(String staName) {
		this.staName = staName;
	}

	

	public int getStaGeoId() {
		return staGeoId;
	}

	public void setStaGeoId(int staGeoId) {
		this.staGeoId = staGeoId;
	}

	public Date getStaCrtDt() {
		return staCrtDt;
	}

	public void setStaCrtDt(Date staCrtDt) {
		this.staCrtDt = staCrtDt;
	}

	public String getStaCrtUsr() {
		return staCrtUsr;
	}

	public void setStaCrtUsr(String staCrtUsr) {
		this.staCrtUsr = staCrtUsr;
	}

	public Date getStaChgDt() {
		return staChgDt;
	}

	public void setStaChgDt(Date staChgDt) {
		this.staChgDt = staChgDt;
	}

	public String getStaChgUsr() {
		return staChgUsr;
	}

	public void setStaChgUsr(String staChgUsr) {
		this.staChgUsr = staChgUsr;
	}

	
	
}

