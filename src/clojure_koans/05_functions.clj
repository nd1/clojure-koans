(ns clojure-koans.05-functions)

(defn multiply-by-ten [n]
  (* 10 n))

(defn square [n] (* n n))

"Calling a function is like giving it a hug with parentheses"
(= __ (square 9))

"Functions are usually defined before they are used"
(= __ (multiply-by-ten 2))

"But they can also be defined inline"
(= __ ((fn [n] (* 5 n)) 2))

"Or using an even shorter syntax"
(= __ (#(* 15 %) 4))

"Even anonymous functions may take multiple arguments"
(= __ (#(+ %1 %2 %3) 4 5 6))

"Arguments can also be skipped"
(= __ (#(str "AA" %2) "bb" "CC"))

"One function can beget another"
(= 9 (((fn [] ___)) 4 5))

"Functions can also take other functions as input"
(= 20 ((fn [f] (f 4 5))
         ___))

"Higher-order functions take function arguments"
(= 25 (___
        (fn [n] (* n n))))

"But they are often better written using the names of functions"
(= 25 (___ square))

(def test-address
  {:street-address "123 Test Lane"
   :city "Testerville"
   :state "TX"})

 "Destructuring is an arbiter: it breaks up arguments"
 (= __ ((fn [[a b]] (str b a))
        [:foo :bar]))

 "Whether in function definitions"
 (= (str "An Oxford comma list of apples, "
         "oranges, "
         "and pears.")
    ((fn [[a b c]] __)
     ["apples" "oranges" "pears"]))

 "Or in let expressions"
 (= "Rich Hickey aka The Clojurer aka Go Time aka Lambda Guru"
    (let [[first-name last-name & aliases]
          (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
      __))

 "You can regain the full argument if you like arguing"
 (= {:original-parts ["Stephen" "Hawking"] :named-parts {:first "Stephen" :last "Hawking"}}
    (let [[first-name last-name :as full-name] ["Stephen" "Hawking"]]
      __))

 "Break up maps by key"
 (= "123 Test Lane, Testerville, TX"
    (let [{street-address :street-address, city :city, state :state} test-address]
      __))

 "Or more succinctly"
 (= "123 Test Lane, Testerville, TX"
    (let [{:keys [street-address __ __]} test-address]
      __))

 "All together now!"
 (= "Test Testerson, 123 Test Lane, Testerville, TX"
    (___ ["Test" "Testerson"] test-address))
