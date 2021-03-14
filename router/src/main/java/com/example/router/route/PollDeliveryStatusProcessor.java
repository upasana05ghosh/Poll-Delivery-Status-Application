package com.example.router.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class PollDeliveryStatusProcessor implements Processor {

	PollDeliveryService pollDeliveryService;

	private static final Logger log = LoggerFactory.getLogger(PollDeliveryStatusProcessor.class);

	@Autowired
	public PollDeliveryStatusProcessor(PollDeliveryService pollDeliveryService) {
		super();
		this.pollDeliveryService = pollDeliveryService;
	}

	@Override
	public void process(Exchange exchange) throws Exception {
		log.info("Polling started.......");
		pollDeliveryService.poll();
		log.info("Polling completed......");
	}

}
