package cl.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
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
		@SecondaryTable(name = "BIZENTADRM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "ADRENTITY", referencedColumnName = "ITYENTITY") }),
		@SecondaryTable(name = "BIZENTINNM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "INNENTITY", referencedColumnName = "ITYENTITY") }) })
public class EntityDetail {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ITYENTITY", unique = true, nullable = false)
	Integer entity;
	@Column(name = "ITYENTTYP")
	String entTyp;
	@Column(name = "ITYCTRY")
	String ctry;
	@Column(name = "ITYECOCODE")
	String ecoCode;
	@Column(name = "ITYBIZCODE")
	String bizCode;
	@Column(name = "ITYGRPCODE")
	String grpCode;
	@Column(name = "ITYINDCODE")
	String indCode;
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

	@OneToMany(mappedBy = "entitydetail", cascade = { CascadeType.ALL } )
	//@OrderColumn(name = "IDDATID")
	private List<BizEntId> ids;

	@OneToMany(mappedBy = "entitydetail", cascade = { CascadeType.ALL })
	//@OrderColumn(name = "CNTDATID")
	private List<BizEntCnt> contacts;

	@OneToMany(mappedBy = "entitydetail", cascade = { CascadeType.ALL })
	//@OrderColumn(name = "ADRDATID")
	private List<BizEntAdr> addresses;

	@OneToMany(mappedBy = "entitydetail", cascade = { CascadeType.ALL })
	//@OrderColumn(name = "INNDATID")
	private List<BizEntInn> names;

	public EntityDetail() {
		super();
		this.addresses = new ArrayList<BizEntAdr>();
		this.addresses.add(new BizEntAdr());
		this.addresses.add(new BizEntAdr());
		this.names = new ArrayList<BizEntInn>();
		this.names.add(new BizEntInn());
		this.ids = new ArrayList<BizEntId>();
		this.ids.add(new BizEntId());
		this.ids.add(new BizEntId());
		this.contacts = new ArrayList<BizEntCnt>();
		this.contacts.add(new BizEntCnt());
		this.contacts.add(new BizEntCnt());

	}

	public List<BizEntId> getIds() {
		return ids;
	}

	public void setIds(List<BizEntId> ids) {
		this.ids = ids;
	}

	public List<BizEntCnt> getContacts() {
		return contacts;
	}

	public void setContacts(List<BizEntCnt> contacts) {
		this.contacts = contacts;
	}

	public List<BizEntAdr> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<BizEntAdr> addresses) {
		this.addresses = addresses;
	}

	public List<BizEntInn> getNames() {
		return names;
	}

	public void setNames(List<BizEntInn> names) {
		this.names = names;
	}

	public void setEntity(Integer entity) {
		this.entity = entity;
	}

	public Integer getEntity() {
		return entity;
	}

	public String getEntTyp() {
		return entTyp;
	}

	public void setEntTyp(String entTyp) {
		this.entTyp = entTyp;
	}

	public String getCtry() {
		return ctry;
	}

	public void setCtry(String ctry) {
		this.ctry = ctry;
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

	public String getGrpCode() {
		return grpCode;
	}

	public void setGrpCode(String grpCode) {
		this.grpCode = grpCode;
	}

	public String getIndCode() {
		return indCode;
	}

	public void setIndCode(String indCode) {
		this.indCode = indCode;
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
