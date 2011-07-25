package myfirstapp

class Foo {

String name
String someField
   
static searchable = true
 
static constraints = {
	name(nullable: false, blank: false)
	someField(nullable: true, blank: true, validator: {
	    if(it == 'ala') return true else return ["foo.notAla"]
	})
    }
}
