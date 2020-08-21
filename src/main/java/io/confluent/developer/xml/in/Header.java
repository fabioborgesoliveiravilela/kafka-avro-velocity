package io.confluent.developer.xml.in;

public class Header {

	private String codMsg;

	private Integer numSeq;

	public Header() {
		super();
	}

	public Header(String codMsg, Integer numSeq) {
		this();
		this.codMsg = codMsg;
		this.numSeq = numSeq;
	}

	public String getCodMsg() {
		return codMsg;
	}

	public void setCodMsg(String codMsg) {
		this.codMsg = codMsg;
	}

	public Integer getNumSeq() {
		return numSeq;
	}

	public void setNumSeq(Integer numSeq) {
		this.numSeq = numSeq;
	}
}