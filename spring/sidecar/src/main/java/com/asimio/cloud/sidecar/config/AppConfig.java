
package com.asimio.cloud.sidecar.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.asimio.cloud.sidecar.healthcheck.SidecarHealthIndicator;
import com.asimio.cloud.sidecar.healthcheck.postgres.PostgresHealthCheck;

@Configuration
public class AppConfig {

	@ConditionalOnProperty(name = "sidecar.postgres.enabled", havingValue = "true", matchIfMissing = false)
	@Bean
	public SidecarHealthIndicator postgresHealthCheck() {
		return new PostgresHealthCheck();
	}
}