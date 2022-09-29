package co.edu.escuelaing.IetiLab2.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.escuelaing.IetiLab2.entities.Task;
import co.edu.escuelaing.IetiLab2.repository.TaskRepository;
import co.edu.escuelaing.IetiLab2.services.TaskService;

@Service
public class TaskServiceMongoDB implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceMongoDB(@Autowired TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task create(Task user) {
        return taskRepository.insert(user);
    }

    @Override
    public Task findById(String id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public boolean deleteById(String id) {
        taskRepository.deleteById(id);
        return findById(id) == null;
    }

    @Override
    public Task update(Task user, String id) {
        return taskRepository.save(user);
    }
}