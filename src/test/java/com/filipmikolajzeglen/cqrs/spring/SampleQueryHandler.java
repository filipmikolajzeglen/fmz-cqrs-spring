package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.QueryHandler;
import com.filipmikolajzeglen.cqrs.core.ResultStrategy;
import org.springframework.stereotype.Service;

@Service
class SampleQueryHandler implements QueryHandler<SampleQuery, String>
{
   @Override
   public <RESULT> RESULT handle(SampleQuery query, ResultStrategy<String, RESULT> resultStrategy)
   {
      return resultStrategy.expandSingle("Result for: " + query.input);
   }
}