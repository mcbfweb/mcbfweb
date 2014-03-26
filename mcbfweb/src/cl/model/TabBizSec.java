package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Service;


@Entity( name = "TABBIZSECM0" )
@Service
public class TabBizSec {
	
	@Id	
	@Column(name = "BIZCODE")
	String bizCode;
	
	@Column(name = "BIZDESC") 
	String bizDesc;
	
	@Column(name = "BIZSDESC")
    String bizSDesc;
	
	@Column(name = "BIZECOCDE")
    String bizEcoCde;
	
	@Column(name = "BIZCRTDT")
    Date bizCrtDt;
    	
	@Column(name = "BIZCRTUSR") 
	String bizCrtUsr;
	
	@Column(name = "BIZCHGDT")
    Date bizChgDt;
    
	@Column(name = "BIZCHGUSR") 
	String bizChgUsr;

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
	}

	public String getBizDesc() {
		return bizDesc;
	}

	public void setBizDesc(String bizDesc) {
		this.bizDesc = bizDesc;
	}

	public String getBizSDesc() {
		return bizSDesc;
	}

	public void setBizSDesc(String bizSDesc) {
		this.bizSDesc = bizSDesc;
	}
	
		
    public String getBizEcoCde() {
		return bizEcoCde;
	}

	public void setBizEcoCde(String bizEcoCde) {
		this.bizEcoCde = bizEcoCde;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getBizCrtDt() {
		return bizCrtDt;
	}

	public void setBizCrtDt(Date bizCrtDt) {
		this.bizCrtDt = bizCrtDt;
	}

	public String getBizCrtUsr() {
		return bizCrtUsr;
	}

	public void setBizCrtUsr(String bizCrtUsr) {
		this.bizCrtUsr = bizCrtUsr;
	}
    @Temporal(TemporalType.TIMESTAMP)
	public Date getBizChgDt() {
		return bizChgDt;
	}

	public void setBizChgDt(Date bizChgDt) {
		this.bizChgDt = bizChgDt;
	}

	public String getBizChgUsr() {
		return bizChgUsr;
	}

	public void setBizChgUsr(String bizChgUsr) {
		this.bizChgUsr = bizChgUsr;
	}	
	
	
	
}

