import java.util.ArrayList;
import java.util.List;

/**
 * ToDoリストの管理を行うクラス
 */
public class TodoManager {
    private List<Todo> todoList;
    
    public TodoManager() {
        this.todoList = new ArrayList<>();
    }
    
    /**
     * タスクを追加する
     */
    public void addTodo(String task) {
        todoList.add(new Todo(task));
    }
    
    /**
     * 全てのタスクを取得する
     */
    public List<Todo> getAllTodos() {
        return new ArrayList<>(todoList);
    }
    
    /**
     * タスクを削除する
     */
    public boolean removeTodo(int index) {
        if (index >= 0 && index < todoList.size()) {
            todoList.remove(index);
            return true;
        }
        return false;
    }
    
    /**
     * タスクの完了状態を切り替える
     */
    public boolean toggleTodoCompletion(int index) {
        if (index >= 0 && index < todoList.size()) {
            Todo todo = todoList.get(index);
            todo.setCompleted(!todo.isCompleted());
            return true;
        }
        return false;
    }
    
    /**
     * タスクの総数を取得する
     */
    public int getTodoCount() {
        return todoList.size();
    }
    
    /**
     * リストが空かどうかを確認する
     */
    public boolean isEmpty() {
        return todoList.isEmpty();
    }
}