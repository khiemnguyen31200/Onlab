package vn.techmaster.demosession.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.demosession.dto.UserDTO;
import vn.techmaster.demosession.exception.UserException;
import vn.techmaster.demosession.model.User;
import vn.techmaster.demosession.request.LoginRequest;
import vn.techmaster.demosession.service.UserService;

@Controller
@RequestMapping("")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping()
    public String HomePage(Model model, HttpSession session) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if(userDTO!=null){
            model.addAttribute("users", userDTO);
        }
        return "index";
    }

    @GetMapping("/login")
    public String HomeLogin(Model model) {
        model.addAttribute("loginrequest", new LoginRequest("", ""));
        return "login";
    }

    @PostMapping("/login")
    public String Login(@Valid @ModelAttribute("loginrequest") LoginRequest loginrequest, BindingResult result,
            Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "login";
        }

        User user;
        try {
            user = userService.login(loginrequest.email(), loginrequest.password());
            session.setAttribute("user", new UserDTO(user.getId(), user.getFullName(), user.getEmail()));
        } catch (UserException e) {
            switch (e.getMessage()) {
                case "Không tồn tại !":
                    result.addError(new FieldError("loginrequest", "password", "Không tồn tại !"));
                    break;
                case "Người dùng chưa được kích hoạt":
                    result.addError(new FieldError("loginrequest", "password", "Người dùng chưa được kích hoạt"));
                    break;

                case "Mật khẩu hoặc tên đăng nhập của bạn đã sai":
                    result.addError(
                            new FieldError("loginrequest", "password", "Mật khẩu hoặc tên đăng nhập của bạn đã sai"));
                    break;

            }
            return "login";
        }
        return "redirect:/";
    }

    @GetMapping("/admin")
    public String ShowAdminRegister(HttpSession session) {
        UserDTO userDTO = (UserDTO) session.getAttribute("user");
        if(userDTO!=null){
            return "admin";
        }
        return "redirect:/";
    }
    @GetMapping("/logout")
    public String Logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/";
    }

    @GetMapping("/register")
    public String HomeRegister() {
        return "register";
    }


    @GetMapping("/foo")
    public String Foo() {
        throw new UserException("Lỗi :");
    }
}
