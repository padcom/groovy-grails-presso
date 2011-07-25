def people = [ "John Doe", "Jane Smith" ]
people.sort { s1, s2 -> s1.compareToIgnoreCase(s2) }
println people
