package cl.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.stereotype.Service;


@Entity( name = "ADMUSRM0" )
@Service
public class User {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "USRDATID")
	int DatId;
	
	@Column(name = "USRCLIENT")
	int client;
	@Column(name = "USRSTATUS") 
	String status;
	
	@Column(name = "USRSTATDT")
	Date statusDate;
	@Column(name = "USRID")
	//@Type(type = "encryptedString")
	String userID;
	@Column(name = "USRPWD")
	@Type(type = "encryptedString")
	String userPwd;
	@Column(name = "USRPWDEXP") 
	Date pwdExpDt;
	@Column(name = "USRROLE")
	String userRole;
	@Column(name = "USRGROUP") 
	String userGroup;
	@Column(name = "USRUNAME")
	String userName;
	@Column(name = "USREMAIL") 
	String userEmail;
	@Column(name = "USRCNTISDCDE")
	String userISDCde;
	@Column(name = "USRAREACDE") 
	String userAreaCde;
	@Column(name = "USRPHNNO")
	String userPhnNo;
	
	@Column(name = "USRCRTDT")
	Date crtDate;;
	@Column(name = "USRCRTUSR") 
	String crtByUser;
	@Column(name = "USRCHGDT")
	Date chgDate;;
	@Column(name = "USRCHGUSR") 
	String chgByUser;
	@Column(name = "USRVERSION") 
	int version;
	
	
    	
		
	
	
	public int getDatId() {
		return DatId;
	}
	public void setDatId(int datId) {
		DatId = datId;
	}
	public int getClient() {
		return client;
	}
	public void setClient(int client) {
		this.client = client;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Temporal(TemporalType.TIMESTAMP)	
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	@Temporal(TemporalType.TIMESTAMP)	
	public Date getPwdExpDt() {
		return pwdExpDt;
	}
	public void setPwdExpDt(Date pwdExpDt) {
		this.pwdExpDt = pwdExpDt;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getUserGroup() {
		return userGroup;
	}
	public void setUserGroup(String userGroup) {
		this.userGroup = userGroup;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserISDCde() {
		return userISDCde;
	}
	public void setUserISDCde(String userISDCde) {
		this.userISDCde = userISDCde;
	}
	public String getUserAreaCde() {
		return userAreaCde;
	}
	public void setUserAreaCde(String userAreaCde) {
		this.userAreaCde = userAreaCde;
	}
	public String getUserPhnNo() {
		return userPhnNo;
	}
	public void setUserPhnNo(String userPhnNo) {
		this.userPhnNo = userPhnNo;
	}
	public String getCrtByUser() {
		return crtByUser;
	}
	public void setCrtByUser(String crtByUser) {
		this.crtByUser = crtByUser;
	}
	public String getChgByUser() {
		return chgByUser;
	}
	public void setChgByUser(String chgByUser) {
		this.chgByUser = chgByUser;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Temporal(TemporalType.TIMESTAMP)	
	public Date getCrtDate() {
	    return crtDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getChgDate() {
		return chgDate;
	}

	public void setChgDate(Date chgDate) {
		this.chgDate = chgDate;
	}

	public void setCrtDate(Date crtDate) {
		this.crtDate = crtDate;
	}
   
	
	
}
