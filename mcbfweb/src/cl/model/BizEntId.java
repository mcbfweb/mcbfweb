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

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Entity
@Table(name = "BIZENTIDM0")
@Service
public class BizEntId implements java.io.Serializable {

	@Id  
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDDATID", unique = true, nullable = false)	
	private Integer datid;

	@Column(name = "IDENTITY")
	private Integer entity;

	@Column(name = "IDCTRY")
	private String idCtry;
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

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "IDENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntId() {
		super();
	}

	public BizEntId(Integer datid, Integer entity, String idTyp, String idCode, Date crtDate, String crtByUser, Date chgDate,
			String chgByUser, Integer version, EntityDetail entitydetail) {
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

	public BizEntId(Integer entity, String idTyp, String idCode, String idCtry) {

		this.entity = entity;
		this.idTyp = idTyp;
		this.idCode = idCode;
		this.idCtry = idCtry;

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

	public String getIdCtry() {
		return idCtry;
	}

	public void setIdCtry(String idCtry) {
		this.idCtry = idCtry;
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