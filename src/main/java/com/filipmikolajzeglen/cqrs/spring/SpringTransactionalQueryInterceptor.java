package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.Query;
import com.filipmikolajzeglen.cqrs.core.QueryInvocation;
import com.filipmikolajzeglen.cqrs.core.ResultStrategy;
import com.filipmikolajzeglen.cqrs.core.TransactionalQueryInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Transactional query interceptor for Spring.
 * Marks query handling as read-only transactional using Spring's @Transactional(readOnly = true) support.
 */
@Component
public class SpringTransactionalQueryInterceptor extends TransactionalQueryInterceptor
{
   @Override
   @Transactional(readOnly = true)
   public <TYPE, RESULT> RESULT intercept(
         Query<TYPE> query, ResultStrategy<TYPE, RESULT> resultStrategy, QueryInvocation<TYPE, RESULT> next)
   {
      return super.intercept(query, resultStrategy, next);
   }
}