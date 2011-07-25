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

public class Canonical {
	private String prop1;
	private String prop2;

	public Canonical() {
	}

	public Canonical(String prop1, String prop2) {
		this.prop1 = prop1;
		this.prop2 = prop2;
	}

	public String getProp1() {
		return this.prop1;
	}

	public void setProp1(String prop1) {
		this.prop1 = prop1;
	}

	public String getProp2() {
		return this.prop2;
	}

	public void setProp2(String prop2) {
		this.prop2 = prop2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((prop1 == null) ? 0 : prop1.hashCode());
		result = prime * result + ((prop2 == null) ? 0 : prop2.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Canonical other = (Canonical) obj;
		if (prop1 == null) {
			if (other.prop1 != null)
				return false;
		} else if (!prop1.equals(other.prop1))
			return false;
		if (prop2 == null) {
			if (other.prop2 != null)
				return false;
		} else if (!prop2.equals(other.prop2))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Canonical(" + prop1 + ", " + prop2 + ")";
	}

	public static void main(String[] args) {
		Canonical c1 = new Canonical("foo", "bar");
		Canonical c2 = new Canonical("foo", "bar");

		System.out.println(String.format("c1 == c2 = %s", c1.equals(c2)));
		System.out.println(String.format("c1.hashCode() = %s", c1.hashCode()));
		System.out.println(String.format("c2.hashCode() = %s", c2.hashCode()));
		System.out.println(String.format("c1 = %s", c1));
		System.out.println(String.format("c2 = %s", c2));
	}
}
