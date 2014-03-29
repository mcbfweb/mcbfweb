package cl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@Entity
@Table(name = "BIZENTITYM0")
@Service
@SecondaryTables({
		@SecondaryTable(name = "BIZENTIDM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "IDENTITY", referencedColumnName = "ITYENTITY") }),
		@SecondaryTable(name = "BIZENTCNTM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "CNTENTITY", referencedColumnName = "ITYENTITY") }),
		@SecondaryTable(name = "BIZENTINNM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "INNENTITY", referencedColumnName = "ITYENTITY") }) })
public class EntityDetail {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ITYENTITY", unique = true, nullable = false)
	int entity;
	@Column(name = "ITYENTTYP")
	String entTyp;
	@Column(name = "ITYECOCODE")
	String ecoCode;
	@Column(name = "ITYBIZCODE")
	String bizCode;
	@Column(name = "ITYCRTDT")
	Date crtDate;;
	@Column(name = "ITYCRTUSR")
	String crtByUser;
	@Column(name = "ITYCHGDT")
	Date chgDate;;
	@Column(name = "ITYCHGUSR")
	String chgByUser;
	@Column(name = "ITYVERSION")
	Integer version;

	// INNM0
	@Column(table = "BIZENTINNM0", name = "INNTYP")
	String type;
	@Column(table = "BIZENTINNM0", name = "INNFNAME")
	private String fName;
	@Column(table = "BIZENTINNM0", name = "INNSNAME")
	private String sName;
	@Column(table = "BIZENTINNM0", name = "INNLNAME")
	private String lName;
	@Column(table = "BIZENTINNM0", name = "INNUNAME")
	private String uName;
	@Column(table = "BIZENTINNM0", name = "INNBNAME")
	private String bizName;
	@Column(table = "BIZENTINNM0", name = "INNCRTDT")
	private Date inncrtDate;;
	@Column(table = "BIZENTINNM0", name = "INNCRTUSR")
	private String inncrtByUser;
	@Column(table = "BIZENTINNM0", name = "INNCHGDT")
	private Date innchgDate;;
	@Column(table = "BIZENTINNM0", name = "INNCHGUSR")
	private String innchgByUser;
	@Column(table = "BIZENTINNM0", name = "INNVERSION")
	private Integer innversion;

	// ID
	/*
	 * @Column(table = "BIZENTIDM0", name = "IDIDTYP") private String idTyp;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDIDCODE") private String idCode;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDCRTDT") private Date idcrtDate;;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDCRTUSR") private String
	 * idcrtByUser;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDCHGDT") private Date idchgDate;;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDCHGUSR") private String
	 * idchgByUser;
	 * 
	 * @Column(table = "BIZENTIDM0", name = "IDVERSION") private Integer
	 * idversion;
	 */

	@OneToMany(mappedBy = "entitydetail")
	private List<BizEntId> ids;

	@OneToMany(mappedBy = "entitydetail")
	private List<BizEntCnt> contacts;

	public EntityDetail() {
		ids = new ArrayList<BizEntId>();
		contacts = new ArrayList<BizEntCnt>();
		
	}

	public void addId(BizEntId id) {
		if (id != null)
			ids.add(id);
	}
	public void addContact(BizEntCnt contact) {
		if (contact != null)
			contacts.add(contact);
	}
	public List<BizEntId> getIds() {
		return ids;
	}

	public void setIds(List<BizEntId> ids) {
		this.ids = ids;
	}

	public int getEntity() {
		return entity;
	}

	public void setEntity(int entity) {
		this.entity = entity;
	}

	public String getEntTyp() {
		return entTyp;
	}

	public void setEntTyp(String entTyp) {
		this.entTyp = entTyp;
	}

	public String getEcoCode() {
		return ecoCode;
	}

	public void setEcoCode(String ecoCode) {
		this.ecoCode = ecoCode;
	}

	public String getBizCode() {
		return bizCode;
	}

	public void setBizCode(String bizCode) {
		this.bizCode = bizCode;
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

	public void setInnversion(Integer innversion) {
		this.innversion = innversion;
	}

	/*
	 * public void setIdversion(Integer idversion) { this.idversion = idversion;
	 * }
	 */
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

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
	}

	public Date getInncrtDate() {
		return inncrtDate;
	}

	public void setInncrtDate(Date inncrtDate) {
		this.inncrtDate = inncrtDate;
	}

	public String getInncrtByUser() {
		return inncrtByUser;
	}

	public void setInncrtByUser(String inncrtByUser) {
		this.inncrtByUser = inncrtByUser;
	}

	public Date getInnchgDate() {
		return innchgDate;
	}

	public void setInnchgDate(Date innchgDate) {
		this.innchgDate = innchgDate;
	}

	public String getInnchgByUser() {
		return innchgByUser;
	}

	public void setInnchgByUser(String innchgByUser) {
		this.innchgByUser = innchgByUser;
	}

	public int getInnversion() {
		return innversion;
	}

	public void setInnversion(int innversion) {
		this.innversion = innversion;
	}

}
