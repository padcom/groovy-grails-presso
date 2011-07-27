package myfirstapp

class Foo {
	String name
	String someField
    
	static constraints = {
		name       nullable: false, blank: false
		someField  nullable: true, blank: true, validator: {
	    	it == 'ala' ? true : ["foo.notAla"]
		}
    }
}
