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
// Original version taken from Groovy 1.8 release notes.
// ----------------------------------------------------------------------------

def factorial
factorial = { int n, BigInteger accu = 1G ->
    if (n < 2) return accu
    factorial.trampoline(n - 1, n * accu)
}
factorial = factorial.trampoline()

println factorial(1)
println factorial(3)
println factorial(1000)
