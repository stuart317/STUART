package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 版权所有：宝润兴业科技股份有限公司
 * 类描述：Spring security配置
 * 创建时间：2018/9/24 19:24
 *
 * @author 朱超
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/","/login").permitAll()  // 1  设置Spring security对 /和/login不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //2  设置Spring security的登录也访问路径为/login
                .defaultSuccessUrl("/chat") //3 登录成功后 跳转 /chat路径
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    //4 在内存中配置两个用户stuart和ws，密码和用户名一致，角色是USER
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .inMemoryAuthentication()
                .withUser("stuart").password("stuart").roles("USER")
                .and()
                .withUser("ws").password("ws").roles("USER");*/
        //---------解决程序报错：There is no PasswordEncoder mapped for the id “null”

        //因为Spring security 5.0中新增了多种加密方式，也改变了密码的格式
        //我们要将前端传过来的密码进行某种方式加密，spring security 官方推荐的是使用bcrypt加密方式。

        //修改如下
        auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("stuart").password(new BCryptPasswordEncoder().encode("stuart")).roles("USER")
                .and()
                .withUser("ws").password(new BCryptPasswordEncoder().encode("ws")).roles("USER");
    }

    //5 /resources/static下的静态资源 security不拦截
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/static/**");
    }
}
