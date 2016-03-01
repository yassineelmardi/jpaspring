package ma.jpaspring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nom;
	private String prenom;
	private Date datenai;
	
public Student(){
	
}
public Student(Integer id, String nom){
	this.id=id;
	this.nom=nom;
}
public Student(String nom, String prenom,Date datenai){
	this.nom=nom;
	this.prenom=prenom;
	this.datenai=datenai;
}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}


public Date getDatenai() {
	return datenai;
}
public void setDatenai(Date datenai) {
	this.datenai = datenai;
}
@Override
public String toString() {
	return "Student [id=" + id + ", nom=" + nom + ", prenom=" + prenom
			+ ", datenai=" + datenai + "]";
}


}
