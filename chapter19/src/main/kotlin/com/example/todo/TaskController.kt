package com.example.todo

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/task")
class TaskController(val taskService: TaskService) {

    @GetMapping
    fun tasks() = ResponseEntity.ok(taskService.getAll())

    @PostMapping
    fun create(@RequestBody task: Task): ResponseEntity<String> {
        val result = taskService.save(task)

        return ResponseEntity.ok("Added task with description ${result.description}.")
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = if(taskService.delete(id)) {
        ResponseEntity.ok("Task with id $id was deleted.")
    } else {
        ResponseEntity.status(404).body("Task with id $id not found.")
    }
}