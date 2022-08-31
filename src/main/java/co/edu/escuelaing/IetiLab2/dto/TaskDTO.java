package co.edu.escuelaing.IetiLab2.dto;

import co.edu.escuelaing.IetiLab2.entities.Task;
import co.edu.escuelaing.IetiLab2.enums.Status;

public class TaskDTO {

    String id;
    String name;
    String description;
    Status status;
    String assignedTo;
    String dueDate;
    String createdAt;

    public TaskDTO() {
    }

    public TaskDTO(String id, String name, String description, Status status, String assignedTo, String dueDate,
            String createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.assignedTo = assignedTo;
        this.dueDate = dueDate;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Task toEntity() {
        return new Task(id, name, description, status, assignedTo, dueDate, createdAt);
    }
}
