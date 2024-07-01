package com.simple;

public class Main {
    public static void main(String[] args) {
        ProcessManager processManager = new ProcessManager();

        // Adding processes
        processManager.addProcess(new Process(1, "Process 1", "Pending"));
        processManager.addProcess(new Process(2, "Process 2", "Running"));
        processManager.addProcess(new Process(3, "Process 3", "Completed"));

        // Listing all processes
        System.out.println("All Processes:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Searching for a process
        System.out.println("Search for process with ID 2:");
        System.out.println(processManager.searchProcess(2));

        // Updating process status
        processManager.updateProcessStatus(1, "Completed");

        // Listing all processes after status update
        System.out.println("All Processes after status update:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Removing a process
        processManager.removeProcess(2);

        // Listing all processes after removal
        System.out.println("All Processes after removal:");
        for (Process process : processManager.listAllProcesses()) {
            System.out.println(process);
        }

        // Listing pending process history
        System.out.println("Pending Processes History:");
        for (Process process : processManager.getPendingProcessesHistory()) {
            System.out.println(process);
        }

        // Listing completed process history
        System.out.println("Completed Processes History:");
        for (Process process : processManager.getCompletedProcessesHistory()) {
            System.out.println(process);
        }
    }
}
