/* ArithmeticProcess.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler.processing;

public class ArithmeticProcess extends SimpleProcess {
    // Additional Attributes
    private int totalProcessingTime; // Processing time for arithmeticProcess
    private int remainingProcessingTime; // Remaining time for Round Robin

    public ArithmeticProcess(int id, int totalProcessingTime) {
        // Call the constructor with provided id
        super(id);
        this.totalProcessingTime = totalProcessingTime;
        this.remainingProcessingTime = totalProcessingTime;
    }

    // totalProcessingTime getter
    public int getProcessingtime() {
        return totalProcessingTime;
    }

    // remainingProcessingTime getter
    public int remainingProcessingTime() {
        return remainingProcessingTime;
    }

    public void setRemainingProcessingTime(int remainingProcessingTime) {
        this.remainingProcessingTime = remainingProcessingTime;
    }
}
