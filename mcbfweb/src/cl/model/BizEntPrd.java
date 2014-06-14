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
@Table(name = "BIZENTPRDM0")
@Service
public class BizEntPrd implements java.io.Serializable {

	@Id  
	@Column(name = "PRDDATID", unique = true, nullable = false)	
	private Integer datid;

	@Column(name = "PRDENTITY")
	private Integer entity;
	
	@Column(name = "PRDCODE")
	private String prdCode;	
	@Column(name = "PRDTITLE")
	private String prdTitle;	
	@Column(name = "PRDDESC")
	private String prdDesc;	
	@Column(name = "PRDPRICE")
	private Double prdPrice;	
	@Column(name = "PRDCTGY")
	private String prdCtgy;	
	@Column(name = "PRDMODEL")
	private String prdModel;	
	@Column(name = "PRDCOLOR")
	private String prdColor;	
	@Column(name = "PRDSIZE")
	private Double prdSize;	
	@Column(name = "PRDQTYAVL")
	private Double prdQtyAvl;	
	@Column(name = "PRDREOLVL")
	private Double prdReoLvl;	
	@Column(name = "PRDSUPPLIER")
	private String prdSupplier;		
	
	@Column(name = "PRDCRTDT")
	private Date crtDate;;
	@Column(name = "PRDCRTUSR")
	private String crtByUser;
	@Column(name = "PRDCHGDT")
	private Date chgDate;
	@Column(name = "PRDCHGUSR")
	private String chgByUser;
	@Column(name = "PRDVERSION")
	private Integer version;

	@ManyToOne(cascade = { CascadeType.ALL, CascadeType.MERGE })
	@JoinColumn(name = "PRDENTITY", nullable = false, insertable = false, updatable = false, referencedColumnName = "ITYENTITY")
	private EntityDetail entitydetail;

	public BizEntPrd() {
     super();
	}

	
	

	public BizEntPrd(Integer datid, Integer entity, String prdCode, String prdTitle, String prdDesc, Double prdPrice,
			String prdCtgy, String prdModel, String prdColor, Double prdSize, Double prdQtyAvl, Double prdReoLvl,
			String prdSupplier, Date crtDate, String crtByUser, Date chgDate, String chgByUser, Integer version,
			EntityDetail entitydetail) {
		super();
		this.datid = datid;
		this.entity = entity;
		this.prdCode = prdCode;
		this.prdTitle = prdTitle;
		this.prdDesc = prdDesc;
		this.prdPrice = prdPrice;
		this.prdCtgy = prdCtgy;
		this.prdModel = prdModel;
		this.prdColor = prdColor;
		this.prdSize = prdSize;
		this.prdQtyAvl = prdQtyAvl;
		this.prdReoLvl = prdReoLvl;
		this.prdSupplier = prdSupplier;
		this.crtDate = crtDate;
		this.crtByUser = crtByUser;
		this.chgDate = chgDate;
		this.chgByUser = chgByUser;
		this.version = version;
		this.entitydetail = entitydetail;
	}




	public String getPrdCode() {
		return prdCode;
	}


	public void setPrdCode(String prdCode) {
		this.prdCode = prdCode;
	}


	public String getPrdTitle() {
		return prdTitle;
	}


	public void setPrdTitle(String prdTitle) {
		this.prdTitle = prdTitle;
	}





	public String getPrdDesc() {
		return prdDesc;
	}





	public void setPrdDesc(String prdDesc) {
		this.prdDesc = prdDesc;
	}



	public String getPrdCtgy() {
		return prdCtgy;
	}





	public void setPrdCtgy(String prdCtgy) {
		this.prdCtgy = prdCtgy;
	}





	public String getPrdModel() {
		return prdModel;
	}





	public void setPrdModel(String prdModel) {
		this.prdModel = prdModel;
	}





	public String getPrdColor() {
		return prdColor;
	}





	public void setPrdColor(String prdColor) {
		this.prdColor = prdColor;
	}





	public Double getPrdPrice() {
		return prdPrice;
	}




	public void setPrdPrice(Double prdPrice) {
		this.prdPrice = prdPrice;
	}




	public Double getPrdSize() {
		return prdSize;
	}




	public void setPrdSize(Double prdSize) {
		this.prdSize = prdSize;
	}




	public Double getPrdQtyAvl() {
		return prdQtyAvl;
	}




	public void setPrdQtyAvl(Double prdQtyAvl) {
		this.prdQtyAvl = prdQtyAvl;
	}




	public Double getPrdReoLvl() {
		return prdReoLvl;
	}




	public void setPrdReoLvl(Double prdReoLvl) {
		this.prdReoLvl = prdReoLvl;
	}




	public String getPrdSupplier() {
		return prdSupplier;
	}





	public void setPrdSupplier(String prdSupplier) {
		this.prdSupplier = prdSupplier;
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