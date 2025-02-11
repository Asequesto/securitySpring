package kz.Aseke.security.securitySpring.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TecherController {

    @PreAuthorize("hasAnyAuthority('role_teacher', 'role_admin')")
    @GetMapping(value = "/teacher-panel")
    public String teacherPanel(Model model){
        return "teacher";
    }

}
