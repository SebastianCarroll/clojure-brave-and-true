(ns clojure-noob.core-test
  (:require [clojure.test :refer :all]
            [clojure-noob.core :refer :all]))



(deftest insert-method
  (testing "the I can insert and get "
    (is (= 0 
           (do 
             (insert-cache "key1" 0)
             (get-cache "key1"))))))
