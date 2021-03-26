package se.ifmo.ru.Lab4.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


//@Configuration
class MVCConfig: WebMvcConfigurer {
     override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry
                .addResourceHandler("*.html")
                .addResourceLocations("/static/")
    }
//    override fun addViewControllers(registry: ViewControllerRegistry) {
//        registry.addViewController("/login").setViewName("login")
//    }
}