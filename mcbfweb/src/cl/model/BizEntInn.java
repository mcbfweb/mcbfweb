package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@Entity(name = "BIZENTINNM0")
@Service
public class BizEntInn {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "INNDATID")
	private int datid;

	@Column(name = "INNENTITY")
	private int entity;

	@Column(name = "INNTYP")
	String type;

	@Column(name = "INNFNAME")
	private String fName;

	@Column(name = "INNSNAME")
	private String sName;

	@Column(name = "INNLNAME")
	private String lName;

	@Column(name = "INNUNAME")
	private String uName;

	@Column(name = "INNBNAME")
	private String bName;

	@Version
	@Column(name = "INNCRTDT")
	private Date crtDate;;
	@Column(name = "INNCRTUSR")
	private String crtByUser;
	@Version
	@Column(name = "INNCHGDT")
	private Date chgDate;;
	@Column(name = "INNCHGUSR")
	private String chgByUser;
	@Column(name = "INNVERSION")
	private Integer version;

	

	public BizEntInn() {

	}


	public BizEntInn(int entity, String type, String fName, String sName, String lName, String uName, String bName) {

		this.entity = entity;
		this.type = type;
		this.fName = fName;
		this.sName = sName;
		this.lName = lName;
		this.uName = uName;
		this.bName = bName;
	}
	
	
	

	public int getDatid() {
		return datid;
	}

	public void setDatid(int datid) {
		this.datid = datid;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getbName() {
		return bName;
	}

	public void setbName(String bName) {
		this.bName = bName;
	}

	public Date getCrtDate() {
		return crtDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}

	public String getCrtByUser() {
		return crtByUser;
	}

	public void setCrtByUser(String crtByUser) {
		this.crtByUser = crtByUser;
	}

	public Date getChgDate() {
		return chgDate;
	}

	public void setChgDate(Date chgDate) {
		this.chgDate = chgDate;
	}

	public String getChgByUser() {
		return chgByUser;
	}

	public void setChgByUser(String chgByUser) {
		this.chgByUser = chgByUser;
	}


	public Integer getVersion() {
		return version;
	}


	public void setVersion(Integer version) {
		this.version = version;
	}

	

}