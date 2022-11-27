package com.axitera.graph.model;

import com.axitera.graph.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeesView {

    private Users users;
    private List<EmployeesView> children;
    private int tln;
}
