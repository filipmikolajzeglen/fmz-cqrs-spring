package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.persistence.database.DatabaseCommandHandler;
import com.filipmikolajzeglen.cqrs.persistence.database.DatabaseQueryHandler;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Spring configuration for registering CQRS persistence handlers as beans.
 * <p>
 * Registers {@link DatabaseCommandHandler} and {@link DatabaseQueryHandler} using the application's {@link EntityManager}.
 * These beans allow the CQRS dispatcher to handle persistence commands and queries.
 */
@Configuration
public class SpringPersistenceModuleConfiguration
{
   /**
    * Registers a {@link DatabaseQueryHandler} bean for handling database queries.
    *
    * @param entityManager the JPA entity manager
    * @return a new {@link DatabaseQueryHandler} instance
    */
   @Bean
   public DatabaseQueryHandler<?> databaseQueryHandler(EntityManager entityManager)
   {
      return new DatabaseQueryHandler<>(entityManager);
   }

   /**
    * Registers a {@link DatabaseCommandHandler} bean for handling database commands.
    *
    * @param entityManager the JPA entity manager
    * @return a new {@link DatabaseCommandHandler} instance
    */
   @Bean
   public DatabaseCommandHandler<?> databaseCommandHandler(EntityManager entityManager)
   {
      return new DatabaseCommandHandler<>(entityManager);
   }
}
