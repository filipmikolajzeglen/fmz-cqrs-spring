package com.filipmikolajzeglen.cqrs.spring;

import com.filipmikolajzeglen.cqrs.core.Command;

class SampleCommand extends Command<String>
{
   final String input;

   SampleCommand(String input)
   {
      this.input = input;
   }
}