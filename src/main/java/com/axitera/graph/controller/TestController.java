package com.axitera.graph.controller;

import com.axitera.graph.model.EmployeesView;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.Year;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/employees")
public class TestController {
    private final UserService userService;

    record Request(LocalDateTime start, LocalDateTime end) {
    }


    @GetMapping("/")
    public List<EmployeesView> getEmps(@RequestBody Request request) {


        return userService.findAll(request.start, request.end);
    }
}