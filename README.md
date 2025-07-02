# FMZ CQRS Spring

The `fmz-cqrs-spring` library provides seamless integration of the CQRS (Command Query Responsibility Segregation) pattern with Spring Framework applications.

## Features

- Automatic registration of a Dispatcher supporting CommandHandler and QueryHandler
- Support for logging and transactional interceptors (Spring Transactional)
- Simple integration with Spring Boot applications

## Installation

Add the dependency to your `pom.xml`:

```xml
<dependency>
  <groupId>com.filipmikolajzeglen.cqrs</groupId>
  <artifactId>fmz-cqrs-spring</artifactId>
  <version>1.0.0</version>
</dependency>
```

## Quick Start

1. Annotate your main application class or configuration class with `@EnableCqrs`:

```java
@SpringBootApplication
@EnableCqrs
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

2. Create your own CommandHandlers and QueryHandlers by implementing the appropriate interfaces from `fmz-cqrs-core`.

## Documentation

- **@EnableCqrs** – annotation enabling CQRS integration in a Spring application.
- **SpringDispatcherConfiguration** – configuration registering the Dispatcher and interceptors.
- **SpringTransactionalCommandInterceptor** – transactional support for commands.
- **SpringTransactionalQueryInterceptor** – transactional (read-only) support for queries.