/* LCFSPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

import java.util.Stack;  // Agrega esta importación

public class LCFSPolicy extends Policy implements Enqueable {
    // Implement enqueue, remove, and next methods based on First-Come-First-Served
    // policy
    // You need to implement the methods defined in the Enqueable interface

    // Utiliza una Stack para representar la cola LCFS
    private final Stack<SimpleProcess> queue;

    public LCFSPolicy() {
        this.queue = new Stack<>();
    }

    @Override
    public void add(SimpleProcess p) {
        // Implementar lógica de encolar para la política LCFS
        queue.push(p);
        size++;
        totalProcesses++;
    }

    @Override
    public void remove() {
        // Implementar lógica de eliminación para la política LCFS
        if (!isEmpty()) {
            queue.pop();
            size--;
        }
    }

    @Override
    public SimpleProcess next() {
        // Implementar lógica de siguiente para la política LCFS
        return isEmpty() ? null : queue.peek();
    }

    // Utiliza el método empty para verificar si la cola está vacía
    private boolean isEmpty() {
        return queue.empty();
    }
}
