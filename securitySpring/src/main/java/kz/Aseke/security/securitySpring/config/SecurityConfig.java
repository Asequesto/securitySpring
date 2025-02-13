package kz.Aseke.security.securitySpring.config;

import kz.Aseke.security.securitySpring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    public UserService userService(){
        return new UserService();
    };

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {



        http.
                exceptionHandling(ex -> ex
                        .accessDeniedHandler(accessDeniedHandler())  // ✅ Custom Access Denied Handler
                        .authenticationEntryPoint(new Http403ForbiddenEntryPoint()) // 403 error handler
                )
                .formLogin(form -> form
                        .loginPage("/sign-in-page")
                        .loginProcessingUrl("/to-enter")
                        .usernameParameter("user_email")
                        .passwordParameter("user_password")
                        .defaultSuccessUrl("/profile", true)
                        .failureUrl("/sign-in-page?auth-error") // Removed failureHandler()
                        .permitAll()
                )
                .authorizeHttpRequests(auth -> auth
                                .requestMatchers("/", "/sign-in-page", "/sign-up-page", "/to-sign-up", "/css/**", "/js/**").permitAll()
                                .requestMatchers("/api/**").permitAll()
                                .anyRequest().permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/sign-out")
                        .logoutSuccessUrl("/sign-in-page")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .permitAll()
                );
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return (request, response, accessDeniedException) -> {
            response.sendRedirect("/403-page"); // ✅ Redirect to the 403 error page
        };
    }
}
