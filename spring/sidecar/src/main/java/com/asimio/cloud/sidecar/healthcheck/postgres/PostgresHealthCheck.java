package com.asimio.cloud.sidecar.healthcheck.postgres;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.Health;

import com.asimio.cloud.sidecar.healthcheck.SidecarHealthIndicator;

public class PostgresHealthCheck implements SidecarHealthIndicator {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostgresHealthCheck.class);

	// pg_isready -U <user> -h localhost -p <sidecarPort>
	private static final String COMMAND_PATTERN = "pg_isready -U %s -h localhost -p %s";

	@Value("${sidecar.port}")
	private int sidecarPort;

	@Override
	public Health health() {
		Health.Builder result = null;
		try {
			String output = this.runCommand();
			LOGGER.info(output);
			if (output.indexOf("accepting connections") != -1) {
				result = Health.up();
			} else if (output.indexOf("rejecting connections") != -1 || output.indexOf("no response") != -1) {
				result = Health.down().withDetail("reason", output);
			}
		} catch (IOException e) {
			LOGGER.warn("Failed to execute command.", e);
			result = Health.down().withException(e);
		}
		return result.build();
	}

	private String runCommand() throws IOException {
		BufferedReader reader = null;
		try {
			StringBuffer output = new StringBuffer();
			// FIXME: Make Username configurable 
			Process process = Runtime.getRuntime().exec(String.format(COMMAND_PATTERN, "postgres", this.sidecarPort));
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				output.append(line);
				output.append(System.getProperty("line.separator"));
			}
			return output.toString();
		} finally {
			IOUtils.closeQuietly(reader);
		}
	}
}