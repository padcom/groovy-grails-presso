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

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {
	public static void main(String[] args) {
		List<String> people = new ArrayList<String>();
		people.add("John Doe");
		people.add("Jane Smith");

		Collections.sort(people, new Comparator<String>() {
			public int compare(String s1, String s2) {
			   return s1.compareToIgnoreCase(s2);
			}
		});

		System.out.println(people);
	}
}
