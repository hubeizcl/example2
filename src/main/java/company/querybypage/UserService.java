package company.querybypage;


import java.util.List;

public interface UserService {


    List<User> pageUsersByRole(Query query);
}
