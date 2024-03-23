package com.DataProject.DataJPA.service.dto;

import java.util.List;

public class PaeseDTO {
	
	private String a2;
	private String chiave;
	private String it;
	private String en;
	private String tipo;
	private List<AeroportoDTO> aeroporti;
	
	
	public String getA2() {
		return a2;
	}
	public void setA2(String a2) {
		this.a2 = a2;
	}
	public String getChiave() {
		return chiave;
	}
	public void setChiave(String chiave) {
		this.chiave = chiave;
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
	public List<AeroportoDTO> getAeroporti() {
		return aeroporti;
	}
	public void setAeroporti(List<AeroportoDTO> aeroporti) {
		this.aeroporti = aeroporti;
	}

}
