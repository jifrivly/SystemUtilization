package com.ddi.systemutil;

import java.io.File;

/**
 * DiskUtil
 */
public class DiskUtil {

    public static void main(String[] args) {
        int mb = 1024 * 1024;
        int gb = mb * 1024;

        File disk = new File("/");

		long totalSpace = disk.getTotalSpace();

		// previos data
		long prevFreeSpace = -1;
		long prevUsableSpace = -1;

		// next data
		long nextFreeSpace = -1;
		long nextUsableSpace = -1;

		// changes
		long utilOfFreeSpaceInSecond = 0;
		long utilOfUsableSpaceInSecond = 0;

		
        
        System.out.println("START...");

		for (int i = 0; i < 60; i++) {
			if( prevFreeSpace == -1 | prevUsableSpace == -1){
				prevFreeSpace = disk.getFreeSpace();
				prevUsableSpace = disk.getUsableSpace();
			}else {
				prevFreeSpace = nextFreeSpace;
				prevUsableSpace = nextUsableSpace;
			}

			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}

			nextFreeSpace = disk.getFreeSpace();
			nextUsableSpace = disk.getUsableSpace();

			utilOfFreeSpaceInSecond = prevFreeSpace - nextFreeSpace;
			utilOfUsableSpaceInSecond = prevUsableSpace - nextUsableSpace;


			System.out.println(
                "Disk Space Utilization in " + (i + 1) + "th second" +
                "\n * Total space : " + (double) totalSpace / gb + " GB " +
				"\n * Free space - Previos : " + prevFreeSpace + " - Next : " + nextFreeSpace +
				"\n * Difference in free space : " + utilOfFreeSpaceInSecond +
                "\n * Usable space - Previos : " + prevUsableSpace + " - Next : " + nextUsableSpace +
				"\n * Difference in usable space : " + utilOfUsableSpaceInSecond
			);

			System.out.println(
                "\n * Total space : " + (double) totalSpace / gb + " GB " +
				"\n * Free space - Previos : " + (double) prevFreeSpace / gb + " GB " + " - Next : " + (double) nextFreeSpace / gb + " GB " +
				"\n * Difference in free space : " + (double)utilOfFreeSpaceInSecond / mb + " MB " +
                "\n * Usable space - Previos : " + (double)prevUsableSpace / gb + " - Next : " + (double) nextUsableSpace / gb + " GB " +
				"\n * Difference in usable space : " + (double)utilOfUsableSpaceInSecond / mb + " MB "
			);

		}

		System.out.println("END...");
    }
}
		// "\n * Previos Usable space : " + (double) prevUsableSpace / gb + " GB " +
		// "\n * Next Usable space : " + (double) nextUsableSpace / gb + " GB "


		// ==============================================
// 		Disk Space Utilization in 10th second
//  * Total space : 479.35162353515625 GB 
//  * Free space - Previos : 498435289088 - Next : 498435289088
//  * Difference in free space : 0
//  * Usable space - Previos : 472218529792 - Next : 472218529792
//  * Difference in usable space : 0


// Disk Space Utilization in 60th second
//  * Total space : 479.35162353515625 GB 
//  * Free space - Previos : 498022805504 - Next : 498015711232
//  * Difference in free space : 7094272
//  * Usable space - Previos : 471806046208 - Next : 471798951936
//  * Difference in usable space : 7094272