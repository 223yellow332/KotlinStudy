package com.example.blog

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BlogConfiguration {

    @Bean
    fun databaseInitializer(userRepository: UserRepository,
                            articleRepository: ArticleRepository) = ApplicationRunner {

        val johnDoe = userRepository.save(Users("johnDoe", "john", "Doe"))
        articleRepository.save(Article(
                title = "Lorem",
                headline = "lorem",
                content = "dolor sit amet",
                author = johnDoe
        ))
        articleRepository.save(Article(
                title = "Ipsum",
                headline = "Ipsum",
                content = "dolor sit amet",
                author = johnDoe
        ))
    }
}