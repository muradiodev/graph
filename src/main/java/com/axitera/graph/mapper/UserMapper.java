package com.axitera.graph.mapper;


import com.axitera.graph.entity.Users;
import com.axitera.graph.model.EmployeesView;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
//@Mapper(componentModel = "spring")
public abstract class UserMapper {

    public static UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);


    public abstract EmployeesView getEmployeeView(Users users);

    public abstract List<EmployeesView> getEmployeeViewList(List<Users> users);

}
