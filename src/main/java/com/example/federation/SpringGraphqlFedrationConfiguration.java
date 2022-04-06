package com.example.federation;

import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.graphql.execution.ClassNameTypeResolver;
import org.springframework.graphql.execution.GraphQlSource.Builder;

import com.apollographql.federation.graphqljava.Federation;

@Configuration
public class SpringGraphqlFedrationConfiguration {
	@Bean 
	public GraphQlSourceBuilderCustomizer exposeFederation () {
		return builder -> {
			builder.schemaFactory((registry, wiring)-> 
					Federation.transform(registry, wiring).build()
				);
		};
	}

}
