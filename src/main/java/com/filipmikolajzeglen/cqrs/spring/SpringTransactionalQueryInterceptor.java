package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.Pagination;
import com.filipmikolajzeglen.cqrs.core.Query;
import com.filipmikolajzeglen.cqrs.core.QueryInvocation;
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
   public <TYPE, PAGE> PAGE intercept(
         Query<TYPE> query, Pagination<TYPE, PAGE> pagination, QueryInvocation<TYPE, PAGE> next)
   {
      return super.intercept(query, pagination, next);
   }
}