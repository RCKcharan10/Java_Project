# ToDoApp

ToDoApp is a simple Java-based To-Do List application that helps users manage tasks. This app allows users to add tasks, set priorities, mark tasks as completed, and save/load tasks using file handling for persistence. It also includes features like auto-save, sorting tasks, and logging.

## Features

- **Task Management**: Add, remove, and mark tasks as completed.
- **Priority Tasks**: Set a priority for each task.
- **Auto-save**: Tasks are automatically saved to a file every 10 seconds.
- **Sorting**: Tasks can be sorted by priority.
- **Search**: Find tasks by their description.
- **Logging**: Activity logging is enabled to track task changes.
- **Persistence**: All tasks are saved and loaded from a file, so they persist across app runs.

## Getting Started

Follow these instructions to get the project up and running on your local machine.

### Prerequisites

- **Java Development Kit (JDK)**: You must have Java 8 or higher installed. [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **IDE**: Any Java IDE (e.g., IntelliJ IDEA, Eclipse) or a simple text editor with command line.

### Installation

1. **Clone the repository:**

   If you have Git installed, you can clone the repository:

   ```
   bash
   git clone https://github.com/your-username/ToDoApp.git
   cd ToDoApp
    ```
   
2. **Compile the Java files:**

    In your terminal or command prompt, navigate to the project folder and compile the Java files:

    ```
    bash
    javac -Xlint:unchecked ToDoApp.java
    ```

3. **Run the application:**

    To run the app, execute the following command:

   ```
    bash
    java ToDoApp
    Usage
   ```

## Usage

  Once the app is running, you can interact with the following features:
  
  -- Add Task: Type add to create a new task. You can provide a description and set its priority (optional).
  -- List Tasks: Type list to display all tasks with details.
  -- Mark Task as Completed: Type complete and enter the task ID to mark a task as completed.
  -- Remove Task: Type remove and enter the task ID to delete a task.
  -- Sort Tasks: Tasks are automatically sorted by priority.
  -- Search Tasks: Type search and enter a keyword to search for tasks by description.
  -- Exit: Type exit to close the application.
  
## File Handling

  The app automatically saves tasks to a file (tasks.dat) and loads them when the application starts. It uses serialization to store the tasks.
  
  -- Saving Tasks: The tasks are saved every 10 seconds using the AutoSave feature.
  -- Loading Tasks: The tasks are loaded from tasks.dat when the app starts.
  
## AutoSave

  The application includes an AutoSave feature that periodically saves the tasks. This ensures no task data is lost if the app is closed unexpectedly.
  
## Classes

  The project contains the following main classes:
  
  -- ToDoApp: The main class that runs the application.
  -- Task: A base class representing a task with description, completion status, and priority.
  -- PriorityTask: A subclass of Task that includes priority.
  -- AutoSave: A utility class that automatically saves tasks to a file every 10 seconds.
  
## Example

```
  bash
  > add Task 1
  Task added: Task 1
  > add Priority Task 2 with high priority
  Task added with high priority: Task 2
  > list
  1. Task 1 [Completed: No] [Priority: Normal]
  2. Task 2 [Completed: No] [Priority: High]
  > complete 1
  Task 1 completed.
  > remove 2
  Task 2 removed.
```
