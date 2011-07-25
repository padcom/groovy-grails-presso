// ----------------------------------------------------------------------------
// Copyright 2011 Matthias Hryniszak
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//
// Other available options:
//
// @GrabConfig(systemClassLoader=true)
// @GrabResolver(name='repo2', root='http://repo2.maven.org/')
// @Grapes([
//     @Grab(group='com.google.inject', module='guice', version='3.0')
// ])
//
// ----------------------------------------------------------------------------

@Grab('com.google.inject:guice:3.0')

import com.google.inject.*
import com.google.inject.matcher.*
import org.aopalliance.intercept.*

interface Processor {
	String process(String data)
}

class SimpleProcessor implements Processor {
	@Override
	String process(String data) {
		return "PROCESSED: ${data} (in SimpleProcessor.process)"
	}
}

class ExampleModule extends AbstractModule {
	@Override 
	protected void configure() {
		bind(Processor).to(SimpleProcessor)

		bindInterceptor(Matchers.any(), Matchers.any(), { invocation ->
			invocation.proceed();
		} as MethodInterceptor);
	}
}

def injector  = Guice.createInjector(new ExampleModule())
def processor = injector.getInstance(Processor)

println processor.process("input")
