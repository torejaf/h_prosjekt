package org.toref.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.toref.model.Todo;

public interface TodoRepo extends CrudRepository<Todo, Long> {
	List<Todo> findByFoodTrue();
	List<Todo> findByTransportTrue();
	List<Todo> findByAssignmentTrue();
}
