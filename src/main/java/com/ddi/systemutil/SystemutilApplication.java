package com.ddi.systemutil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

@SpringBootApplication
public class SystemutilApplication {

	public static void main(String[] args) {
		// SpringApplication.run(SystemutilApplication.class, args);

		int mb = 1024 * 1024;
		int gb = mb * 1024;

		OperatingSystemMXBean osMxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);


		

	}

}