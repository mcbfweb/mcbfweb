package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

@Entity(name = "TABINDUSTRYM0")
@Service
public class TabIndustry {

	@Id
	@Column(name = "INDCODE")
	String indCode;

	@Column(name = "INDDESC")
	String indDesc;

	@Column(name = "INDSDESC")
	String indSDesc;

	@Column(name = "INDGRPCDE")
	String indGrpCde;

	@Column(name = "INDCRTDT")
	Date indCrtDt;

	@Column(name = "INDCRTUSR")
	String indCrtUsr;

	@Column(name = "INDCHGDT")
	Date indChgDt;

	@Column(name = "INDCHGUSR")
	String indChgUsr;

	public String getIndCode() {
		return indCode;
	}

	public void setIndpCode(String indCode) {
		this.indCode = indCode;
	}

	public String getIndDesc() {
		return indDesc;
	}

	public void setIndDesc(String indDesc) {
		this.indDesc = indDesc;
	}

	public String getIndSDesc() {
		return indSDesc;
	}

	public void setIndSDesc(String indSDesc) {
		this.indSDesc = indSDesc;
	}

	public String getIndGrpCde() {
		return indGrpCde;
	}

	public void setIndGrpCde(String indGrpCde) {
		this.indGrpCde = indGrpCde;
	}

	public Date getIndCrtDt() {
		return indCrtDt;
	}

	public void setIndCrtDt(Date indCrtDt) {
		this.indCrtDt = indCrtDt;
	}

	public String getIndCrtUsr() {
		return indCrtUsr;
	}

	public void setIndCrtUsr(String indCrtUsr) {
		this.indCrtUsr = indCrtUsr;
	}

	public Date getIndChgDt() {
		return indChgDt;
	}

	public void setIndChgDt(Date indChgDt) {
		this.indChgDt = indChgDt;
	}

	public String getIndChgUsr() {
		return indChgUsr;
	}

	public void setIndChgUsr(String indChgUsr) {
		this.indChgUsr = indChgUsr;
	}

}
