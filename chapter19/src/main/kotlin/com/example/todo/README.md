Verify the Spring Boot Kotlin application runs properly:

1. Check existing tasks:
```shell
curl -X GET http://localhost:8080/task
```

2. Add new tasks:
Linux / macOS:
```shell
curl -w "\n" -X POST \
-H "Content-Type: application/json" \
-d '{"description": "write code"}' http://localhost:8080/task

curl -w "\n" -X POST \
-H "Content-Type: application/json" \
-d '{"description": "test"}' http://localhost:8080/task
```

Windows:
```shell
curl -X POST -H "Content-Type: application/json" -d "{"""description""":"""description"""}" http://localhost:8080/task

curl -X POST -H "Content-Type: application/json" -d "{"""description""": """test"""}" http://localhost:8080/task
```

3. Check the tasks where added:
```shell
curl -X GET http://localhost:8080/task
```

4. Delete tasks and validate only the correct tasks are deleted:
```shell
curl -X DELETE http://localhost:8080/task/1

curl -X DELETE http://localhost:8080/task/10
```

5. Check the remaining task:
```shell
curl -X GET http://localhost:8080/task
```

