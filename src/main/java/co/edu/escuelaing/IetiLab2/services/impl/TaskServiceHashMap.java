package co.edu.escuelaing.IetiLab2.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.edu.escuelaing.IetiLab2.entities.Task;
import co.edu.escuelaing.IetiLab2.services.TaskService;

public class TaskServiceHashMap implements TaskService {

    private HashMap<String, Task> tasks = new HashMap<>();

    @Override
    public Task create(Task task) {
        if (tasks.containsKey(task.getId())) {
            return null;
        }
        tasks.put(task.getId(), task);
        return task;
    }

    @Override
    public Task findById(String id) {
        return tasks.get(id);
    }

    @Override
    public List<Task> getAll() {
        List<Task> resTasks = new ArrayList<>();
        tasks.values().forEach(resTasks::add);
        return resTasks;
    }

    @Override
    public boolean deleteById(String id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }
        return false;
    }

    @Override
    public Task update(Task task, String id) {
        if (!tasks.containsKey(id)) {
            return null;
        }
        deleteById(id);
        return create(task);
    }
}