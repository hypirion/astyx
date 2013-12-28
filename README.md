# Astyx

A Clojure library with one thing in mind: Returning abstract syntax trees from
Clojure expressions. It's mostly an example of how one can use Instaparse to
generate abstract syntax trees (AST).

Astyx is currently inactive, although it should return mostly correct results.
If you need to generate or handle ASTs of (arbitrary) Clojure code, you should
really use [tools.analyzer][] instead.

[tools.analyzer]: https://github.com/clojure/tools.analyzer


## Quickstart

To use Astyx, simply add the following file to your Leiningen dependencies:

```clj
[astyx "1.0.0-SNAPSHOT"]
```

Then, in a file where you need to fetch the AST of a Clojure snippet:

```clj
(ns your.namespace
  (:require [astyx :as ast]))
```

Now, using Astyx is rather straightforward:

```clj
(ast/parse "(defn foo [bar baz] (+ bar baz))")

=> [:exprs [:list [:symbol "defn"]
                  [:symbol "foo"]
                  [:vec [:symbol "bar"]
                      [:symbol "baz"]]
                  [:list [:symbol "+"]
                         [:symbol "bar"]
                         [:symbol "baz"]]]]
```

## License

Copyright © 2013 Jean Niklas L'orange

Distributed under the Eclipse Public License, the same as Clojure.
