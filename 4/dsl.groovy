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
// ----------------------------------------------------------------------------

class DSL {
	def generator = new Random()

	void output(s) {
		println s
	}

	int random(int max) {
		generator.nextInt(max)
	}

	static execute(Closure program) {
		def dsl = new DSL()
		program.delegate = dsl
		program.resolveStrategy = Closure.DELEGATE_FIRST
		program()
	}
}


DSL.execute {
	output random(100)
}
