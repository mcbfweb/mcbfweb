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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@SuppressWarnings("serial")
@Entity
@Table(name = "BIZENTADRM0")
@Service
public class BizEntAdr implements java.io.Serializable {

	@Id  
	//@GeneratedValue(generator = "increment")
	//@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ADRDATID", unique = true, nullable = false)
	private Integer datid;

	@Column(name = "ADRENTITY")
	private Integer entity;

	@Column(name = "ADRTYP")
	private String adrTyp;
	@Column(name = "ADRBLDG")
	private String adrBldg;
	@Column(name = "ADRFLR")
	private String adrFlr;
	@Column(name = "ADRAPTNO")
	private String adrAptNo;
	@Column(name = "ADRSTRTNO")
	private String adrStrtNo;
	@Column(name = "ADRSTRNM")
	private String adrstrNm;
	@Column(name = "ADRLINE1")
	private String adrLine1;
	@Column(name = "ADRLINE2")
	private String adrLine2;
	@Column(name = "ADRLINE3")
	private String adrLine3;
	@Column(name = "ADRCITY")
	private String adrCity;
	@Column(name = "ADRSTATE")
	private String adrState;
	@Column(name = "ADRCTRY")
	private String adrCtry;
	@Column(name = "ADRPSTCDE")
	private String adrPstCde;

	@Column(name = "ADRCRTDT")
	private Date crtDate;;
	@Column(name = "ADRCRTUSR")
	private String crtByUser;
	@Column(name = "ADRCHGDT")
	private Date chgDate;;
	@Column(name = "ADRCHGUSR")
	private String chgByUser;
	@Column(name = "ADRVERSION")
	private Integer version;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "ADRENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntAdr() {
      super();
	}

	public BizEntAdr(Integer datid, Integer entity, String adrTyp, String adrBldg, String adrFlr, String adrAptNo, String adrStrtNo,
			String adrstrNm, String adrLine1, String adrLine2, String adrLine3, String adrCity, String adrState, String adrCtry,
			String adrPstCde, Date crtDate, String crtByUser, Date chgDate, String chgByUser, Integer version) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.adrTyp = adrTyp;
		this.adrBldg = adrBldg;
		this.adrFlr = adrFlr;
		this.adrAptNo = adrAptNo;
		this.adrStrtNo = adrStrtNo;
		this.adrstrNm = adrstrNm;
		this.adrLine1 = adrLine1;
		this.adrLine2 = adrLine2;
		this.adrLine3 = adrLine3;
		this.adrCity = adrCity;
		this.adrState = adrState;
		this.adrCtry = adrCtry;
		this.adrPstCde = adrPstCde;

		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
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

	public String getAdrTyp() {
		return adrTyp;
	}

	public void setAdrTyp(String adrTyp) {
		this.adrTyp = adrTyp;
	}

	public String getAdrBldg() {
		return adrBldg;
	}

	public void setAdrBldg(String adrBldg) {
		this.adrBldg = adrBldg;
	}

	public String getAdrFlr() {
		return adrFlr;
	}

	public void setAdrFlr(String adrFlr) {
		this.adrFlr = adrFlr;
	}

	public String getAdrAptNo() {
		return adrAptNo;
	}

	public void setAdrAptNo(String adrAptNo) {
		this.adrAptNo = adrAptNo;
	}

	public String getAdrStrtNo() {
		return adrStrtNo;
	}

	public void setAdrStrtNo(String adrStrtNo) {
		this.adrStrtNo = adrStrtNo;
	}

	public String getAdrstrNm() {
		return adrstrNm;
	}

	public void setAdrstrNm(String adrstrNm) {
		this.adrstrNm = adrstrNm;
	}

	public String getAdrLine1() {
		return adrLine1;
	}

	public void setAdrLine1(String adrLine1) {
		this.adrLine1 = adrLine1;
	}

	public String getAdrLine2() {
		return adrLine2;
	}

	public void setAdrLine2(String adrLine2) {
		this.adrLine2 = adrLine2;
	}

	public String getAdrLine3() {
		return adrLine3;
	}

	public void setAdrLine3(String adrLine3) {
		this.adrLine3 = adrLine3;
	}

	public String getAdrCity() {
		return adrCity;
	}

	public void setAdrCity(String adrCity) {
		this.adrCity = adrCity;
	}

	public String getAdrState() {
		return adrState;
	}

	public void setAdrState(String adrState) {
		this.adrState = adrState;
	}

	public String getAdrCtry() {
		return adrCtry;
	}

	public void setAdrCtry(String adrCtry) {
		this.adrCtry = adrCtry;
	}

	public String getAdrPstCde() {
		return adrPstCde;
	}

	public void setAdrPstCde(String adrPstCde) {
		this.adrPstCde = adrPstCde;
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