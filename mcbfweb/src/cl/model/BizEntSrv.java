package cl.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Entity
@Table(name = "BIZENTSRVM0")
@Service
public class BizEntSrv implements java.io.Serializable {

	@Id  
	@Column(name = "SRVDATID", unique = true, nullable = false)	
	private Integer datid;

	@Column(name = "SRVENTITY")
	private Integer entity;
	@Column(name = "SRVNAME")
	private String srvName;	
	@Column(name = "SRVCRTDT")
	private Date crtDate;;
	@Column(name = "SRVCRTUSR")
	private String crtByUser;
	@Column(name = "SRVCHGDT")
	private Date chgDate;
	@Column(name = "SRVCHGUSR")
	private String chgByUser;
	@Column(name = "SRVVERSION")
	private Integer version;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "SRVENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntSrv() {
     super();
	}

	
	public BizEntSrv(Integer datid, Integer entity, String srvName, Date crtDate, String crtByUser, Date chgDate,
			String chgByUser, Integer version, EntityDetail entitydetail) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.srvName = srvName;
		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
		this.entitydetail = entitydetail;
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

	

	public String getSrvName() {
		return srvName;
	}


	public void setSrvName(String srvName) {
		this.srvName = srvName;
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