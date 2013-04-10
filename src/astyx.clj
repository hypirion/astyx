(ns astyx
  (:require [instaparse.core :as insta]))

(def ^:private grammar
"exprs = exps ws?
 <exps> = {ws? exp}
 <exp> = list | vec | map | set | num
       | string | regex | comment | literal
 list = <'('> exps <')'>
 vec = <'['> exps <']'>
 map = <'{'> exps <'}'>
 set = <'#{'> exps <'}'>
 <num> = int | ratio | float | big
 int = #'([-+]?)(?:([1-9][0-9]?)[rR]([0-9A-Za-z]+)|0[xX]([0-9A-Fa-f]+)|[0-9]+)'
 big = int <'N'> | float <'M'>
 ratio = #'[-+]?[0-9]+/[0-9]+'
 float = #'[-+]?[0-9]+(\\.[0-9]*)?([eE][-+]?[0-9]+)?'
 string = #'\"(\\\\\"|[^\"])*\"'
 regex =  #'#\"(\\\\\"|[^\"])*\"'
 comment = #';[^\\n\\r]*'
 <literal> = anfn | unquote | unquote-splice | meta
           | var | quote | symbol | keyword | char
 anfn = '#' list
 quote = '\\'' ws? exp
 unquote = <'~'> ws? exp
 unquote-splice = <'~@'> ws? exp
 meta = <'^'> ws? exp
 var = <'#\\''> ws? exp
 symbol = sym-pat | '/' | 'clojure.core/'
 keyword = ':' ':'? sym-pat
 <sym-pat> = #'[^@~(),\\\\;`\\[\\]{}~^\\s:#/\\'\\d](:?[^@~(),\\\\;`\\[\\]{}~^\\s:])*[^@~(),\\\\;`\\[\\]{}~^\\s:/]' 
 char = #'\\\\(newline|space|tab|backspace|formfeed|return|.|\\n)'
 <ws> = <#'[\\s,]+'>
")

(def ^:private d
  (insta/parser grammar))

(defn parse [string]
  (d string))


