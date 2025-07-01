package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.Command;
import com.filipmikolajzeglen.cqrs.core.CommandInvocation;
import com.filipmikolajzeglen.cqrs.core.TransactionalCommandInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SpringTransactionalCommandInterceptor extends TransactionalCommandInterceptor
{
   @Override
   @Transactional
   public <TYPE> TYPE intercept(Command<TYPE> command, CommandInvocation<TYPE> next)
   {
      return super.intercept(command, next);
   }
}