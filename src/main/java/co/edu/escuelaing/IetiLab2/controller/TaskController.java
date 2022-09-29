package co.edu.escuelaing.IetiLab2.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.escuelaing.IetiLab2.dto.TaskDTO;
import co.edu.escuelaing.IetiLab2.entities.Task;
import co.edu.escuelaing.IetiLab2.services.TaskService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v2/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAll() {
        List<TaskDTO> tasks = new ArrayList<>();
        taskService.getAll().forEach((task) -> tasks.add(task.toDTO()));
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTO> findById(@PathVariable String id) {
        Task task = taskService.findById(id);
        if (task == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task.toDTO());
    }

    @PostMapping
    public ResponseEntity<TaskDTO> create(@RequestBody TaskDTO taskDto) {
        Task task = taskService.create(taskDto.toEntity());
        if (task == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(task.toDTO());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> update(@RequestBody TaskDTO task, @PathVariable String id) {
        return ResponseEntity.ok(taskService.update(task.toEntity(), id).toDTO());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        taskService.deleteById(id);
        return ResponseEntity.ok(taskService.findById(id) == null);
    }
}