package resource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import model.Task;

@Named
@ApplicationScoped
public class TaskRepository {

	List<Task> tasks = new ArrayList<>();

	@PostConstruct
	public void postConstruct() {
		Task task = new Task();
		task.setId(0);
		task.setName("Pranie");
		task.setDateCreated(new Date());
		tasks.add(task);
	}

	public List<Task> getAllTask() {
		return tasks;
	}

	public void addTask(Task task) {
		tasks.add(task);
	}

	public Task getTask(Integer id) {
		if (id < tasks.size()) {
			return tasks.get(id);
		}
		return null;
	}
	
	public void removeTask(Integer id) {
		tasks.remove(id.intValue());
		resetIds();
	}
	
	private void resetIds(){
		for (int i = 0; i < tasks.size(); i++) {
			Task task = tasks.get(i);
			task.setId(i);
		}
	}
	
	public void editTask(Task task) {
		tasks.set(task.getId(), task);
	}

}
