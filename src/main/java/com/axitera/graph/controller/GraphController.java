package com.axitera.graph.controller;

import com.axitera.graph.entity.Users;
import com.axitera.graph.model.EmployeesView;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class GraphController {


    private final UserService userService;
    record Request(LocalDateTime start, LocalDateTime end) {
    }

    private LocalDateTime start = LocalDateTime.parse("2017-07-21T00:00:00");
    private LocalDateTime end = LocalDateTime.parse("2018-07-21T23:59:00");

    @RequestMapping("/list")
    public String employeeList(Model model) throws IOException {

        List<EmployeesView> users = userService.findAll(start, end);
        model.addAttribute("employees", users);
        return "employees/listexamp";
    }

    @GetMapping("/add")
    public String addEmployee(Model model) {

        // create model attribute to bind form data
        Users employee = new Users();

        model.addAttribute("employee", employee);

        return "employees/employee-form";
    }

    @GetMapping("/update")
    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {

        // get the employee from the service
        Users employee = userService.findById(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);

        // send over to our form
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Users users) {

        // save the employee
        userService.save(users);

        // use a redirect to prevent duplicated submissions
        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id) {

        // delete employee
        userService.deleteById(id);

        // return to list
        return "redirect:/employees/list";
    }
}
