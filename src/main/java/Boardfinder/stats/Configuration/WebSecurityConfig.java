
package Boardfinder.stats.Configuration;

import Boardfinder.stats.Security.JwtConfig;
import Boardfinder.stats.Security.JwtTokenAuthenticationFilter;
import Boardfinder.stats.Service.ActiveTokenService;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuration class for handling what paths are open to access and what paths need to be authenticated, 
 * @author Erik
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private JwtConfig jwtConfig;

    @Autowired
    private ActiveTokenService tokenService;
    
    /**
     * Sets the configuration to the accessibility to the stats paths.
     * @param http
     * @throws Exception 
     */
     @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()
                .addFilterAfter(new JwtTokenAuthenticationFilter(jwtConfig, tokenService), UsernamePasswordAuthenticationFilter.class)
                .authorizeRequests()
                 .antMatchers("/promotion/**").permitAll()
                .antMatchers("/displayedboards/**", "/boardsearches/**").hasRole("ADMIN")
                .anyRequest().authenticated();
    }
    
     @Bean
    public JwtConfig jwtConfig() {
        return new JwtConfig();
    }
    
}
