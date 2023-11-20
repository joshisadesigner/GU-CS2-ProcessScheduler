/* PolicyFactory.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.scheduling.policies;

public class PolicyFactory {

    // Este metodo crea y retorna una instancia a calendarizar basandose en los parametros
    // Utiliza la variable policyType para decidir el tipo de politica
    public static Policy createPolicy(String policyType, boolean dualProcessor, long quantum) {
        // Chequea si policyType es Firs Come First Served (FCFS)
        if ("-fcfs".equals(policyType)) {
            return new FCFSPolicy();

        // Chequea si policyType es Last Come First Served (LCFS)
        } else if ("-lcfs".equals(policyType)) {
            return new LCFSPolicy();

        // Chequea si policyType es Round Robin (RR)
        } else if ("-rr".equals(policyType)) {
            return new RRLPolicy(dualProcessor, quantum);

        // Chequea si policyType es Priority Policy (PP)
        } else if ("-pp".equals(policyType)) {
            return new PriorityPolicy();

        // Devuelve un mensaje de error si el string de policyType no es reconocido
        } else {
            throw new IllegalArgumentException("Tipo de politica invalido: " + policyType);
        }
    }
}
