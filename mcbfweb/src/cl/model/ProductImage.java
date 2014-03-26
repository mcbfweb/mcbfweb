package cl.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Service;


@Entity( name = "PRDIMGM0" )
@Service
public class ProductImage {
	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	@Column(name = "IMGDATID")
	int DatId;
	
	@Column(name = "IMGPRDID")
	int prdId;
	@Column(name = "IMGPRDTITLE") 
	String title;
	@Column(name = "IMGPRDIMG") 
	byte[] image;
	@Column(name = "IMGSIZE")
	int size;
	@Column(name = "IMGCTGY") 
	String category;
	@Column(name = "IMGNAME") 
	String name;	
	@Column(name = "IMGVERSION") 
	int version;
	
	@Transient
	String imagePath;
	
	public int getDatId() {
		return DatId;
	}
	public void setDatId(int datId) {
		DatId = datId;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	
    
	
	
}
