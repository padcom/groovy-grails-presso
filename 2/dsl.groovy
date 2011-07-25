class DSL {
	void output(s) {
		println s
	}

	int random(int max) {
		new Random().nextInt(max)
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
