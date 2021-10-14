package com.asimio.cloud.sidecar.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.asimio.cloud.sidecar.healthcheck.SidecarHealthIndicator;

@RestController
public class LocalStatusDelegatorController {

	@Autowired
	private SidecarHealthIndicator healthIndicator;

	@RequestMapping("/delegating-status")
	public Health sidecarHealthStatus() {
		return this.healthIndicator.health();
	}
}