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
    private static final Random random = new Random();
    private int idCounter = 1; // Counter for generating unique process IDs

    public SimpleProcess generateProcess(String processType, long processingTime) {
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

    private int generateId() {
        return random.nextInt(1000) + 1; // Generate a random id between 1 and 1000
    }

    public void generateRandomProcesses(
            ProcessQueue queue,
            int numProcesses,
            String[] processTypes,
            long[] processingTimes) {
        Random random = new Random();

        for (int i = 0; i < numProcesses; i++) {
            int randomTypeIndex = random.nextInt(processTypes.length);
            long randomTimeIndex = random.nextInt(processingTimes.length);

            SimpleProcess process;
            switch (processTypes[randomTypeIndex]) {
                case "arith":
                    process = new ArithmeticProcess(generateId(), randomTimeIndex);
                    break;
                case "io":
                    process = new IOProcess(generateId(), randomTimeIndex);
                    break;
                case "cond":
                    process = new ConditionalProcess(generateId(), randomTimeIndex);
                    break;
                case "loop":
                    process = new LoopProcess(generateId(), randomTimeIndex);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid process type: " + randomTypeIndex);
            }

            queue.enqueue(process);
        }
    }
}
