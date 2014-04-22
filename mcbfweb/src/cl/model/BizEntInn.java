package cl.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Entity
@Table(name = "BIZENTINNM0")
@Service
public class BizEntInn implements java.io.Serializable{

	@Id  
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "INNDATID", unique = true, nullable = false)
	private Integer datid;

	@Column(name = "INNENTITY")
	private Integer entity;

	@Column(name = "INNTYP")
	String type;

	@Column(name = "INNFNAME")
	private String fstName;

	@Column(name = "INNSNAME")
	private String surName;

	@Column(name = "INNLNAME")
	private String lstName;

	@Column(name = "INNUNAME")
	private String unfName;

	@Column(name = "INNBNAME")
	private String bizName;

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

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "INNENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntInn() {
		super();
	}

	public BizEntInn(Integer datid, Integer entity, String type, String fName, String sName, String lName, String uName,
			String bName, Date crtDate, String crtByUser, Date chgDate, String chgByUser, Integer version,
			EntityDetail entitydetail) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.type = type;
		this.fstName = fName;
		this.surName = sName;
		this.lstName = lName;
		this.unfName = uName;
		this.bizName = bName;
		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
		this.entitydetail = entitydetail;
	}

	public BizEntInn(Integer entity, String type, String fName, String sName, String lName, String uName, String bName) {
		super();
		this.entity = entity;
		this.type = type;
		this.fstName = fName;
		this.surName = sName;
		this.lstName = lName;
		this.unfName = uName;
		this.bizName = bName;
	}

	public Integer getDatid() {
		return datid;
	}

	public void setDatid(Integer datid) {
		this.datid = datid;
	}

	public Integer getEntity() {
		return entity;
	}

	public void setEntity(Integer entity) {
		this.entity = entity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFstName() {
		return fstName;
	}

	public void setFstName(String fstName) {
		this.fstName = fstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getLstName() {
		return lstName;
	}

	public void setLstName(String lstName) {
		this.lstName = lstName;
	}

	public String getUnfName() {
		return unfName;
	}

	public void setUnfName(String unfName) {
		this.unfName = unfName;
	}

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
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

	public EntityDetail getEntitydetail() {
		return entitydetail;
	}

	public void setEntitydetail(EntityDetail entitydetail) {
		this.entitydetail = entitydetail;
	}

}