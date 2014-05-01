package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
		//@SecondaryTable(name = "BIZENTCNTM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "CNTENTITY", referencedColumnName = "ITYENTITY") }),
		//@SecondaryTable(name = "BIZENTADRM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "ADRENTITY", referencedColumnName = "ITYENTITY") }),
		@SecondaryTable(name = "BIZENTINNM0", pkJoinColumns = { @PrimaryKeyJoinColumn(name = "INNENTITY", referencedColumnName = "ITYENTITY") }) })
public class EntityListDetail {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "ITYENTITY", unique = true, nullable = false)
	private int entity;
	@Column(name = "ITYENTTYP")
	private String entTyp;
	@Column(name = "ITYCTRY")
	private String ctry;
	@Column(name = "ITYECOCODE")
	private String ecoCode;
	@Column(name = "ITYBIZCODE")
	private String bizCode;
	@Column(name = "ITYGRPCODE")
	private String grpCode;
	@Column(name = "ITYINDCODE")
	private String indCode;
	@Column(name = "ITYCRTDT")
	private Date crtDate;;
	@Column(name = "ITYCRTUSR")
	private String crtByUser;
	@Column(name = "ITYCHGDT")
	private Date chgDate;;
	@Column(name = "ITYCHGUSR")
	private String chgByUser;
	@Column(name = "ITYVERSION")
	private Integer version;

	@Column(table = "BIZENTINNM0", name = "INNBNAME")
	private String bizName;

	public EntityListDetail() {
		super();

	}

	public EntityListDetail(int entity, String entTyp, String ctry, String ecoCode, String bizCode, String grpCode,
			String indCode, Date crtDate, String crtByUser, Date chgDate, String chgByUser, Integer version, String bizName) {
		super();
		this.entity = entity;
		this.entTyp = entTyp;
		this.ctry = ctry;
		this.ecoCode = ecoCode;
		this.bizCode = bizCode;
		this.grpCode = grpCode;
		this.indCode = indCode;
		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
		this.bizName = bizName;
	}
	

	public String getBizName() {
		return bizName;
	}

	public void setBizName(String bizName) {
		this.bizName = bizName;
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
