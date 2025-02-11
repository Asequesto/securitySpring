package kz.Aseke.security.securitySpring.controller;

import kz.Aseke.security.securitySpring.model.User;
import kz.Aseke.security.securitySpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserService userService;

    @GetMapping(value = "/")
    public String indexPage(){
        return "index";
    }

    @GetMapping(value = "/sign-in-page")
    public String singInPage(){
        return "sign-in";
    }

    @GetMapping(value = "/sign-up-page")
    public String singUpPage(){
        return "sign-up";
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping(value = "/profile")
    public String profilePage(){
        return "profile";
    }

    @GetMapping(value = "/403-page")
    public String accessDeniedPage(){
        return "403";
    }

    @GetMapping(value = "update-password-page")
    public String updatePasswordPage(){
        return "update-password";
    }

    @PostMapping(value = "/to-sign-up")
    public String toSignUp(@RequestParam(name = "user_email") String email,
                           @RequestParam(name = "user_password") String password,
                           @RequestParam(name = "user_repeat_password") String repeatPassword,
                           @RequestParam(name = "user_full_name") String userFullName){
        if(password.equals(repeatPassword)){
            User user = new User();
            user.setEmail(email);
            user.setPassword(password);
            user.setFullName(userFullName);
            User newUser = userService.addUser(user);
            if(newUser != null){
                return "redirect:/sign-up-page?success";
            }
            else{
                return "redirect:/sign-up-page?email-error";
            }
        }
        else{
            return "redirect:/sign-up-page?password-error";
        }

    }

    @PostMapping(value = "/to-update-password")
    public String toUpdate(@RequestParam(name = "user_old_password") String oldPassword,
                           @RequestParam(name = "user_new_password") String newPassword,
                           @RequestParam(name = "user_repeat_password") String repeatPassword){
        if(newPassword.equals(repeatPassword)){
            User user = userService.updatePassword(newPassword, oldPassword);
            if(user != null){
                return "redirect:/update-password-page?success";
            }
            else{
                return "redirect:/update-password-page?old-password-error";
            }
        }
        else{
            return "redirect:/update-password-page?password-mismatch";
        }

    }

}
