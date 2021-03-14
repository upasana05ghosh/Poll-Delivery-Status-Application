package com.example.router.route;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PollDeliveryProperties {

	private Long refreshInterval = 300L;
	private Long refreshStartUpDelay = 9000L;

	public Long getRefreshInterval() {
		return refreshInterval;
	}

	public void setRefreshInterval(Long refreshInterval) {
		this.refreshInterval = refreshInterval;
	}

	public Long getRefreshStartUpDelay() {
		return refreshStartUpDelay;
	}

	public void setRefreshStartUpDelay(Long refreshStartUpDelay) {
		this.refreshStartUpDelay = refreshStartUpDelay;
	}

}
