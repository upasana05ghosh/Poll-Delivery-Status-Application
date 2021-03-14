package com.example.router.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PollDeliveryStatusRoute extends RouteBuilder {

	private static final String ROUTE_NAME = "PollDeliveryStatusRoute";

	private final PollDeliveryStatusProcessor processor;
	private final PollDeliveryProperties properties;

	@Autowired
	public PollDeliveryStatusRoute(PollDeliveryStatusProcessor processor, PollDeliveryProperties properties) {
		super();
		this.processor = processor;
		this.properties = properties;

	}

	@Override
	public void configure() throws Exception {

		from("timer:pollDeliveryStatusRoute?period=" + properties.getRefreshInterval()).autoStartup(true)
				.routeId(ROUTE_NAME).delay(properties.getRefreshStartUpDelay()).process(processor);

	}

}
