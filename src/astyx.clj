(ns astyx
  (:require [instaparse.core :as insta]))

(def ^:private grammar
"<exprs> = {expr}
 <expr> = list | ws | atom | vec | map | set
 list = <'('> exprs <')'>
 vec = <'['> exprs <']'>
 map = <'{'> exprs <'}'>
 set = <'#'><'{'> exprs <'}'>
 atom = #'[a-z]+'
 <ws> = <#'\\s+'>
")

(def ^:private d
  (insta/parser grammar))

(defn parse [string]
  (d string))
