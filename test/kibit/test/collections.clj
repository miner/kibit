(ns kibit.test.collections
  (:require [kibit.check :as kibit])
  (:use [clojure.test]))

(deftest collections-are
  (are [expected-alt-form test-form]
       (= expected-alt-form (:alt (kibit/check-expr test-form)))
    '(seq a) '(not (empty? a))
    '(when (seq a) b) '(when-not (empty? a) b)
    '(when (seq a) b) '(when (not (empty? a)) b)
    '(vector a) '(conj [] a)
    '(vector a b) '(conj [] a b)
    '(vec coll) '(into [] coll)
    '(set coll) '(into #{} coll)))
