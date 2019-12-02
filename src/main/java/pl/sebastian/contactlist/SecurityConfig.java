package pl.sebastian.contactlist;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    public UserDetailsService userDetailsService() {


        UserDetails user =  User.withDefaultPasswordEncoder()
                .username("user")
                .password("user")
                .roles("USER")
                .build();

//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("ADMIN")
//                .build();

        return new InMemoryUserDetailsManager(user);
    }
    // csrf().disable()
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests()
               .antMatchers("/list_contact").hasRole("USER")
//                .antMatchers("/list_admin").hasAnyRole("ADMIN","USER")
                .anyRequest().permitAll()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();
//                .and()
//                .csrf().disable();
////        http.httpBasic().and().authorizeRequests()
//                .antMatchers(HttpMethod.GET,"/api").permitAll()
//                .antMatchers(HttpMethod.POST,"/api").hasAnyRole("MODERATOR","ADMIN")
//                .antMatchers(HttpMethod.DELETE,"/api").hasRole("ADMIN")
//                .anyRequest().hasRole("ADMIN")
//                .and().formLogin().permitAll()
//                .and()
//                .logout().permitAll()
//                .and()
//                .csrf().disable();


    }



}