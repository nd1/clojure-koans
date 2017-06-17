(ns clojure-koans.01-quote)

"Wrap a quote around a list to suppress evaluation"
  (= (quote (1 2 3 4 5)) __)

  "There is a shortcut too!"
  (= (quote __) '(1 2 3 4 5))

  "You can quote symbols as well as lists... without evaluation!"
  (= __ (let [age 9] (quote age)))

  "The quote affects all of its arguments, not just the top level"
  (= (list 1 __) '(1 (+ 2 3)))

  "And a bonus brownie points for guessing this one.."
  (= __ (inc 4))


"Answers"

(= (quote (1 2 3 4 5)) '(1 2 3 4 5))

(= (quote (1 2 3 4 5)) '(1 2 3 4 5))

(= 'age (let [age 9] (quote age)))

(= (list 1 '(+ 2 3)) '(1 (+ 2 3)))

(= 5 (inc 4))
