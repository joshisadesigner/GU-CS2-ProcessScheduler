/* PolicyFactory.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.scheduling.policies;

public class PolicyFactory {
    public static Policy createPolicy(String policyType, boolean dualProcessor, long quantum) {
        if ("-fcfs".equals(policyType)) {
            return new FCFSPolicy();
        } else if ("-lcfs".equals(policyType)) {
            return new LCFSPolicy();
        } else if ("-rr".equals(policyType)) {
            return new RRLPolicy(dualProcessor, quantum);
        } else if ("-pp".equals(policyType)) {
            return new PriorityPolicy();
        } else {
            throw new IllegalArgumentException("Tipo de politica invalido: " + policyType);
        }
    }
}
