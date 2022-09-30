package pl.coderslab.charity.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import pl.coderslab.charity.service.UserService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService()
    {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("user1")
                .roles("USER")
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }

    @Override  //filtrowanie rzadan ktore przyjda do serwera (sprawdza uprawnienia)
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.GET,"/").permitAll()
//                .antMatchers(HttpMethod.POST,"/").hasAnyRole("USER","ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/").hasRole("ADMIN")
                .antMatchers("/register").permitAll()
                .antMatchers("/donation/new").hasAnyRole("USER","ADMIN")
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

//                .anyRequest().hasRole("admin")

    }
}
