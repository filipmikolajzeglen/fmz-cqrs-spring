package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.Pagination;
import com.filipmikolajzeglen.cqrs.core.QueryHandler;
import org.springframework.stereotype.Service;

@Service
class SampleQueryHandler implements QueryHandler<SampleQuery, String>
{
   @Override
   public <PAGE> PAGE handle(SampleQuery query, Pagination<String, PAGE> pagination)
   {
      return pagination.expandSingle("Result for: " + query.input);
   }
}