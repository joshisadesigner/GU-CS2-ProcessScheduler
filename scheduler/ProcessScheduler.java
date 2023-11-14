/* ProcessScheduler.java */

/**
 ** Hecho por: Josue De La Cruz - Gabriel Roldan
 ** Carnet: 23007943 - 23004191
 ** Seccion: BN
 **/

import scheduler.ProcessGenerator;
import scheduler.ProcessQueue;
import scheduler.Processor;
import scheduler.processing.SimpleProcess;
import scheduler.scheduling.policies.Policy;

import java.util.Scanner;

public class ProcessScheduler {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java ProcessScheduler [-dual] -policy timeRange arith io cond loop [quantum]");
            return;
        }

        boolean dualProcessor = false;
        int startIndex = 0;

        if ("-dual".equals(args[0])) {
            dualProcessor = true;
            startIndex = 1;
        }

        String policyType = args[startIndex];
        int timeRange = Integer.parseInt(args[startIndex + 1]);
        int arithTime = Integer.parseInt(args[startIndex + 2]);
        int ioTime = Integer.parseInt(args[startIndex + 3]);
        int condTime = Integer.parseInt(args[startIndex + 4]);
        int loopTime = Integer.parseInt(args[startIndex + 5]);

        int quantum = 0; // Default quantum for policies other than Round Robin

        if ("rr".equals(policyType)) {
            if (args.length < startIndex + 7) {
                System.out.println("Quantum is required for Round Robin policy.");
                return;
            }
            quantum = Integer.parseInt(args[startIndex + 6]);
        }

        ProcessQueue processQueue = new ProcessQueue();
        ProcessGenerator processGenerator = new ProcessGenerator();
        Policy policy = PolicyFactory.createPolicy(policyType, dualProcessor, quantum);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            processGenerator.generateRandomProcesses(processQueue, 1, new String[] { "arith", "io", "cond", "loop" },
                    new int[] { arithTime, ioTime, condTime, loopTime });

            System.out.println("Current queue: " + processQueue.toString());
            System.out.println("Policy: " + policy.getClass().getSimpleName());
            System.out.println("Number of processes handled: " + policy.getTotalProcesses());

            SimpleProcess currentProcess = policy.next();

            if (currentProcess != null) {
                System.out.println("Processing: " + currentProcess.toString());
                Processor.process(currentProcess);
                policy.remove();
            }

            System.out.print("Press 'q' to quit or any other key to continue: ");
            String input = scanner.nextLine();

            if ("q".equalsIgnoreCase(input)) {
                break;
            }
        }

        System.out.println("Simulation ended.");
        System.out.println("Processes handled: " + policy.getTotalProcesses());
        System.out.println("Processes remaining: " + processQueue.size());
        System.out.println("Average processing time per process: " + policy.getAverageProcessingTime());
        System.out.println("Policy used: " + policy.getClass().getSimpleName());
    }
}
