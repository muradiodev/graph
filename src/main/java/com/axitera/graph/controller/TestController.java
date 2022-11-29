package com.axitera.graph.controller;

import com.axitera.graph.model.EmployeesView;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@CrossOrigin
@RequestMapping("/employees")
public class TestController {
    private final UserService userService;

    record Request(LocalDateTime start, LocalDateTime end) {
    }
    private LocalDateTime start = LocalDateTime.parse("2017-07-21T00:00:00");
    private LocalDateTime end = LocalDateTime.parse("2018-07-21T23:59:00");

    @GetMapping("/")
//    public List<EmployeesView> getEmps(@RequestBody Request request) {
    public List<EmployeesView> getEmps() {
//        return userService.findAll(request.start, request.end);
        return userService.findAll(start, end);
    }
}
