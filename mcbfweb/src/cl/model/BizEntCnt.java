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
@Table(name = "BIZENTCNTM0")
@Service
public class BizEntCnt implements java.io.Serializable {

	@Id  
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CNTDATID", unique = true, nullable = false)	
	private Integer datid;

	@Column(name = "CNTENTITY")
	private Integer entity;
	@Column(name = "CNTTYP")
	private String cntTyp;

	@Column(name = "CNTNAME")
	private String cntName;
	@Column(name = "CNTPOS")
	private String cntPos;
	@Column(name = "CNTEMAIL")
	private String cntEmail;
	@Column(name = "CNTISDCDE")
	private String cntIsdCde;
	@Column(name = "CNTAREACDE")
	private String cntAreaCde;
	@Column(name = "CNTPHNNO")
	private String cntPhnNo;
	@Column(name = "CNTCRTDT")
	private Date crtDate;;
	@Column(name = "CNTCRTUSR")
	private String crtByUser;
	@Column(name = "CNTCHGDT")
	private Date chgDate;
	@Column(name = "CNTCHGUSR")
	private String chgByUser;
	@Column(name = "CNTVERSION")
	private Integer version;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "CNTENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntCnt() {
     super();
	}

	public BizEntCnt(Integer datid, Integer entity, String cntTyp, String cntName, String cntPos, String cntEmail, String cntIsdCde,
			String cntAreaCde, String cntPhnNo, Date crtDate, String crtByUser, Date chgDate, String chgByUser, Integer version,
			EntityDetail entitydetail) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.cntTyp = cntTyp;
		this.cntName = cntName;
		this.cntPos = cntPos;
		this.cntEmail = cntEmail;
		this.cntIsdCde = cntIsdCde;
		this.cntAreaCde = cntAreaCde;
		this.cntPhnNo = cntPhnNo;
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

	public String getCntTyp() {
		return cntTyp;
	}

	public void setCntTyp(String cntTyp) {
		this.cntTyp = cntTyp;
	}

	public String getCntName() {
		return cntName;
	}

	public void setCntName(String cntName) {
		this.cntName = cntName;
	}

	public String getCntPos() {
		return cntPos;
	}

	public void setCntPos(String cntPos) {
		this.cntPos = cntPos;
	}

	public String getCntEmail() {
		return cntEmail;
	}

	public void setCntEmail(String cntEmail) {
		this.cntEmail = cntEmail;
	}

	public String getCntIsdCde() {
		return cntIsdCde;
	}

	public void setCntIsdCde(String cntIsdCde) {
		this.cntIsdCde = cntIsdCde;
	}

	public String getCntAreaCde() {
		return cntAreaCde;
	}

	public void setCntAreaCde(String cntAreaCde) {
		this.cntAreaCde = cntAreaCde;
	}

	public String getCntPhnNo() {
		return cntPhnNo;
	}

	public void setCntPhnNo(String cntPhnNo) {
		this.cntPhnNo = cntPhnNo;
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