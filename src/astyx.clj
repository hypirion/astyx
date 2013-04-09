(ns astyx
  (:require [instaparse.core :as insta]))

(def ^:private grammar
"exprs = exps
 <exps> = {exp}
 <exp> = list | ws | vec | map | set | num
 list = <'('> exps <')'>
 vec = <'['> exps <']'>
 map = <'{'> exps <'}'>
 set = <'#'><'{'> exps <'}'>
 <num> = int | bigint | ratio | float | bigdec
 int = #'([-+]?)(?:([1-9][0-9]?)[rR]([0-9A-Za-z]+)|0[xX]([0-9A-Fa-f]+)|[0-9]+)'
 bigint = #'([-+]?)(?:([1-9][0-9]?)[rR]([0-9A-Za-z]+)|0[xX]([0-9A-Fa-f]+)|[0-9]+)N'
 ratio = #'[-+]?[0-9]+/[0-9]+'
 float = #'[-+]?[0-9]+(\\.[0-9]*)?([eE][-+]?[0-9]+)?'
 bigdec = #'[-+]?[0-9]+(\\.[0-9]*)?([eE][-+]?[0-9]+)?M'
 <ws> = <#'[\\s,]+'>
")

(def ^:private d
  (insta/parser grammar))

(defn parse [string]
  (d string))
