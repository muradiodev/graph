package com.axitera.graph.controller;

import com.axitera.graph.entity.Users;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping("api/v1/")
public class GraphController {

    private final UserService userService;


    @GetMapping("/graph")
    public ResponseEntity<List<Users>> getAll() {
        log.info("starting getAll: ");
        return ResponseEntity.ok(userService.getAll());
    }

    @GetMapping("/graph/{id}")
    public ResponseEntity<List<Users>> getUsersList(@PathVariable String id) {
        log.info("starting getUsersList:");
//        return ResponseEntity.ok(userService.getAll());
        return null;
    }
}
