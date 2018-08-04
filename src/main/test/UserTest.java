import com.wx.bean.User;
import com.wx.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest extends BaseTest {
    @Autowired
    UserService userService;
    @Test
    public void test(){
        User user = userService.queryUserById(1);
        System.out.println(user);
    }
}
