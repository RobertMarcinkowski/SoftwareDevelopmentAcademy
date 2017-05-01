package resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.Task;

@Named
@ApplicationScoped
public class TaskRepository {
	
	private static final Logger LOG = LoggerFactory.getLogger(TaskRepository.class);
	
	List<Task> tasks = new ArrayList<>();
	
	@PostConstruct
	public void postConstruct() {
		Task task = new Task();
		task.setId(1);
		task.setName("Pranie");
		task.setDateCreated(new Date());
		tasks.add(task);
	}
	
	public List<Task> getAllTask() {
		return tasks;
	}
	
	public Task getTask(Integer id) {
		LOG.info("Trying to get task id {}", id);
		for (Task task:tasks) {
			if (task.getId().equals(id)) return task;
		}
		return new Task();
	}
	
	public void addTask(Task task) {
		task.setId(newId());
		LOG.info("Adding new task: {}", task.toString());
		tasks.add(task);
	}
	
	public void deleteTask(Integer id) {
		int index = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getId().equals(id)) index = i;
		}
		tasks.remove(index);	
	}
	
	public void editTask(Task task) {
		Integer id = task.getId();
		int index = 0;
		for (int i = 0; i < tasks.size(); i++) {
			if (tasks.get(i).getId() == id) index = i;
		}
		tasks.set(index, task);
	}
	
	private int newId() {
		int max = 0;
		for (Task task:tasks) {
			if (task.getId() > max) max = task.getId();
		}
		max++;
		return max;
	}
	
}
