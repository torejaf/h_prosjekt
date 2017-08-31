package org.toref.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "todo")
public class Todo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
	
    public void setId(long id) {
        this.id = id;
    }
	
	public long getId() {
		return this.id;
	}
	
	@Column(name = "task")
	private String task;
	@Column(name = "food")
	private boolean food;
	@Column(name = "transport")
	private boolean transport;
	@Column(name = "Assignment")
	private boolean assignment;
	
	public void setTask(String task) {
		this.task = task;
	}

	public void setFood(boolean food) {
		this.food = food;
	}
	
	public void setTransport(boolean transport) {
		this.transport = transport;
	}

	public void setAssignment(boolean assignment) {
		this.assignment = assignment;
	}
	
	public String getTask() {
		return this.task;
	}

	public boolean isFood() {
		return food;
	}

	public boolean isTransport() {
		return transport;
	}

	public boolean isAssignment() {
		return assignment;
	}
	
    public Todo() {}

    public Todo(String task, boolean food, boolean transport, boolean assignment) {
        this.task = task;
        this.food = food;
        this.transport = transport;
        this.assignment = assignment;
    }
    
}
