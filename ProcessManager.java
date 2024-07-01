package com.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ProcessManager {
    private List<Process> processList;
    private LinkedList<Process> pendingProcessesHistory;
    private LinkedList<Process> completedProcessesHistory;

    public ProcessManager() {
        processList = new ArrayList<>();
        pendingProcessesHistory = new LinkedList<>();
        completedProcessesHistory = new LinkedList<>();
    }

    // Add Process
    public void addProcess(Process process) {
        processList.add(process);
        if ("Pending".equals(process.getStatus())) {
            addPendingProcess(process);
        } else if ("Completed".equals(process.getStatus())) {
            addCompletedProcess(process);
        }
    }

    // Remove Process
    public boolean removeProcess(int processId) {
        Process processToRemove = null;
        for (Process process : processList) {
            if (process.getProcessId() == processId) {
                processToRemove = process;
                break;
            }
        }
        if (processToRemove != null) {
            processList.remove(processToRemove);
            return true;
        }
        return false;
    }

    // Search for a Process
    public Process searchProcess(int processId) {
        for (Process process : processList) {
            if (process.getProcessId() == processId) {
                return process;
            }
        }
        return null;
    }

    // List All Processes
    public List<Process> listAllProcesses() {
        return new ArrayList<>(processList);
    }

    // Update Process Status
    public boolean updateProcessStatus(int processId, String newStatus) {
        for (Process process : processList) {
            if (process.getProcessId() == processId) {
                process.setStatus(newStatus);
                if ("Pending".equals(newStatus)) {
                    addPendingProcess(process);
                } else if ("Completed".equals(newStatus)) {
                    addCompletedProcess(process);
                }
                return true;
            }
        }
        return false;
    }

    // Pending and Completed Process History
    public void addPendingProcess(Process process) {
        pendingProcessesHistory.add(process);
    }

    public void addCompletedProcess(Process process) {
        completedProcessesHistory.add(process);
    }

    public List<Process> getPendingProcessesHistory() {
        return new ArrayList<>(pendingProcessesHistory);
    }

    public List<Process> getCompletedProcessesHistory() {
        return new ArrayList<>(completedProcessesHistory);
    }
}

