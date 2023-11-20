/* ArithmeticProcess.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.processing;

public class LoopProcess extends SimpleProcess {
    // Additional Attributes
    private final long totalProcessingTime; // Tiempo de proceso para LoopProcess
    private long remainingProcessingTime; // Remaining time for Round Robin

    public LoopProcess(int id, long totalProcessingTime) {
        // Se llama el constructor con id proveido
        super(id);
        this.totalProcessingTime = totalProcessingTime;
        this.remainingProcessingTime = totalProcessingTime;
    }

    // totalProcessingTime getter
    public long getProcessingTime() {
        return totalProcessingTime;
    }

    // remainingProcessingTime getter
    public long remainingProcessingTime() {
        return remainingProcessingTime;
    }

    public void setRemainingProcessingTime(int remainingProcessingTime) {
        this.remainingProcessingTime = remainingProcessingTime;
    }

    @Override
    public String toString() {
        return "[id:" + getId() + ", type: L, time: " + totalProcessingTime + "]";
    }
}
