# Parameters for CORDIC
# K is x,y bitwidth, L is z bitwidth, R is unrolling factor
x1 ?= 7
x2 ?= 8
radix ?= 2

vlsi:
	mkdir -p vlsi/generated-src
	cd sbt; sbt "run -params_$(K)_$(L)_$(R) --backend v --targetDir ../vlsi/generated-src"

test:
	mkdir -p test/generated-src
	cd sbt; sbt "run -params_$(K)_$(L)_$(R) --test --genHarness --compile --targetDir ../test/generated-src"

debug:
	mkdir -p test/generated-src
	cd sbt; sbt "run -params_$(K)_$(L)_$(R) --test --genHarness --compile --debug --vcd --targetDir ../test/generated-src"

clean:
	rm -rf sbt/target sbt/project vlsi/generated-src/* test/generated-src/*

.PHONY: vlsi test

