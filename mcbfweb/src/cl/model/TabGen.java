package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Service;


@Entity( name = "TABGENM0" )
@Service
public class TabGen {
		
	@Column(name = "GENDEFTYP")
	String genDefTyp;
	
	@Column(name = "GENCODID") 
	String genCodId;
	
	@Column(name = "GENDESC")
    String genDesc;
	
	@Column(name = "GENSDESC")
    String genSDesc;
	
	@Column(name = "GENVWSEQ")
    String genVwSeq;
	
	@Id
	@Column(name = "GENDATID")
    String genDatid;
	
	@Column(name = "GENCRTDT")
    Date genCrtDt;
    	
	@Column(name = "GENCRTUSR") 
	String genCrtUsr;
	
	@Column(name = "GENCHGDT")
    Date genChgDt;
    
	@Column(name = "GENCHGUSR") 
	String genChgUsr;

	public String getGenDefTyp() {
		return genDefTyp;
	}

	public void setGenDefTyp(String genDefTyp) {
		this.genDefTyp = genDefTyp;
	}

	public String getGenCodId() {
		return genCodId;
	}

	public void setGenCodId(String genCodId) {
		this.genCodId = genCodId;
	}

	public String getGenDesc() {
		return genDesc;
	}

	public void setGenDesc(String genDesc) {
		this.genDesc = genDesc;
	}

	public String getGenSDesc() {
		return genSDesc;
	}

	public void setGenSDesc(String genSDesc) {
		this.genSDesc = genSDesc;
	}

	public String getGenVwSeq() {
		return genVwSeq;
	}

	public void setGenVwSeq(String genVwSeq) {
		this.genVwSeq = genVwSeq;
	}

	public Date getGenCrtDt() {
		return genCrtDt;
	}

	public void setGenCrtDt(Date genCrtDt) {
		this.genCrtDt = genCrtDt;
	}

	public String getGenCrtUsr() {
		return genCrtUsr;
	}

	public void setGenCrtUsr(String genCrtUsr) {
		this.genCrtUsr = genCrtUsr;
	}

	public Date getGenChgDt() {
		return genChgDt;
	}

	public void setGenChgDt(Date genChgDt) {
		this.genChgDt = genChgDt;
	}

	public String getGenChgUsr() {
		return genChgUsr;
	}

	public void setGenChgUsr(String genChgUsr) {
		this.genChgUsr = genChgUsr;
	}

	public String getGenDatid() {
		return genDatid;
	}

	public void setGenDatid(String genDatid) {
		this.genDatid = genDatid;
	}

	
	
	
	
	
}

