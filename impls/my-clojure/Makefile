clojure_MODE ?= clj
#SOURCES_UTIL =
#SOURCES_BASE = src/mal/readline.$(clojure_MODE)
#SOURCES_LISP = src/mal/env.cljc src/mal/core.cljc src/mal/stepA_mal.cljc
#SRCS = src/mal/env.cljc src/mal/core.cljc
#SOURCES = $(SOURCES_BASE) $(SOURCES_LISP)

DEPS = $(if $(filter cljs,$(clojure_MODE)),node_modules,deps)

dist: $(if $(filter cljs,$(clojure_MODE)),node_modules,mal.jar mal)

deps:
	lein deps

mal.jar:
	lein with-profile stepA uberjar
	cp target/stepA_mal.jar $@

SHELL := bash
mal: mal.jar
	cat <(echo -e '#!/bin/sh\nexec java -jar "$$0" "$$@"') mal.jar > $@
	chmod +x mal

src/mal/%.cljc: $(DEPS)
	@true

#src/mal/stepA_mal.cljc: $(DEPS)

target/%.jar: src/mal/%.cljc $(SRCS)
	lein with-profile $(word 1,$(subst _, ,$*)) uberjar

node_modules:
	npm install

clean:
	rm -rf target/ mal.jar mal
