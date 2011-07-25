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

import groovy.transform.Canonical

@Canonical
class Example {
	String prop1
	String prop2
}

def c1 = new Example(prop1: "foo", prop2: "bar");
def c2 = new Example("foo", "bar");

println "c1 == c2 = ${c1 == c2}"
println "c1.hashCode() = ${c1.hashCode()}"
println "c2.hashCode() = ${c2.hashCode()}"
println "c1 = ${c1}"
println "c2 = ${c2}"
