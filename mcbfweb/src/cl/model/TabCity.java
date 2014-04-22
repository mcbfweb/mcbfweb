package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity(name = "TABCITYM0")
@Service
public class TabCity {

	@Id
	@Column(name = "CTYDATID", unique = true, nullable = false)
	private int datid;

	@Column(name = "CTYCTRY")
	String ctyCtry;

	@Column(name = "CTYSTATE")
	String ctyState;

	@Column(name = "CTYCDE")
	String ctyCde;

	@Column(name = "CTYNAME")
	String ctyName;

	@Column(name = "CTYAREACD")
	String ctyAreaCd;

	@Column(name = "CTYGEOID")
	int ctyGeoId;

	@Column(name = "CTYCRTDT")
	Date ctyCrtDt;

	@Column(name = "CTYCRTUSR")
	String ctyCrtUsr;

	@Column(name = "CTYCHGDT")
	Date ctyChgDt;

	@Column(name = "CTYCHGUSR")
	String ctyChgUsr;

	public int getDatid() {
		return datid;
	}

	public void setDatid(int datid) {
		this.datid = datid;
	}

	public String getCtyCtry() {
		return ctyCtry;
	}

	public void setCtyCtry(String ctyCtry) {
		this.ctyCtry = ctyCtry;
	}

	public String getCtyState() {
		return ctyState;
	}

	public void setCtyState(String ctyState) {
		this.ctyState = ctyState;
	}

	public String getCtyCde() {
		return ctyCde;
	}

	public void setCtyCde(String ctyCde) {
		this.ctyCde = ctyCde;
	}

	public String getCtyName() {
		return ctyName;
	}

	public void setCtyName(String ctyName) {
		this.ctyName = ctyName;
	}

	public String getCtyAreaCd() {
		return ctyAreaCd;
	}

	public void setCtyAreaCd(String ctyAreaCd) {
		this.ctyAreaCd = ctyAreaCd;
	}

	 

	public int getCtyGeoId() {
		return ctyGeoId;
	}

	public void setCtyGeoId(int ctyGeoId) {
		this.ctyGeoId = ctyGeoId;
	}

	public Date getCtyCrtDt() {
		return ctyCrtDt;
	}

	public void setCtyCrtDt(Date ctyCrtDt) {
		this.ctyCrtDt = ctyCrtDt;
	}

	public String getCtyCrtUsr() {
		return ctyCrtUsr;
	}

	public void setCtyCrtUsr(String ctyCrtUsr) {
		this.ctyCrtUsr = ctyCrtUsr;
	}

	public Date getCtyChgDt() {
		return ctyChgDt;
	}

	public void setCtyChgDt(Date ctyChgDt) {
		this.ctyChgDt = ctyChgDt;
	}

	public String getCtyChgUsr() {
		return ctyChgUsr;
	}

	public void setCtyChgUsr(String ctyChgUsr) {
		this.ctyChgUsr = ctyChgUsr;
	}

}
