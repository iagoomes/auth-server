package br.com.fiap.postech.authserver.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)  // Desabilitar CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/token").permitAll()  // Permitir acesso ao endpoint de token sem autenticação
                        .requestMatchers("/**").authenticated())  // Todos os outros requests precisam de autenticação
                .httpBasic(httpBasic -> httpBasic.realmName("ClientAuthRealm"));  // Configurar autenticação básica com realm

        return http.build();
    }
}