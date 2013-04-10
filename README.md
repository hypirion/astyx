# Astyx

A Clojure library with one thing in mind: Returning abstract syntax trees from
Clojure expressions.

## Quickstart

To use Astyx, simply add the following file to your Leiningen dependencies:

```clj
[astyx "1.0.0-SNAPSHOT"]
```

Keep in mind that Astyx is currently in heavy development and changes will occur
rather rapidly.

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
