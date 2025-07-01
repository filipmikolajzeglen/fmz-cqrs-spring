package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.CommandHandler;
import org.springframework.stereotype.Service;

@Service
class SampleCommandHandler implements CommandHandler<SampleCommand, String>
{
   @Override
   public String handle(SampleCommand command)
   {
      return "Handled command: " + command.input;
   }
}