package ru.zhuravel.configuration;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import ru.zhuravel.service.TaskRemoteService;

@Configuration
@Import(DatabaseConfiguration.class)
@ComponentScan("ru.zhuravel.service.impl")
public class ServerConfiguration {

    @Bean
    public Server server(TaskRemoteService taskRemoteService) throws Exception {
        int port = Integer.parseInt(System.getProperty("server.port"));
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(port).build();
        ResourceConfig resourceConfig = new ResourceConfig()
                .register(taskRemoteService)
                .register(MoxyJsonFeature.class);

        Server server = JettyHttpContainerFactory.createServer(baseUri, resourceConfig);
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                server.stop();
            } catch (Exception e) {
                // ignore;
            }
        }));

        return server;
    }

}
