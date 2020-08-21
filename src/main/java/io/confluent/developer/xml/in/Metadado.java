package io.confluent.developer.xml.in;

public class Metadado {

	private String tipo;
	private String versao;

	public Metadado() {
		super();
	}

	public Metadado(String tipo, String versao) {
		this();
		this.tipo = tipo;
		this.versao = versao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
	}
}