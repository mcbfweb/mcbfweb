package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;


@Entity( name = "TABECOSECM0" )
@Service
public class TabEcoSec {
	
	@Id	
	@Column(name = "ECOCODE")
	String ecoCode;
	
	@Column(name = "ECODESC") 
	String ecoDesc;
	
	@Column(name = "ECOSDESC")
    String ecoSDesc;
	
	@Column(name = "ECOCRTDT")
    Date ecoCrtDt;
    	
	@Column(name = "ECOCRTUSR") 
	String ecoCrtUsr;
	
	@Column(name = "ECOCHGDT")
    Date ecoChgDt;
    
	@Column(name = "ECOCHGUSR") 
	String ecoChgUsr;

	public String getEcoCode() {
		return ecoCode;
	}

	public void setEcoCode(String ecoCode) {
		this.ecoCode = ecoCode;
	}

	public String getEcoDesc() {
		return ecoDesc;
	}

	public void setEcoDesc(String ecoDesc) {
		this.ecoDesc = ecoDesc;
	}

	public String getEcoSDesc() {
		return ecoSDesc;
	}

	public void setEcoSDesc(String ecoSDesc) {
		this.ecoSDesc = ecoSDesc;
	}
    @Temporal(TemporalType.TIMESTAMP)
	public Date getEcoCrtDt() {
		return ecoCrtDt;
	}

	public void setEcoCrtDt(Date ecoCrtDt) {
		this.ecoCrtDt = ecoCrtDt;
	}

	public String getEcoCrtUsr() {
		return ecoCrtUsr;
	}

	public void setEcoCrtUsr(String ecoCrtUsr) {
		this.ecoCrtUsr = ecoCrtUsr;
	}
    @Temporal(TemporalType.TIMESTAMP)
	public Date getEcoChgDt() {
		return ecoChgDt;
	}

	public void setEcoChgDt(Date ecoChgDt) {
		this.ecoChgDt = ecoChgDt;
	}

	public String getEcoChgUsr() {
		return ecoChgUsr;
	}

	public void setEcoChgUsr(String ecoChgUsr) {
		this.ecoChgUsr = ecoChgUsr;
	}	
	
	
	
}

