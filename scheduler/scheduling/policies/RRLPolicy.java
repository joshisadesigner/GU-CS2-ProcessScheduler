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
    // Se utiliza Queue para la politica
    private final Queue<SimpleProcess> queue;

    // Se crea un nuevo Queue
    public RRLPolicy(boolean dualProcessor, long quantum) {
        this.queue = new LinkedList<>();
    }

    // Se agrega el proceso a la cola
    // Se aumenta el tamaño de la politica
    // se aumenta el total de procesos
    @Override
    public void add(SimpleProcess p) {
        queue.add(p);
        size++;
        totalProcesses++;
    }

    // Remueve el proceso en la cola
    // Se reduce el tamaño de la politica
    @Override
    public void remove() {
        if (!isEmpty()) {
            queue.poll();
            size--;
        }
    }

    // Devuelve el proceso al frente de la cola
    @Override
    public SimpleProcess next() {
        return isEmpty() ? null : queue.peek();
    }

    // Devuelve si la cola tiene o no procesos
    private boolean isEmpty() {
        return queue.isEmpty();
    }
}
