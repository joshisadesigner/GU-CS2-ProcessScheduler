/* LCFSPolicy.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.scheduling.policies;

import scheduler.processing.SimpleProcess;

public class LCFSPolicy extends Policy implements Enqueable {
    // Implement enqueue, remove, and next methods based on First-Come-First-Served
    // policy
    // You need to implement the methods defined in the Enqueable interface

    @Override
    public void add(SimpleProcess p) {
        // Implement enqueue logic for FCFS policy
    }

    @Override
    public void remove() {
        // Implement remove logic for FCFS policy
    }

    @Override
    public SimpleProcess next() {
        // Implement next logic for FCFS policy
        return null; // Replace null with the actual logic
    }
}
