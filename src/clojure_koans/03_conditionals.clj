(ns clojure-koans.02-conditionals)

"We shall contemplate truth by testing reality, via equality"
(= __ true)

"To understand reality, we must compare our expectations against reality"
(= __ (+ 1 1))

"You can test equality of many things"
(= (+ 3 4) 7 (+ 2 __))

"Some things may appear different, but be the same"
(= __ (= 2 2/1))

"You cannot generally float to heavens of integers"
(= __ (= 2 2.0))

"But a looser equality is also possible"
(= __ (== 2.0 2))

"Something is not equal to nothing"
(= __ (not (= 1 nil)))

"Strings, and keywords, and symbols: oh my!"
(= __ (= "hello" :hello 'hello))

"Make a keyword with your keyboard"
(= :hello (keyword __))

"Symbolism is all around us"
(= 'hello (symbol __))

"What could be equivalent to nothing?"
(= __ nil)

"When things cannot be equal, they must be different"
(not= :fill-in-the-blank __)

  "You will face many decisions"
  (= __ (if (false? (= 4 5))
          :a
          :b))

  "Some of them leave you no alternative"
  (= __ (if (> 4 3)
          []))

  "And in such a situation you may have nothing"
  (= __ (if (nil? 0)
          [:a :b :c]))

  "In others your alternative may be interesting"
  (= :glory (if (not (empty? ()))
              :doom
              __))
