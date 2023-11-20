package scheduler;
/* ProcessScheduler.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

import scheduler.processing.SimpleProcess;
import scheduler.scheduling.policies.Policy;
import scheduler.scheduling.policies.PolicyFactory;
import static scheduler.Processor.process;

import java.util.Random;
import java.util.Scanner;


public class ProcessScheduler {
    // Se generan variables globales a utilizar en diferentes metodos
    static boolean dualProcessor = false;

    static double finalTime = 0;
    static double initialTime = 0;
    static double condTime = 0;

    static int loopTime = 0;
    static int quantum = 0;
    static int startIndex = 0;

    static long arithTime = 0;
    static long ioTime = 0;

    static String policyProcess = "";
    static String timeRange = "";

    public static void main(String[] args) {;

        // Arguments Verification
        String Error = ("Usage: java ProcessScheduler [-dual] -poliy timeRange arith io cond loop [quantum]");

        // Arguments Verification
        if (args.length < 6) {
            System.out.println(Error);
            return;
        }

        // si el argumento inicial es igual a -dual se correra el startIndex
        if ("-dual".equals(args[0])) {
            dualProcessor = true;
            startIndex = 1;
        }

        String policyType = args[startIndex]; // startIndex 0 o 1.

        if ("-fcfs".equals(policyType) || "-lcfs".equals(policyType) || "-rr".equals(policyType) || "-pp".equals(policyType)) {

            if (args[startIndex].equals("-fcfs")) {
                policyProcess = "First Come First Served";
            } else if (args[startIndex].equals("-lcfs")) {
                policyProcess = "Last Come First Served";
            } else if (args[startIndex].equals("-pp")) {
                policyProcess = "Priority Policy";
            } else {
                policyProcess = "Round Robin";

                if (args.length < startIndex + 7) {
                    System.out.println("Quatum es requerido para la politica Round Robin (-rr) ");
                    System.exit(0);
                }
                // [-dual],[-lcfs],[1-2],[2],[2],[2],[2]
                quantum = (int) Double.parseDouble(args[startIndex + 6]);
            }

            timeRange = args[startIndex + 1];
            int splitter = timeRange.indexOf("-");
            String initialTimeStr = timeRange.substring(0, splitter);
            String finalTimeStr = timeRange.substring(splitter + 1);

            initialTime = Double.parseDouble(initialTimeStr);
            finalTime = Double.parseDouble(finalTimeStr);

            // Se obtienen los tiempos de procesos
            arithTime = (long) Double.parseDouble(args[startIndex + 2]);
            ioTime = Long.parseLong(args[startIndex + 3]);
            condTime = Double.parseDouble(args[startIndex + 4]);
            loopTime = Integer.parseInt(args[startIndex + 5]);

        } else {
            System.out.println(Error);
            System.exit(0);
        }

        // Se crea una instancia de ProcessQueue
        ProcessQueue processQueue = new ProcessQueue();
        ProcessGenerator processGenerator = new ProcessGenerator();

        Policy policy = PolicyFactory.createPolicy(policyType, dualProcessor, quantum);

        Scanner scanner = new Scanner(System.in);

        // Initializing the Threads
        Thread simulationThread = new Thread(() -> runSimulation(processQueue, processGenerator, policy));
        Thread inputThread = new Thread(() -> handleInput(scanner, processQueue, policy));

        // Thread Start
        simulationThread.start();
        inputThread.start();

        try {
            simulationThread.join();
            inputThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void runSimulation(ProcessQueue processQueue, ProcessGenerator processGenerator, Policy policy) {
        while (true) {
            processGenerator.generateRandomProcesses(
                    processQueue,
                    1,
                    new String[] { "arith", "io", "cond", "loop" },
                    new long[] { arithTime, ioTime, (long) condTime, loopTime }
            );

            // Display information of current state
            System.out.println();
            System.out.println("Procesos en cola: " + policy.size());
            System.out.println("Politica: " + policyProcess);
            System.out.println("Cantidad de programas procesados: " + policy.totalProcesses());

            SimpleProcess currentProcess = processQueue.dequeue();

            if (currentProcess != null) {
                // Procesa proceso actual y lo agrega
                System.out.println("Procesando: " + currentProcess.toString());
                process(currentProcess);
                policy.add(currentProcess);  // Agregar el proceso procesado a la política
            }

            try {
                Thread.sleep(currentProcess.getProcessingTime() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
        }
    }

    private static void handleInput(Scanner scanner, ProcessQueue processQueue, Policy policy) {
        while (true) {
            System.out.print("Presiona 'q' para salir... \n");
            String input = scanner.nextLine();

            if ("q".equalsIgnoreCase(input)) {

                System.out.println("---------------------------------------------------");
                System.out.println("Simulación terminada.");
                System.out.println("Procesos procesados: " + policy.totalProcesses());
                System.out.println("Procesos restantes en la cola: " + processQueue.size());
                System.out.println("Tiempo promedio de procesamiento por proceso: " +  ((double) policy.totalProcesses() / policy.totalProcesses()));
                System.out.println("Política utilizada: " + policy.getClass().getSimpleName());
                System.out.println("---------------------------------------------------");

                System.exit(0);
            }
        }
    }
}
