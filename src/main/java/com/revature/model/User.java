package com.revature.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userprofiles")
public class User {
	
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="profileid")
    private int profileid;
    @Column(name="username", unique = true)
    private String username;
    @Column(name="pwd")
    private String pwd;
    @Column(name="fullname")
    private String fullname;
    @Column(name="aboutme")
    private String aboutme;
    
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String name, String pwd, String fullname, String aboutme) {
		super();
		this.profileid = id;
		this.fullname = name;
		this.pwd = pwd;
		this.fullname = fullname;
		this.aboutme = aboutme;
	}

	public int getId() {
		return profileid;
	}

	public void setId(int id) {
		this.profileid = id;
	}

	public String getName() {
		return fullname;
	}

	public void setName(String name) {
		this.fullname = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAboutme() {
		return aboutme;
	}

	public void setAboutme(String aboutme) {
		this.aboutme = aboutme;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aboutme == null) ? 0 : aboutme.hashCode());
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + profileid;
		result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (aboutme == null) {
			if (other.aboutme != null)
				return false;
		} else if (!aboutme.equals(other.aboutme))
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (profileid != other.profileid)
			return false;
		if (fullname == null) {
			if (other.fullname != null)
				return false;
		} else if (!fullname.equals(other.fullname))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + profileid + ", name=" + fullname + ", pwd=" + pwd + ", fullname=" + fullname + ", aboutme=" + aboutme
				+ "]";
	}
	
	
    
	
    
    
}
