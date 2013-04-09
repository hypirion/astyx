# Astyx

A Clojure library with one thing in mind: Returning abstract syntax trees from
Clojure programs.

## Quickstart

To use Astyx, simply add the following file to your Leiningen dependencies:

```clj
[astyx "1.0.0-SNAPSHOT"] ;; Working on the real deal
```

Then, in a file where you need to fetch the AST of a Clojure snippet:

```clj
(ns your.namespace
  (:require [astyx :as ast]))
```

Now, using Astyx is a piece of cake, really:

```clj
(ast/parse "(defn foo [bar baz] (+ bar baz))")

;=> [:paren defn foo [:vector bar baz] [:paren + bar baz]]
```

## License

Copyright © 2013 Jean Niklas L'orange

Distributed under the Eclipse Public License, the same as Clojure.
