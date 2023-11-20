/* ProcessStack.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

package scheduler;

import scheduler.processing.*;
import java.util.Random;

// Esta clase representa los procesos generados para ser utilizados en el simulador

public class ProcessGenerator {
    private static final Random random = new Random();
    private int idCounter = 1; // contador para generar IDs de procesos unicos

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

    // Método privado para generar un ID aleatorio para un proceso.
    private int generateId() {
        return random.nextInt(1000) + 1; // Generate a random id between 1 and 1000
    }

    public void generateRandomProcesses(
        ProcessQueue queue,
        int numProcesses,
        String[] processTypes,
        long[] processingTimes
    ){

            // i.e.: ProcessTypes: ["arith"], ["io"], ["cond"], ["loop"] <-- length 3
            Random random = new Random();

            for (int i = 0; i < numProcesses; i++) {
                // Se genera un numero aleatoreo para el index del tipo de proceso
                int randomTypeIndex = random.nextInt(processTypes.length); // <-- del 0 al tamaño
                // se genera un numero aleatoreo para el index de tiempos de proceso
                long randomTimeIndex = random.nextInt(processingTimes.length); // <-- del 0 al tamaño

                // System.out.println("randomtimeIndex: " + randomTimeIndex);

                SimpleProcess process;

                // Dependiendo del numero aleatorio creado
                // se selecciona el index de processType para generar el proceso
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
                        throw new IllegalArgumentException("Proceso de tipo invalido: " + randomTypeIndex);
                }

                queue.enqueue(process);
            }
    }
}
