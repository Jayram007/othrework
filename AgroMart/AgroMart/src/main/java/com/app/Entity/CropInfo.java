package com.app.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "cropInfo")
public class CropInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cropId;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,30}$", message="crop Name must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String cropName;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z]{2,30}$", message="scientificName must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String scientificName;

	@NotEmpty
	@Pattern(regexp = "^[a-zA-Z ]{2,30}$", message="cropType must be within the range 2 to 30 characters")
	@Column(length = 30)
	private String cropType;

	@NotEmpty
	
	@Column(length = 500)
	private String description;

	
	@Column(length = 500)
	private String image;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id")
	private Users crop;

	public Users getCrop() {
		return crop;
	}

	public void setCrop(Users crop) {
		this.crop = crop;
	}

	public int getCropId() {
		return cropId;
	}

	public void setCropId(int cropId) {
		this.cropId = cropId;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getCropName() {
		return cropName;
	}

	public void setCropName(String cropName) {
		this.cropName = cropName;
	}

	public String getScientificName() {
		return scientificName;
	}

	public void setScientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public String getCropType() {
		return cropType;
	}

	public void setCropType(String cropType) {
		this.cropType = cropType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
