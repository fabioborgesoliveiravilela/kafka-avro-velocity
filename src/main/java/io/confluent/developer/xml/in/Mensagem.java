package io.confluent.developer.xml.in;

public class Mensagem {

	private String numCtrlIF;

	private String sitOpSEL;

	public Mensagem() {
		super();
	}

	public Mensagem(String numCtrlIF, String sitOpSEL) {
		this();
		this.numCtrlIF = numCtrlIF;
		this.sitOpSEL = sitOpSEL;
	}

	public String getNumCtrlIF() {
		return numCtrlIF;
	}

	public void setNumCtrlIF(String numCtrlIF) {
		this.numCtrlIF = numCtrlIF;
	}

	public String getSitOpSEL() {
		return sitOpSEL;
	}

	public void setSitOpSEL(String sitOpSEL) {
		this.sitOpSEL = sitOpSEL;
	}
}
