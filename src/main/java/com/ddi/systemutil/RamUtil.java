package com.ddi.systemutil;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;

/**
 * RamUtil
 */
public class RamUtil {

	public static void main(String[] args) {

		int mb = 1024 * 1024;
		int gb = mb * 1024;

		OperatingSystemMXBean osMxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

		double ramTotalSize = osMxBean.getTotalPhysicalMemorySize();
		double ramFreeSize = osMxBean.getFreePhysicalMemorySize();
		double ramFreePercentage = (ramFreeSize / ramTotalSize) * 100;
		double ramUsedSize = ramTotalSize - ramFreeSize;
		double ramUsedPercentage = (ramUsedSize / ramTotalSize) * 100;

		System.out.println("START...");

		for (int i = 0; i < 20; i++) {
			System.out.println("Iteration " + (i + 1));

			System.out.println("* Total Physical Memory Size : " + ramTotalSize / gb + " - GB");
			System.out.println(
					"* Used Physical Memory Size : " + ramUsedSize / gb + " - GB  -  In % :  " + ramUsedPercentage);
			System.out.println(
					"* Free Physical Memory Size : " + ramFreeSize / gb + " - GB  -  In % :  " + ramFreePercentage);

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}

		System.out.println("END...");
	}
}