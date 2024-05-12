package com.jasonz.systems;

/**
 * Get Actual Memory usage of a process using process id
 */

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class MemoryUsageExample {
    public static void main(String[] args) {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        MemoryUsage heapMemoryUsage = memoryBean.getHeapMemoryUsage();
        MemoryUsage nonHeapMemoryUsage = memoryBean.getNonHeapMemoryUsage();

        System.out.println("Heap Memory Usage:");
        System.out.println("   Initial: " + heapMemoryUsage.getInit());
        System.out.println("   Used: " + heapMemoryUsage.getUsed());
        System.out.println("   Committed: " + heapMemoryUsage.getCommitted());
        System.out.println("   Max: " + heapMemoryUsage.getMax());

        System.out.println("Non-Heap Memory Usage:");
        System.out.println("   Initial: " + nonHeapMemoryUsage.getInit());
        System.out.println("   Used: " + nonHeapMemoryUsage.getUsed());
        System.out.println("   Committed: " + nonHeapMemoryUsage.getCommitted());
        System.out.println("   Max: " + nonHeapMemoryUsage.getMax());
    }
}
