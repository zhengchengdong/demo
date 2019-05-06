package com.demo.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "filepath")
public class FilePathConfig {

	private String snapshotFileBasePath;

	private String jFileBasePath;

	public String getSnapshotFileBasePath() {
		return snapshotFileBasePath;
	}

	public void setSnapshotFileBasePath(String snapshotFileBasePath) {
		this.snapshotFileBasePath = snapshotFileBasePath;
	}

	public String getjFileBasePath() {
		return jFileBasePath;
	}

	public void setjFileBasePath(String jFileBasePath) {
		this.jFileBasePath = jFileBasePath;
	}

}
