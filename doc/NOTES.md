# Notes about reading Clojure source

## Symbols

A symbol can not contain the following characters:  
``@ ~ ( ) , \ ; ` [ ] { } ~ ^`` or any form of whitespace

In **addition**, a symbol cannot start with the following characters:  
`: # / '` or any digit

A symbol cannot contain the following patterns:  
`::`  
`:/`  – except if `/` is not the last `/` in the symbol

A symbol cannot end with the following characters:  
`: /`

Exceptions to these rules are the following symbols:  
`/`, `clojure.core/`
