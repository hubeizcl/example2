package com.zcl.querybypage;


import java.util.List;

public interface UserService {


    List<User> pageUsersByRole(Query query);
}
