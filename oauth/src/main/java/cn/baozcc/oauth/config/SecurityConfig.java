package cn.baozcc.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/**
 * EnableGlobalMethodSecurity(prePostEnabled = true)，防止出现
 * @author baozc
 * @date 2020/6/1 10:00 PM
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // http
        //         .requestMatchers().antMatchers("/oauth/**","/login/**","/logout/**")
        //         .and()
        //         .authorizeRequests()
        //         .antMatchers("/oauth/**").authenticated()
        //         .antMatchers("/oauth/**").permitAll()
        //         .and()
        //         .formLogin().permitAll(); //新增login form支持用户登录及授权

        // http.authorizeRequests()
        //         .antMatchers("/oauth/**").permitAll()
        //         .anyRequest().authenticated()
        //         .and()
        //         .formLogin().permitAll();

        http
                .requestMatchers().anyRequest()
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("test")
                .password("123456")
                .roles("USER")
                .and()
                .passwordEncoder(noOpPasswordEncoder());
                // .passwordEncoder(passwordEncoder());
    }

    @Bean
    public static NoOpPasswordEncoder noOpPasswordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args){
        String s = new BCryptPasswordEncoder().encode("123");
        String s1 = new BCryptPasswordEncoder().encode("123456");
        System.out.println("-----------s = " + s);
        System.out.println("-----------s = " + s1);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    // @Override
    // @Bean
    // public UserDetailsService userDetailsServiceBean() throws Exception {
    //     return super.userDetailsServiceBean();
    // }

}
