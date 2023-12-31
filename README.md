# Task-Tracker-Rest-API

This is a RESTful API for managing tasks Deployed on Railways Cloud. It allows you to perform various operations on tasks, including adding, editing, deleting, and fetching tasks.

## 👉 Features this API has

❖ You add a new Task.<br>
❖ You can edit a Task.<br>
❖ You can delete a Task.<br>
❖ You can get a list of all Tasks.<br>
❖ You can get a Task By it's ID.


## API Endpoints

### Base URL
  - https://task-tracker-rest-api-production.up.railway.app

### Get All Tasks

- **Endpoint**: `/tasks`
- **Method**: `GET`
- **Description**: Get a list of all tasks.
- **Response**: JSON array of tasks.

### Get Task by ID

- **Endpoint**: `/tasks/{taskId}`
- **Method**: `GET`
- **Description**: Get a task by its ID.
- **Response**: JSON object of the task.

### Add Task

- **Endpoint**: `/tasks`
- **Method**: `POST`
- **Description**: Add a new task.
- **Request Body**: JSON object representing the task.
- **Response**: JSON object of the newly created task.

### Edit Task

- **Endpoint**: `/tasks/{taskId}`
- **Method**: `PUT`
- **Description**: Update an existing task by its ID.
- **Request Body**: JSON object representing the updated task.
- **Response**: JSON object of the updated task.

### Delete Task

- **Endpoint**: `/tasks/{taskId}`
- **Method**: `DELETE`
- **Description**: Delete a task by its ID.
- **Response**: Status code indicating success or failure.

