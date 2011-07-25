class DSL {
	def generator = new Random()

	void output(s) {
		println s
	}

	int random(int max) {
		generator.nextInt(max)
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
