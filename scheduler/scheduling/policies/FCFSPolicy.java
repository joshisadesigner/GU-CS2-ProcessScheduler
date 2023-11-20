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
    // Se utiliza ConcurrentLinkedQueue para la politica
    private ConcurrentLinkedQueue<SimpleProcess> queue;

    // Se crea un nuevo ConcurrentLinkedQueue
    public FCFSPolicy() {
        this.queue = new ConcurrentLinkedQueue<>();
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
        return queue.peek();
    }

    // Devuelve si la cola tiene o no procesos
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
