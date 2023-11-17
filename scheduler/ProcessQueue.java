/* ProcessQueue.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler;

import scheduler.processing.SimpleProcess;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ProcessQueue {
    private ConcurrentLinkedQueue<SimpleProcess> queue;

    public ProcessQueue() {
        this.queue = new ConcurrentLinkedQueue<>();
    }

    public void enqueue(SimpleProcess process) {
        queue.add(process);
    }

    public SimpleProcess dequeue() {
        return queue.poll();
    }

    public SimpleProcess peek() {
        return queue.peek();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
