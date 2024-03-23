package com.DataProject.DataJPA.domain;

import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "paesi")
public class Paese {
		

	@Id
	@Column(length = 3, nullable=false)
	private String a2;
	
	
	//@Column(name = "key")
	private String chiave;
	private String it;
	private String en;
	private String tipo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "paese", fetch=FetchType.LAZY)
	private List<Aeroporto> aeroporti;
	

	public List<Aeroporto> getAeroporti() {
		return aeroporti;
	}
	public void setAeroporti(List<Aeroporto> aeroporti) {
		this.aeroporti = aeroporti;
	}
	public String getIt() {
		return it;
	}
	public void setIt(String it) {
		this.it = it;
	}
	public String getEn() {
		return en;
	}
	public void setEn(String en) {
		this.en = en;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
	}
	public String getId() {
		return a2;
	}
	public void setId(String a2) {
		this.a2 = a2;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Paese)) return false;
        Paese paese = (Paese) o;
        return Objects.equals(a2, paese.a2);
	}
	
	@Override
    public int hashCode() {
        return Objects.hash(a2);
    }
	
	@Override
    public String toString() {
        return "Paese{" +
            "a2=" + a2 +
            ", chiave=" + chiave +
            ", it='" + it + '\'' +
            ", en='" + en + '\'' +
            ", tipo='" + tipo + '\'' +
            '}';
    }
	
}

