package com.ddi.systemutil;

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

    public void getValues(){
        if (cpuLoadsQueue.size() > 40) {
            Double sum = 0.0;
            while (queue.hasNext()) {
                sum += queue.next();
            }
            Double avg = sum / 40;

            System.out.print(avg);
        }
}
}