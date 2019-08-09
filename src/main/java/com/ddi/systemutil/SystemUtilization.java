package com.ddi.systemutil;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.sun.management.OperatingSystemMXBean;

/**
 * SystemUtilization
 */
public class SystemUtilization {

    public static OperatingSystemMXBean osMxBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    public static Queue<Double> cpuLoadsQueue = new PriorityQueue<Double>();

    File storage = new File("/");

    public static void main(String[] args) {

        for (int i = 0; i < 120; i++) {

            double currentCpuUsage = osMxBean.getSystemCpuLoad();

            cpuLoadsQueue.add(currentCpuUsage);

            if (cpuLoadsQueue.size() > 40) {
                cpuLoadsQueue.remove();
            }

            try {
                Thread.sleep(250);
            } catch (Exception e) {
                // TODO: handle exception
            }

        }

    }

    public void getValues() {
        
        // All returning values declaration
        double currentCpu;
        double totalRam;
        double usedRam;
        long totalStorage;
        long freeStorage;
        long rateOfWriting;

        // Calculation for Cpu Utilization
        // Here we take current 40 values (all values) from queue and calculate average  
        Iterator<Double> queue = cpuLoadsQueue.iterator();

        double sum = 0.0;
        while (queue.hasNext()) {
            sum += queue.next();
        }
        double avg = sum / 40;

        currentCpu = avg;


        // Calculation for Ram Utilization
        totalRam = osMxBean.getTotalPhysicalMemorySize();
        usedRam = totalRam - osMxBean.getFreePhysicalMemorySize();

        // Calculation for Storage Utilization
        totalStorage = storage.getTotalSpace();
        freeStorage = storage.getFreeSpace();



    }
}