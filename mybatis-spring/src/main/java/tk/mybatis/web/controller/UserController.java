package tk.mybatis.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import tk.mybatis.web.model.User;
import tk.mybatis.web.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	/**
     * 查询所有用户
     */
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public ModelAndView getAll(){
        List<User> users = userService.getAll();
        
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("users", users);
        
        return mv;
    }
    /**
     * 跳转到添加页面
     */
    @RequestMapping(value = "/insertUserPage",method = RequestMethod.GET)
    public String insertUserPage(){
        return "save";
    }
    /**
     * 插入
     */
    @RequestMapping(value = "/insertUser",method = RequestMethod.POST)
    public String insertUser(User user){
        userService.insertUser(user);
        return "redirect:/getAll";
    }
}
