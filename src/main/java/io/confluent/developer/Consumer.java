package io.confluent.developer;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import io.confluent.developer.avro.in.SEL1052;
import io.confluent.developer.xml.in.SEL1052R1;

@Service
public class Consumer {

	private VelocityEngine ve;

	private final Producer producer;

	@Autowired
	public Consumer(Producer producer) {
		this.producer = producer;

		ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
		ve.init();
	}

	@KafkaListener(topics = "1052")
	public void consume1052(ConsumerRecord<String, SEL1052> record) {

		SEL1052 sel1052 = record.value();

		JSONObject sel1052JSONObject = new JSONObject(sel1052.toString());

		// JSON
		String sel1052JSON = sel1052JSONObject.toString();
		CacheMessage.put(sel1052.getMensagem().getNumCtrlIF().toString(), sel1052JSON);
		System.out.println(String.format("OM0 Consumed SEL1052 from ON6 - Avro-> %s", sel1052.toString()));
		System.out.println(String.format("OM0 Consumed SEL1052 from ON6-> %s", sel1052JSON));

		// XML to O7
		VelocityContext vc = new VelocityContext();
		vc.put("goMessage", sel1052JSONObject);

		StringWriter writer = new StringWriter();

		Template t = ve.getTemplate("xml.vm");
		t.merge(vc, writer);

		String sel1052XML = writer.toString();

		CacheMessage.put(sel1052.getMensagem().getNumCtrlIF().toString(), sel1052XML);
		System.out.println(String.format("OM0 Sending SEL1052 to O7 -> %s", sel1052XML));
	}

	@KafkaListener(topics = "1052R1", groupId = "group_id")
	public void consume1052R1(ConsumerRecord<String, String> record) throws IOException {

		String sel1052R1XML = record.value();

		SEL1052R1 sel1052R1 = JAXB.unmarshal(new ByteArrayInputStream(sel1052R1XML.getBytes()), SEL1052R1.class);

		CacheMessage.put(sel1052R1.getMensagem().getNumCtrlIF().toString(), sel1052R1XML);

		System.out.println(String.format("OM0 Consumed SEL1052R1 from O7 -> %s", sel1052R1XML));

		// AVRO to ON6
		VelocityContext vc = new VelocityContext();
		vc.put("backMessage", sel1052R1);

		StringWriter writer = new StringWriter();

		Template t = ve.getTemplate("json.vm");
		t.merge(vc, writer);

		producer.sendMessage("1052R1.avsc", writer.toString());

	}

	@KafkaListener(topics = "ON61052R1")
	public void consumeON61052R1(ConsumerRecord<String, io.confluent.developer.avro.out.SEL1052R1> record) {

		io.confluent.developer.avro.out.SEL1052R1 sel1052R1 = record.value();

		JSONObject sel1052R1JSONObject = new JSONObject(sel1052R1.toString());

		// JSON
		String sel1052JSON = sel1052R1JSONObject.toString();
		System.out.println(String.format("ON6 Consumed SEL1052 from OM0 - Avro-> %s", sel1052R1.toString()));
		System.out.println(String.format("ON6 Consumed SEL1052 from OM0-> %s", sel1052JSON));
	}
}
