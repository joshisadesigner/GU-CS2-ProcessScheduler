/* FCFSPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.scheduling.policies;

import java.util.concurrent.ConcurrentLinkedQueue;
import scheduler.processing.SimpleProcess;

public class FCFSPolicy extends Policy implements Enqueable {
    // Use a ConcurrentLinkedQueue for the FCFS policy
    private ConcurrentLinkedQueue<SimpleProcess> queue;

    public FCFSPolicy() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    @Override
    public void add(SimpleProcess p) {
        // Enqueue the process at the end of the queue (FCFS)
        queue.add(p);
        size++;
        totalProcesses++;
    }

    @Override
    public void remove() {
        // Remove the process at the front of the queue (FCFS)
        if (!isEmpty()) {
            queue.poll();
            size--;
        }
    }

    @Override
    public SimpleProcess next() {
        // Return the process at the front of the queue (FCFS)
        return queue.peek();
    }

    public boolean isEmpty() {
        // Implement the isEmpty() method for FCFS policy
        return queue.isEmpty();
    }
}
