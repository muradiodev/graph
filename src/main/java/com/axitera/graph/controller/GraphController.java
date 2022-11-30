package com.axitera.graph.controller;

import com.axitera.graph.entity.Users;
import com.axitera.graph.model.EmployeesView;
import com.axitera.graph.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;
import java.util.Locale;

@Controller
@RequiredArgsConstructor
@RequestMapping("/employees")
public class GraphController {


    private final UserService userService;

//    record Request(LocalDateTime start, LocalDateTime end) {
//    }


    @RequestMapping("/list")
    public String employeeList(Model model, @RequestParam(value = "date", required = false) String date) {
        String start, end;
        String[] result;
        int year = Year.now().getValue();

        if (date == null) {
            start = (year - 5) + "-01-01T00:00:00";
            end = (year - 4) + "-12-28T23:59:00";
        } else {
            result = date.split("-");
            start = result[0] + "-01-01T00:00:00";
            end = result[1] + "-12-28T23:59:00";
        }

        List<EmployeesView> users = userService.findAll(LocalDateTime.parse(start), LocalDateTime.parse(end));

        model.addAttribute("date", date);
        model.addAttribute("employees", users);
        return "employees/listjs";
    }


//    @GetMapping("/add")
//    public String addEmployee(Model model) {
//
//        // create model attribute to bind form data
//        Users employee = new Users();
//
//        model.addAttribute("employee", employee);
//
//        return "employees/employee-form";
//    }
//
//    @GetMapping("/update")
//    public String updateEmployee(@RequestParam("employeeId") int id, Model model) {
//
//        // get the employee from the service
//        Users employee = userService.findById(id);
//
//        // set employee as a model attribute to pre-populate the form
//        model.addAttribute("employee", employee);
//
//        // send over to our form
//        return "employees/employee-form";
//    }
//
//    @PostMapping("/save")
//    public String saveEmployee(@ModelAttribute("employee") Users users) {
//
//        // save the employee
//        userService.save(users);
//
//        // use a redirect to prevent duplicated submissions
//        return "redirect:/employees/list";
//    }
//
//    @GetMapping("/delete")
//    public String delete(@RequestParam("employeeId") int id) {
//
//        // delete employee
//        userService.deleteById(id);
//
//        // return to list
//        return "redirect:/employees/list";
//    }
}
