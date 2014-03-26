package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;

@Entity(name = "BIZENTITYM0")
@Service
public class BizEntity {

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

	
	public BizEntity() {

	}

	public BizEntity(int entity, String ecoCode, String bizCode) {

		this.entity = entity;
		this.ecoCode = ecoCode;
		this.bizCode = bizCode;
		
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

	
	

}