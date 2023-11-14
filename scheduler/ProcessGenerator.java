/* ProcessStack.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler;

import scheduler.processing.*;

import java.util.Random;

public class ProcessGenerator {
    private int idCounter = 1; // Counter for generating unique process IDs

    public SimpleProcess generateProcess(String processType, int processingTime) {
        switch (processType.toLowerCase()) {
            case "arith":
                return new ArithmeticProcess(idCounter++, processingTime);
            case "io":
                return new IOProcess(idCounter++, processingTime);
            case "cond":
                return new ConditionalProcess(idCounter++, processingTime);
            case "loop":
                return new LoopProcess(idCounter++, processingTime);
            default:
                throw new IllegalArgumentException("Invalid process type: " + processType);
        }
    }

    public void generateRandomProcesses(ProcessQueue queue, int numProcesses, String[] processTypes,
            int[] processingTimes) {
        Random random = new Random();

        for (int i = 0; i < numProcesses; i++) {
            int randomTypeIndex = random.nextInt(processTypes.length);
            int randomTimeIndex = random.nextInt(processingTimes.length);

            String randomType = processTypes[randomTypeIndex];
            int randomTime = processingTimes[randomTimeIndex];

            SimpleProcess process = generateProcess(randomType, randomTime);
            queue.enqueue(process);
        }
    }
}
