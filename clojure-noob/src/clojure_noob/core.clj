(ns clojure-noob.core
  (:gen-class))

;; generate a LRU cache
;; linked list with a hash map for fast access

(def cache (atom {}))
(defn insert-cache [key val] (swap! cache assoc key val))
(defn get-cache [key] (get @cache key))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
