/* Processor.java */

package scheduler;

import scheduler.processing.SimpleProcess;

public class Processor {
    public static void process(SimpleProcess process) {
        try {
            // Simulate processing time by sleeping for the specified duration
            System.out.println("ProcessingTime: " + process.getProcessingTime() * 1000);
            Thread.sleep(process.getProcessingTime());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Processing interrupted: " + e.getMessage());
        }
    }
}
