package com.portfolio.api.Security;

import com.portfolio.api.Controller.AuthController;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@AllArgsConstructor
public class WebSecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authManager) throws Exception {

        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();
        jwtAuthenticationFilter.setAuthenticationManager(authManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/login");
        
        return http
            .cors(withDefaults())
            .csrf().disable()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
            .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
            .addFilter(jwtAuthenticationFilter)
            .authorizeRequests()
                .antMatchers("/logout").permitAll()
                .anyRequest().authenticated()
                .and()
            .build();


//        http.logout()
//                .logoutUrl("/logout") // URL para el logout
//                .logoutSuccessUrl("/") // Redirige a la página principal después del logout
//                .invalidateHttpSession(true) // Invalida la sesión HTTP
//                .deleteCookies("JSESSIONID"); // Elimina cookies si las hubiera

//        return http
//                .cors(withDefaults())
//                .csrf().disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                //.and()
//                //.httpBasic()
//                .and()
//                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilter(jwtAuthenticationFilter)
//                .authorizeRequests()
//                //.antMatchers("/home").permitAll()// Permitir acceso sin autenticación a /logout
//                .antMatchers("/logout").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .build();
        
//                .csrf().disable() // Deshabilitar CSRF
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .httpBasic().disable() // Deshabilitar la autenticación básica
//                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .addFilter(jwtAuthenticationFilter)
//                .authorizeRequests()
//                .antMatchers("/**").permitAll() // Permitir todas las solicitudes sin autenticación
//                .anyRequest().authenticated()
//                .and()
//                .build();
    }

//    @Bean
//    UserDetailsService userDetailsService() {
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("admin")
//                .password(passwordEncoder().encode("admin"))
//                .roles()
//                .build());
//        return manager;
//    }
    @Bean
    AuthenticationManager authManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder())
                .and()
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
//    public static void main(String[] args) {
//        System.out.println("pass: " + new BCryptPasswordEncoder().encode("1234"));
//    }
}
