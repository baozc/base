package cn.baozcc.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

/**
 * 启用权限服务
 * @author baozc
 * @date 2020/6/1 9:03 PM
 */
// @Order(999)
@Configuration
@EnableAuthorizationServer
public class AuthConfigurerAdapter extends AuthorizationServerConfigurerAdapter {

    private static final String RESOURCE_IDS = "order";

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private NoOpPasswordEncoder noOpPasswordEncoder;

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 客户端的注册：本文通过inMemory的方式在内存中注册客户端相关信息；实际项目中可以通过一些管理接口及界面动态实现客户端的注册；
        clients.inMemory() // 使用in-memory存储

                .withClient("client_1")
                .authorizedGrantTypes("client_credentials")
                .scopes("all","read", "write")
                .authorities("client_credentials")
                .accessTokenValiditySeconds(7200)
                .secret(passwordEncoder.encode("123456"))

                .and().withClient("client_2")
                .authorizedGrantTypes("password", "refresh_token")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .authorities("password")
                // .secret(passwordEncoder.encode("123456"))
                .secret(noOpPasswordEncoder.encode("{noop}123456"))

                .and().withClient("client_3").authorities("authorization_code","refresh_token")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("authorization_code")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000)
                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")

                .and().withClient("client_test")
                .secret(passwordEncoder.encode("123456"))
                .authorizedGrantTypes("all flow")
                .authorizedGrantTypes("authorization_code", "client_credentials", "refresh_token","password", "implicit")
                .redirectUris("http://localhost:8080/callback","http://localhost:8080/signin")
                .scopes("all","read", "write")
                .accessTokenValiditySeconds(7200)
                .refreshTokenValiditySeconds(10000);
    }

    /**
     * 获取Token权限控制：客户端需要通过/oauth/token获取Token，此时实际上是未进行登录的，
     * 如果不配置将会报未授权错误；因此需要配置成tokenKeyAccess(“permitAll()”)
     *
     * 校验Token权限控制：资源服务器如果需要调用授权服务器的/oauth/check_token接口校验token有效性，
     * 那么需要配置checkTokenAccess(“hasAuthority(‘ROLE_CLIENT’)”)，注意到角色是
     * ROLE_CLIENT，可见这种情况下资源服务器也需要当成一个客户端来进行注册。
     *
     * @param security
     * @return
     * @author baozc
     * @date 2020年06月03日 21:22:02
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()")
                .checkTokenAccess("hasAuthority('ROLE_CLIENT')")
                .allowFormAuthenticationForClients();
    }

    /**
     * 认证服务端点配置
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {

        // authenticationManager配置：需要通过endpoints.authenticationManager(authenticationManager)
        // 将Security中的authenticationManager配置到Endpoints中，否则，在Spring Security中
        // 配置的权限控制将不会在进行OAuth2相关权限控制的校验时生效。
        endpoints.authenticationManager(authenticationManager);

        // endpoints
        //         //启用oauth2管理
        //         .authenticationManager(authenticationManager)
        //         //用户管理
        //         .userDetailsService(userDetailsService)
        //         //token存到redis
        //         .tokenStore(new RedisTokenStore(redisConnectionFactory))
        //         //接收GET和POST
        //         .allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
    }

}
