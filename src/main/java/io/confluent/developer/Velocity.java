package io.confluent.developer;

import java.io.ByteArrayInputStream;
import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;
import org.json.JSONObject;

public class Velocity {

	public static void main(String[] args) throws Exception {

		VelocityEngine ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();

		// JSON
		StringBuilder json = new StringBuilder();
		json.append("{\n" + 
				"   \"Metadado\":{\n" + 
				"      \"Tipo\":T1,\n" + 
				"      \"Versao\":\"V1\"\n" + 
				"   },\n" + 
				"   \"Header\":{\n" + 
				"      \"CodMsg\":\"SEL1052\",\n" + 
				"      \"NumSeq\":\"1\"\n" + 
				"   },\n" + 
				"   \"Mensagem\":{\n" + 
				"      \"NumCtrlIF\":\"NCI1234567890\"\n" + 
				"   }\n" + 
				"}");

		JSONObject documentJSON = new JSONObject(json.toString());

		// IDA
		VelocityContext vc = new VelocityContext();
		vc.put("goMessage", documentJSON);

		StringWriter writer = new StringWriter();

		Template t = ve.getTemplate("xml.vm");
		t.merge(vc, writer);

		System.out.println(writer.toString());

		// Volta
		// XML
		StringBuilder xml = new StringBuilder();
		xml.append("<DOC>");
		xml.append("	<Metadado>");
		xml.append("		<Tipo>T2</Tipo>");
		xml.append("		<Versao>V1</Versao>");
		xml.append("	</Metadado>");
		xml.append("	<Header>");
		xml.append("		<CodMsg>SEL1052R1</CodMsg>");
		xml.append("	</Header>");
		xml.append("	<Mensagem>");
		xml.append("		<NumCtrlIF>NCI1234567890</NumCtrlIF>");
		xml.append("		<SitOpSEL>CON</SitOpSEL>");
		xml.append("	</Mensagem>");
		xml.append("</DOC>");

		Document documentXML = new SAXBuilder().build(new ByteArrayInputStream(xml.toString().getBytes()));

		vc = new VelocityContext();
		vc.put("goMessage", documentJSON);
		vc.put("backMessage", documentXML.getRootElement());

		writer = new StringWriter();

		t = ve.getTemplate("json.vm");
		t.merge(vc, writer);

		System.out.println(writer.toString());
	}

}
