package io.confluent.developer;

import java.io.IOException;
import java.io.StringWriter;

import javax.xml.bind.JAXB;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.JsonDecoder;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.confluent.developer.avro.in.SEL1052;
import io.confluent.developer.xml.in.SEL1052R1;

@Service
public class Producer {

	private final KafkaTemplate<String, Object> kafkaTemplate;

	@Autowired
	public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	// Avro String
	public void sendMessage(String schemaFileName, String json) throws IOException {

		Schema.Parser parser = new Schema.Parser();
		Schema schema = parser.parse(ClassLoader.getSystemResourceAsStream("avro/" + schemaFileName));

		DatumReader<Object> datumReader = new GenericDatumReader<>(schema);
		JsonDecoder jsonDecoder = DecoderFactory.get().jsonDecoder(schema, json);
		GenericRecord avroRecord = (GenericRecord) datumReader.read(null, jsonDecoder);

		ProducerRecord<String, Object> producerRecord = new ProducerRecord<>("ON61052R1", "key1", avroRecord);

		this.kafkaTemplate.send(producerRecord);

		System.out.println(String.format("OM0 Produced SEL1052R1 to ON6 -> %s", producerRecord));
	}

	// Avro
	public void sendMessage(SEL1052 sel1052) {

		this.kafkaTemplate.send("1052", "1052", sel1052);
		System.out.println(String.format("ON6 Produced SEL1052 to OM0 -> %s", sel1052));
	}

	// XML String
	public void sendMessage(SEL1052R1 sel1052R1) {

		StringWriter stringWriter = new StringWriter();

		JAXB.marshal(sel1052R1, stringWriter);

		this.kafkaTemplate.send("1052R1", "1052R1", stringWriter.toString());
		System.out.println(String.format("O7 Produced SEL1052R1 to OM0 -> %s", stringWriter.toString()));
	}
}