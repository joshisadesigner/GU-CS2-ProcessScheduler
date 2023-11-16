/* RRLPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

/* RRLPolicy.java */

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

import java.util.LinkedList;
import java.util.Queue;

public class RRLPolicy extends Policy implements Enqueable {
    private final Queue<SimpleProcess> queue;

    // Constructor con parámetros
    public RRLPolicy(boolean dualProcessor, long quantum) {
        // Implment enqueue, remove and next base in Round Robin policy
        // Needs to implement interface Enqueable defined methods
        this.queue = new LinkedList<>();
        // Initialize class with provided parameters
    }

    @Override
    public void add(SimpleProcess p) {
        // Implements enqueue logic for Round Robin policy
        queue.add(p);
        size++;
        totalProcesses++;
    }

    @Override
    public void remove() {
        // Implements enqueue logic for Round Robin policy
        if (!isEmpty()) {
            queue.poll();
            size--;
        }
    }

    @Override
    public SimpleProcess next() {
        // Implements enqueue logic for Round Robin policy
        return isEmpty() ? null : queue.peek();
    }

    // Verify if queue is empty
    private boolean isEmpty() {
        return queue.isEmpty();
    }
}
