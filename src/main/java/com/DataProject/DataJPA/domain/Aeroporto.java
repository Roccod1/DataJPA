package com.DataProject.DataJPA.domain;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "aeroporti")
@ApiModel(description = "Dettagli sull'aeroporto")
public class Aeroporto{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 3, nullable = false, unique = true)
	@ApiModelProperty(notes = "Codice univoco IATA delle compagnie aeree")
	private String iata;
	
	@ApiModelProperty(notes = "Codice univoco ICAO dell'aeroporto")
	private String icao;
	@ApiModelProperty(notes = "Nome dell'aeroporto")
	private String name;
	
	@Column(name = "paese")
	private String paeseNome;
	
	@Column(name = "country_code", length = 3)
	private String countryCode;
	
	
	@ManyToOne
	@JoinColumn(name = "a2", nullable = false)
	private Paese paese;
	
	@ApiModelProperty(notes = "Città in cui si trova l'aeroporto")
	private String citta;
	private String city;
	private String state;
	
	@Column(name = "zone_name")
	private String zoneName;
	
	private String latitude;
	private String longitude;
	private Integer elevation;
	private String classe;
	private String tipo;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIata() {
		return iata;
	}

	public void setIata(String iata) {
		this.iata = iata;
	}

	public String getIcao() {
		return icao;
	}

	public void setIcao(String icao) {
		this.icao = icao;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}


	public Paese getPaese() {
		return paese;
	}

	public void setPaese(Paese paese) {
		this.paese = paese;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getElevation() {
		return elevation;
	}

	public void setElevation(Integer elevation) {
		this.elevation = elevation;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
	public String getPaeseNome() {
		return paeseNome;
	}

	public void setPaeseNome(String paeseNome) {
		this.paeseNome = paeseNome;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aeroporto)) return false;
        Aeroporto aeroporto = (Aeroporto) o;
        return Objects.equals(id, aeroporto.id);
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(id);
    }
	
	@Override
    public String toString() {
        return "Aeroporto{" +
            "id=" + id +
            ", iata=" + iata +
            ", name='" + name + '\'' +
            ", icao='" + icao + '\'' +
            ", countryCode='" + countryCode + '\'' +
            ", citta='" + citta + '\'' +
            ", city='" + city + '\'' +
            ", state='" + state + '\'' +
            ", latitude='" + latitude + '\'' +
            ", longitude='" + longitude + '\'' +
            ", elevation='" + elevation + '\'' +
            ", classe='" + classe + '\'' +
            ", tipo='" + tipo + '\'' +
            ", nome del paese='" + paeseNome + '\'' +
            '}';
    }
	
}
