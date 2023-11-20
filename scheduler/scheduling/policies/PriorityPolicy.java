/* PriorityPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

/* PriorityPolicy.java */

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;
import java.util.concurrent.ConcurrentLinkedQueue;

public class PriorityPolicy extends Policy implements Enqueable {
    // Se utiliza PriorityQueue para la politica
    private ConcurrentLinkedQueue<SimpleProcess> priorityQueue;

    // Se crea un nuevo ConcurrentLinkedQueue
    public PriorityPolicy() {
        this.priorityQueue = new ConcurrentLinkedQueue<>();
    }

    // Se agrega el proceso a la cola
    // Se aumenta el tamaño de la politica
    // se aumenta el total de procesos
    @Override
    public void add(SimpleProcess p) {
        priorityQueue.add(p);
        size++;
        totalProcesses++;
    }

    // Remueve el proceso en la cola
    // Se reduce el tamaño de la politica
    @Override
    public void remove() {
        if (!isEmpty()) {
            priorityQueue.poll();
            size--;
        }
    }

    // Devuelve el proceso al frente de la cola
    @Override
    public SimpleProcess next() {
        return isEmpty() ? null : priorityQueue.peek();
    }

    // Devuelve si la cola tiene o no procesos
    private boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}
