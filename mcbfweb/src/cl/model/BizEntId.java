package cl.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Entity
@Table(name = "BIZENTIDM0")
@Service
public class BizEntId implements java.io.Serializable{

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")	
	@Column(name = "IDDATID",unique = true, nullable = false)
	private int datid;	
	
	@Column(name = "IDENTITY", unique = true, nullable = false, insertable = false, updatable = false)
	private int entity;	
	@Column(name = "IDIDTYP")
	private String idTyp;

	@Column(name = "IDIDCODE")
	private String idCode;
	
	@Column(name = "IDCRTDT")
	private Date crtDate;;
	@Column(name = "IDCRTUSR")
	private String crtByUser;
	@Column(name = "IDCHGDT")
	private Date chgDate;;
	@Column(name = "IDCHGUSR")
	private String chgByUser;
	@Column(name = "IDVERSION")
	private Integer version;
	
	@ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE} )
	@JoinColumn(name="IDENTITY")
	private EntityDetail entitydetail;
	
	
	
	public BizEntId() {

	}
    
	public BizEntId(int datid, int entity, String idTyp, String idCode,
			Date crtDate, String crtByUser, Date chgDate, String chgByUser,
			Integer version, EntityDetail entitydetail) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.idTyp = idTyp;
		this.idCode = idCode;
		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
		this.entitydetail = entitydetail;
	}

	public BizEntId(int entity, String idTyp, String idCode) {

		this.entity = entity;
		this.idTyp = idTyp;
		this.idCode = idCode;
		
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
	public String getIdTyp() {
		return idTyp;
	}
	public void setIdTyp(String idTyp) {
		this.idTyp = idTyp;
	}
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
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