import java.util.List;
import java.util.Scanner;

/**
 * ユーザーインターフェースを担当するクラス
 */
public class TodoApp {
    private TodoManager todoManager;
    
    public TodoApp() {
        this.todoManager = new TodoManager();
        
    }
    
    /**
     * アプリケーションを開始する
     */
    public void start() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                showMenu();
                String input = scanner.nextLine();
                
                switch (input) {
                    case "1":
                        addTask(scanner);
                        break;
                    case "2":
                        showTasks();
                        break;
                    case "3":
                        removeTask(scanner);
                        break;
                    case "4":
                        toggleTaskCompletion(scanner);
                        break;
                    case "5":
                        exit();
                        return;
                    default:
                        System.out.println("無効な選択です。");
                }
            }
        } catch (Exception e) {
            System.err.println("予期しないエラーが発生しました。アプリケーションを終了します。");
            // 開発者向けには以下をコメントアウトして使用可能
            // System.err.println("詳細: " + e.getMessage());
        }
    }
    
    /**
     * メニューを表示する
     */
    private void showMenu() {
        System.out.println("\n--- ToDoアプリ ---");
        System.out.println("1. タスク追加");
        System.out.println("2. タスク一覧");
        System.out.println("3. タスク削除");
        System.out.println("4. 完了状態切替");
        System.out.println("5. 終了");
        System.out.print("選択してください: ");
    }
    
    /**
     * タスクを追加する
     */
    private void addTask(Scanner scanner) {
        System.out.print("追加するタスク: ");
        String task = scanner.nextLine();
        todoManager.addTodo(task);
        System.out.println("タスクを追加しました。");
    }
    
    /**
     * タスク一覧を表示する
     */
    private void showTasks() {
        System.out.println("\n--- タスク一覧 ---");
        if (todoManager.isEmpty()) {
            System.out.println("タスクはありません。");
        } else {
            List<Todo> todos = todoManager.getAllTodos();
            for (int i = 0; i < todos.size(); i++) {
                System.out.println((i + 1) + ". " + todos.get(i));
            }
        }
    }
    
    /**
     * タスクを削除する
     */
    private void removeTask(Scanner scanner) {
        if (todoManager.isEmpty()) {
            System.out.println("削除するタスクがありません。");
            return;
        }
        
        showTasks();
        System.out.print("削除するタスク番号: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (todoManager.removeTodo(num - 1)) {
                System.out.println("タスクを削除しました。");
            } else {
                System.out.println("無効な番号です。");
            }
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        }
    }
    
    /**
     * タスクの完了状態を切り替える
     */
    private void toggleTaskCompletion(Scanner scanner) {
        if (todoManager.isEmpty()) {
            System.out.println("タスクがありません。");
            return;
        }
        
        showTasks();
        System.out.print("状態を変更するタスク番号: ");
        try {
            int num = Integer.parseInt(scanner.nextLine());
            if (todoManager.toggleTodoCompletion(num - 1)) {
                System.out.println("タスクの状態を変更しました。");
            } else {
                System.out.println("無効な番号です。");
            }
        } catch (NumberFormatException e) {
            System.out.println("数字を入力してください。");
        }
    }
    
    /**
     * アプリケーションを終了する
     */
    private void exit() {
        System.out.println("終了します。");
    }
}