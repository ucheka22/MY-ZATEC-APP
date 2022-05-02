package com.chike.zatechapp.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Zatec Test Service",
                description = "Rest API to expose Chuck Norris & Star War API",
                contact = @Contact(
                        name = "Ucheka Chike",
                        url = "https://www.linkedin.com/in/ucheka-chike/",
                        email = "ryanucheka@gmail.com"
                ),
                license = @License(
                        name = "MIT Licence",
                        url = "https://github.com/ucheka22/MY-ZATEC-AP/blob/develop/LICENSE")),
        servers = @Server(url = "https://zatech-app.herokuapp.com/")
)
public class SwaggerConfig {

}