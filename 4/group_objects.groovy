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
// Original idea by Andrzej Jasiński
// ----------------------------------------------------------------------------

import groovy.transform.*

@ToString
class User {
	String name
	String city
}

def users = [ 
	new User(name: "John Doe", city: "Washington"), 
	new User(name: "Jane Smith", city: "Washington"),
	new User(name: "Bill Wane", city: "Wisconsin")
]

println users.groupBy { it.city }
