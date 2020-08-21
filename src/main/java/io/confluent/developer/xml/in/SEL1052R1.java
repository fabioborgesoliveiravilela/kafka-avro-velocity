package io.confluent.developer.xml.in;

public class SEL1052R1 {

	private Metadado metadado;

	private Header header;

	private Mensagem mensagem;

	public SEL1052R1() {
		super();
	}

	public SEL1052R1(Metadado metadado, Header header, Mensagem mensagem) {
		this();
		this.metadado = metadado;
		this.header = header;
		this.mensagem = mensagem;
	}

	public Metadado getMetadado() {
		return metadado;
	}

	public void setMetadado(Metadado metadado) {
		this.metadado = metadado;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
}
