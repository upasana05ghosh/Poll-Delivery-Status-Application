package com.example.router.route;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PollDeliveryService {

	private static final Logger log = LoggerFactory.getLogger(PollDeliveryService.class);

	public void poll() {
		log.info("Polling in progress");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
