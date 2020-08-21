package io.confluent.developer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.confluent.developer.avro.in.Header;
import io.confluent.developer.avro.in.Mensagem;
import io.confluent.developer.avro.in.Metadado;
import io.confluent.developer.avro.in.SEL1052;

@RestController
@RequestMapping(value = "/publish")
public class KafkaController {

	private final Producer producer;

	@Autowired
	KafkaController(Producer producer) {
		this.producer = producer;
	}

	@GetMapping(value = "/1052")
	public void publish1052() {

		Metadado metadado = new Metadado("T1", "V1");
		Header header = new Header("SEL1052", 1);
		Mensagem mensagem = new Mensagem("LTST0123456789");
		SEL1052 sel1052 = new SEL1052(metadado, header, mensagem);

		this.producer.sendMessage(sel1052);
	}

	@GetMapping(value = "/1052R1")
	public void publish1052R1() {

		io.confluent.developer.xml.in.Metadado metadado = new io.confluent.developer.xml.in.Metadado("T1", "V1");
		io.confluent.developer.xml.in.Header header = new io.confluent.developer.xml.in.Header("SEL1052R1", 1);
		io.confluent.developer.xml.in.Mensagem mensagem = new io.confluent.developer.xml.in.Mensagem("LTST0123456789",
				"CON");
		io.confluent.developer.xml.in.SEL1052R1 sel1052R1 = new io.confluent.developer.xml.in.SEL1052R1(metadado,
				header, mensagem);

		this.producer.sendMessage(sel1052R1);
	}

	@GetMapping(value = "/messages")
	public ResponseEntity<List<String>> getMessages() {

		return ResponseEntity.ok(CacheMessage.get("LTST0123456789"));
	}

	/*
	 * @GetMapping(value = "/1052E") public void publish1052E(@RequestParam("name")
	 * String name, @RequestParam("age") Integer age) {
	 * this.producer.sendMessage("1052E", new User(name, age)); }
	 */
}