/* PriorityPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

/* PriorityPolicy.java */

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityPolicy extends Policy implements Enqueable {
    // Utiliza una PriorityQueue para representar la cola de prioridad
    private PriorityQueue<SimpleProcess> priorityQueue;

    public PriorityPolicy() {
        this.priorityQueue = new PriorityQueue<>(Comparator.comparingLong(SimpleProcess::getProcessingTime));
    }

    @Override
    public void add(SimpleProcess p) {
        // Implementa la lógica de encolar para la política de prioridad
        priorityQueue.add(p);
        size++;
        totalProcesses++;
    }

    @Override
    public void remove() {
        // Implementa la lógica de eliminación para la política de prioridad
        if (!isEmpty()) {
            priorityQueue.poll();
            size--;
        }
    }

    @Override
    public SimpleProcess next() {
        // Implementa la lógica de siguiente para la política de prioridad
        return isEmpty() ? null : priorityQueue.peek();
    }

    // Utiliza el método isEmpty para verificar si la cola está vacía
    private boolean isEmpty() {
        return priorityQueue.isEmpty();
    }
}
