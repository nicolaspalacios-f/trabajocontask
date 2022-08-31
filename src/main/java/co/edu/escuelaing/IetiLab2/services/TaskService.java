package co.edu.escuelaing.IetiLab2.services;

import java.util.List;

import co.edu.escuelaing.IetiLab2.entities.Task;

public interface TaskService {
    Task create(Task task);

    Task findById(String id);

    List<Task> getAll();

    boolean deleteById(String id);

    Task update(Task task, String id);
}
