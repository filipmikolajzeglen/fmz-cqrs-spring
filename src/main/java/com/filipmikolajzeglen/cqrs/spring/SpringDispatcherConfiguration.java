package com.filipmikolajzeglen.cqrs.spring;

import java.util.List;

import com.filipmikolajzeglen.cqrs.core.CommandHandler;
import com.filipmikolajzeglen.cqrs.core.Dispatcher;
import com.filipmikolajzeglen.cqrs.core.DispatcherDecorator;
import com.filipmikolajzeglen.cqrs.core.DispatcherRegistry;
import com.filipmikolajzeglen.cqrs.core.LoggingCommandInterceptor;
import com.filipmikolajzeglen.cqrs.core.LoggingQueryInterceptor;
import com.filipmikolajzeglen.cqrs.core.QueryHandler;
import com.filipmikolajzeglen.cqrs.core.TransactionalCommandInterceptor;
import com.filipmikolajzeglen.cqrs.core.TransactionalQueryInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring configuration for FMZ CQRS.
 * Registers the Dispatcher bean with support for CommandHandler and QueryHandler,
 * as well as logging and transactional interceptors.
 */
@Slf4j
@Configuration
@EnableTransactionManagement
public class SpringDispatcherConfiguration
{
   @Bean
   public Dispatcher dispatcher(
         List<CommandHandler<?, ?>> commandHandlers,
         List<QueryHandler<?, ?>> queryHandlers)
   {
      log.info("Creating Dispatcher with: {} command handlers and {} query handlers", commandHandlers.size(),
            queryHandlers.size());

      return new DispatcherDecorator(
            new DispatcherRegistry(commandHandlers, queryHandlers),
            List.of(
                  new LoggingCommandInterceptor(),
                  new TransactionalCommandInterceptor()
            ),
            List.of(
                  new LoggingQueryInterceptor(),
                  new TransactionalQueryInterceptor()
            )
      );
   }
}