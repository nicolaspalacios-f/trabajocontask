package co.edu.escuelaing.IetiLab2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.escuelaing.IetiLab2.entities.Task;

public interface TaskRepository extends MongoRepository<Task, String> {
}
