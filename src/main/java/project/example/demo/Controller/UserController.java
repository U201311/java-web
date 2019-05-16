package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import project.example.demo.Service.UserService;
import project.example.demo.Service.UserServiceImp;
import project.example.demo.model.User;

@RestController
@RequestMapping("/main")
public class UserController {
    @Autowired
    private UserServiceImp userServiceImp;

    /**
     * 登录验证
     * @param username 用户名
     * @param password 用户密码
     * @return boolean
     */
    @RequestMapping("/login/{username}/{password}")
    @ResponseBody
    public boolean logFind(@PathVariable("username") String username,@PathVariable("password") String password){
       // System.out.print(username);
        //System.out.print(password);
        boolean flag=userServiceImp.findUserByname(username,password);
        //System.out.print(flag);
        return flag;
    }

}
