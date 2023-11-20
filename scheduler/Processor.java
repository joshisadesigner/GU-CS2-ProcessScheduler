/* Processor.java */

package scheduler;

import scheduler.processing.SimpleProcess;

// Esta clase simula el procesamiento de un pproceso en un procesador

public class Processor {
    // Metodo estatico que simula el procesamiento de un proceso
    public static void process(SimpleProcess process) {
        try {
            // Simula el tiempo de procesamiento al dormir el hilo durante la duracion del tiempo del proceso
            System.out.println("Tiempo de Proceso: " + process.getProcessingTime() * 1000);
            // Tiempo de proceso en milisegundos
            Thread.sleep(process.getProcessingTime() * 1000);
        } catch (InterruptedException e) {
            // Maneja la interrupcion del hilo, imprimiendo un mensaje de error
            Thread.currentThread().interrupt();
            System.err.println("Proceso Interrumpido: " + e.getMessage());
        }
    }
}
