package com.ddi.systemutil;

import com.sun.management.OperatingSystemMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * CpuUtil
 */
public class CpuUtil {

    public static void main(String[] args) {

        OperatingSystemMXBean osMxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

        System.out.println("START...");

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        Queue<Double> cpuLoadsQueue = new PriorityQueue<Double>();

        System.out.println("|   Current Value     |     Average Value   |");

        for (int i = 0; i < 120; i++) {

            double currentCpuUsage = osMxBean.getSystemCpuLoad();

            System.out.print("|  " + currentCpuUsage + "  |  ");

            cpuLoadsQueue.add(currentCpuUsage);

            if (cpuLoadsQueue.size() == 40) {

                Iterator<Double> que = cpuLoadsQueue.iterator();
                Double sum = 0.0;
                while (que.hasNext()) {
                    sum += que.next();
                }
                Double avg = sum / 40;

                System.out.print(avg);

                cpuLoadsQueue.remove();

            } else {
                System.out.print("No average value");
            }
            System.out.println("  |\n");

            try {
                Thread.sleep(250);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Error : " + e);
            }

        }

        // System.out.println("END...");

        System.out.println("* System CPU % : " + osMxBean.getSystemCpuLoad() * 100 + "%");

        System.out.println("* Available Processors : " + osMxBean.getAvailableProcessors());
    }
}