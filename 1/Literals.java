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

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;

public class Literals {
	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		names.add("John Doe");
		names.add("Jane Smith");

		Map<String, String> phones = new LinkedHashMap<String, String>();
		phones.put("John Doe", "+1 87234598734");
		phones.put("Jane Smith", "+1 85873483738");

		System.out.println(names);
		System.out.println(names.getClass());
		System.out.println(phones);
		System.out.println(phones.getClass());
	}
}
