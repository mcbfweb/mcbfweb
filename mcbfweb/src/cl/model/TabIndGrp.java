package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;


@Entity( name = "TABINDGRPM0" )
@Service
public class TabIndGrp {
	
	@Id	
	@Column(name = "GRPCODE")
	String grpCode;
	
	@Column(name = "GRPDESC") 
	String grpDesc;
	
	@Column(name = "GRPSDESC")
    String grpSDesc;
	
	@Column(name = "GRPBIZCDE")
    String grpBizCde;
	
	@Column(name = "GRPCRTDT")
    Date grpCrtDt;
    	
	@Column(name = "GRPCRTUSR") 
	String grpCrtUsr;
	
	@Column(name = "GRPCHGDT")
    Date grpChgDt;
    
	@Column(name = "GRPCHGUSR") 
	String grpChgUsr;

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getGrpDesc() {
		return grpDesc;
	}

	public void setGrpDesc(String grpDesc) {
		this.grpDesc = grpDesc;
	}

	public String getGrpSDesc() {
		return grpSDesc;
	}

	public void setGrpSDesc(String grpSDesc) {
		this.grpSDesc = grpSDesc;
	}

	public String getGrpBizCde() {
		return grpBizCde;
	}

	public void setGrpBizCde(String grpBizCde) {
		this.grpBizCde = grpBizCde;
	}

	public Date getGrpCrtDt() {
		return grpCrtDt;
	}

	public void setGrpCrtDt(Date grpCrtDt) {
		this.grpCrtDt = grpCrtDt;
	}

	public String getGrpCrtUsr() {
		return grpCrtUsr;
	}

	public void setGrpCrtUsr(String grpCrtUsr) {
		this.grpCrtUsr = grpCrtUsr;
	}

	public Date getGrpChgDt() {
		return grpChgDt;
	}

	public void setGrpChgDt(Date grpChgDt) {
		this.grpChgDt = grpChgDt;
	}

	public String getGrpChgUsr() {
		return grpChgUsr;
	}

	public void setGrpChgUsr(String grpChgUsr) {
		this.grpChgUsr = grpChgUsr;
	}

	
	
	
}

