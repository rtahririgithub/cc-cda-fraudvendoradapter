package com.telus.subsfraudmgmt.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity 
public class SubsFraudMgmtSvcSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final String ROLE_PUBSUB = "PUBSUB";
	 
	//@Autowired
	//private Config config;
	
	/**
	 * Configure recognized the users and associated roles - in memory authentication scheme. @Autowired is asking to inject auth bean.
	 */
/*	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		WebService telusPubsubSvcConfig = config.getConnections().getWebService("telusPubRestSvc"); 
		//auth.inMemoryAuthentication().withUser(telusPubsubSvcConfig.getUsername().trim()).password(telusPubsubSvcConfig.getPassword().trim()).roles(ROLE_PUBSUB);
        auth.inMemoryAuthentication()
        .passwordEncoder(NoOpPasswordEncoder.getInstance())
        .withUser("20906")
        .password("appcrd")
        .roles("USER");
        
        
	}
*/
	/**
	 *  Secure the endpoins with HTTP Basic authentication and authorize based on role
	 */
/*	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//TODO: remove tfmTransactionListener after teluspubsub change 
		http
		.httpBasic()
        .and()
		.authorizeRequests()
     	//.antMatchers("/fraudVendorAdapterSvc/**").hasRole(ROLE_PUBSUB)
     	//.antMatchers("/tfmTransactionListener").hasRole(ROLE_PUBSUB) 
     	.anyRequest().permitAll() // other requests path let it go without authentication
//      .antMatchers(HttpMethod.POST, "/books").hasRole("ADMIN")
//      .antMatchers(HttpMethod.PUT, "/books/**").hasRole("ADMIN")
		.and()
		.csrf().disable()
		.formLogin().disable();
	}
	
    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
 */
	
	// removed the requirement for authentication altogether and allow anonymous access to the API,
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .anyRequest().permitAll()
                .and()
            .csrf().disable()
            .httpBasic().disable();
    }
    
    
}
