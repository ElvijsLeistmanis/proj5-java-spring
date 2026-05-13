package lv.venta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public UserDetailsManager createTestusers() {
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		UserDetails ud1 = User.builder().username("user1").password(encoder.encode("123")).authorities("USER").build();
		UserDetails ud2 = User.builder().username("user2").password(encoder.encode("321")).authorities("USER").build();
		UserDetails ud3 = User.builder().username("elvijs").password(encoder.encode("admin")).authorities("ADMIN").build();
		
		InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager(ud1, ud2, ud3);
		return manager;
	}
	
	@Bean
	public SecurityFilterChain configureEndpoints(HttpSecurity http) {
		http.authorizeHttpRequests(
				auth -> auth
				.requestMatchers("/product/crud/all").permitAll()
				.requestMatchers("/product/crud/one?**").permitAll()
				.requestMatchers("/product/crud/all/**").permitAll()
				.requestMatchers("/product/crud/add").hasAuthority("ADMIN")
				.requestMatchers("/product/crud/update/**").hasAllAuthorities("ADMIN", "USER")
				.requestMatchers("/product/crud/delete/**").hasAuthority("ADMIN")
				
				.requestMatchers("/product/filter/price/**").permitAll()
				);
		http.formLogin(auth->auth.permitAll());
		
		return http.build();
	}
	
	
}
