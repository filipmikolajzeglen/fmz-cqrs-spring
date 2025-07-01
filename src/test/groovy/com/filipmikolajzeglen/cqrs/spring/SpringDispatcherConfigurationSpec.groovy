package com.filipmikolajzeglen.cqrs.spring

import com.filipmikolajzeglen.cqrs.core.Dispatcher
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import spock.lang.Specification

class SpringDispatcherConfigurationSpec extends Specification {

   def 'should create dispatcher and sample handlers beans'() {
      given:
      ApplicationContext context = new AnnotationConfigApplicationContext(
            SpringDispatcherConfiguration, SampleCommandHandler, SampleQueryHandler
      )

      expect:
      context.getBean(Dispatcher) != null
      context.getBean(SampleCommandHandler) != null
      context.getBean(SampleQueryHandler) != null
   }
}
