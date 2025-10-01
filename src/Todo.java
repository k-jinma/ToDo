/**
 * 個々のタスクを表現するクラス
 */
public class Todo {
    private String task;
    private boolean completed;
    
    public Todo(String task) {
        this.task = task;
        this.completed = false;
    }
    
    public String getTask() {
        return task;
    }
    
    public void setTask(String task) {
        this.task = task;
    }
    
    public boolean isCompleted() {
        return completed;
    }
    
    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    
    @Override
    public String toString() {
        return (completed ? "[完了] " : "[未完了] ") + task;
    }
}