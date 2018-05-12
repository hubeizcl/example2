package company.sorted;

import java.util.List;

public class Utils {
    public static void swap(List<User> users, int index1, int index2) {
        User user = users.get(index1);
        User user1 = users.get(index2);
        users.set(index1, user1);
        users.set(index2, user);
    }

    public static boolean compare(User x, User o) {
        int i = x.getAge() - o.getAge();
        if (i <= 0) {
            return false;
        }
        return true;
    }

    public static boolean compare(List<User> users, int index1, int index2) {
        int i = users.get(index1).getAge() - users.get(index2).getAge();
        if (i <= 0) return false;
        return true;
    }

}
