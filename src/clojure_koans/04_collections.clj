(ns clojure-koans.02-scalars
      (:require [clojure.set :as set]))

"You can use vectors in clojure as array-like structures"
(= __ (count [42]))
(= 1 (count [42]))

"You can create a vector from a list"
(= __ (vec '(1)))
(= [1] (vec '(1)))

"Or from some elements"
(= __ (vector nil nil))
(= [nil nil] (vector nil nil))

"But you can populate it with any number of elements at once"
(= [1 __] (vec '(1 2)))
(= [1 2] (vec '(1 2)))

"Conjoining to a vector is different than to a list"
(= __ (conj [111 222] 333))
(= [111 222 333] (conj [111 222] 333))

"You can get the first element of a vector like so"
(= __ (first [:peanut :butter :and :jelly]))
(= :peanut (first [:peanut :butter :and :jelly]))

"And the last in a similar fashion"
(= __ (last [:peanut :butter :and :jelly]))
(= :jelly (last [:peanut :butter :and :jelly]))

"Or any index if you wish"
(= __ (nth [:peanut :butter :and :jelly] 3))
(= :jelly (nth [:peanut :butter :and :jelly] 3))

"Equality with collections is in terms of values"
(= (list 1 2 3) (vector 1 2 __))
(= (list 1 2 3) (vector 1 2 3))

"Lists can be expressed by function or a quoted form"
(= '(__ __ __ __ __) (list 1 2 3 4 5))
(= '(1 2 3 4 5) (list 1 2 3 4 5))

"They are Clojure seqs (sequences), so they allow access to the first"
(= __ (first '(1 2 3 4 5)))
(= 1 (first '(1 2 3 4 5)))

"As well as the rest"
(= __ (rest '(1 2 3 4 5)))
(= '(2 3 4 5) (rest '(1 2 3 4 5)))

"Count your blessings"
(= __ (count '(dracula dooku chocula)))
(= 3 (count '(dracula dooku chocula)))

"Before they are gone"
(= __ (count '()))
(= 0 (count '()))

"The rest, when nothing is left, is empty"
(= __ (rest '(100)))
(= () (rest '(100)))

"Conjoining an element to a list isn't hard either"
(= __ (conj '(:a :b :c :d) :e))
(= '(:e :a :b :c :d) (conj '(:a :b :c :d) :e))

"You can use a list like a stack to get the first element"
(= __ (peek '(:a :b :c :d :e)))
(= :a (peek '(:a :b :c :d :e)))

"Or the others"
(= __ (pop '(:a :b :c :d :e)))
(= '(:b :c :d :e) (pop '(:a :b :c :d :e)))

"But watch out if you try to pop nothing"
(= __ (try
        (pop '())
        (catch IllegalStateException e
          "No dice!")))

(= "No dice!" (try (pop '()) (catch IllegalStateException e "No dice!")))

"The rest of nothing isn't so strict"
(= __ (try
        (rest '())
        (catch IllegalStateException e
          "No dice!")))

(= '()(try
        (rest '())
        (catch IllegalStateException e
          "No dice!")))

"You can create a set by converting another collection"
(= #{3} (set __))
(= #{3} (set [3]))

"Counting them is like counting other collections"
(= __ (count #{1 2 3}))
(= 3 (count #{1 2 3}))

"Remember that a set is a *mathematical* set"
(= __ (set '(1 1 2 2 3 3 4 4 5 5)))
(= #{1 2 3 4 5} (set '(1 1 2 2 3 3 4 4 5 5)))

"You can ask clojure for the union of two sets"
(= __ (set/union #{1 2 3 4} #{2 3 5}))
(= #{1 2 3 4 5} (clojure.set/union #{1 2 3 4} #{2 3 5}))

"And also the intersection"
(= __ (set/intersection #{1 2 3 4} #{2 3 5}))
(= #{2 3} (clojure.set/intersection #{1 2 3 4} #{2 3 5}))

"But don't forget about the difference"
(= __ (set/difference #{1 2 3 4 5} #{2 3 5}))
(= #{1 4} (clojure.set/difference #{1 2 3 4 5} #{2 3 5}))

"Don't get lost when creating a map"
(= {:a 1 :b 2} (hash-map :a 1 __ __))
(= {:a 1 :b 2} (hash-map :a 1 :b 2))

"A value must be supplied for each key"
(= {:a 1} (hash-map :a __))
(= {:a 1} (hash-map :a 1))

"The size is the number of entries"
(= __ (count {:a 1 :b 2}))
(= 2 (count {:a 1 :b 2}))

"You can look up the value for a given key"
(= __ (get {:a 1 :b 2} :b))
(= 2 (get {:a 1 :b 2} :b))

"Maps can be used as functions to do lookups"
(= __ ({:a 1 :b 2} :a))
(= 1 ({:a 1 :b 2} :a))

"And so can keywords"
(= __ (:a {:a 1 :b 2}))
(= 1 (:a {:a 1 :b 2}))

"But map keys need not be keywords"
(= __ ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))
(= "Sochi" ({2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"} 2014))

"You may not be able to find an entry for a key"
(= __ (get {:a 1 :b 2} :c))
(= nil (get {:a 1 :b 2} :c))

"But you can provide your own default"
(= __ (get {:a 1 :b 2} :c :key-not-found))
(= :key-not-found (get {:a 1 :b 2} :c :key-not-found))

"You can find out if a key is present"
(= __ (contains? {:a nil :b nil} :b))
(= true (contains? {:a nil :b nil} :b))

"Or if it is missing"
(= __ (contains? {:a nil :b nil} :c))
(= false (contains? {:a nil :b nil} :c))

"Maps are immutable, but you can create a new and improved version"
(= {1 "January" 2 __} (assoc {1 "January"} 2 "February"))

(= {1 "January" 2 "February"} (assoc {1 "January"} 2 "February"))

"You can also create a new version with an entry removed"
(= {__ __} (dissoc {1 "January" 2 "February"} 2))
(= {1 "January"} (dissoc {1 "January" 2 "February"} 2))

"Create a new map by merging"
(= {:a 1 :b 2 __ __} (merge {:a 1 :b 2} {:c 3}))
(= {:a 1 :b 2 :c 3} (merge {:a 1 :b 2} {:c 3}))

"Specify how to handle entries with same keys when merging"
(= {:a 1 :b __ :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))
(= {:a 1 :b 2 :c 3} (merge-with + {:a 1 :b 1} {:b 1 :c 3}))

"Often you will need to get the keys, but the order is undependable"
(= (list __ __ __)
   (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

(= (list 2010 2014 2018) (sort (keys { 2014 "Sochi" 2018 "PyeongChang" 2010 "Vancouver"})))

"You can get the values in a similar way"
(= (list __ __ __)
   (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))

(= (list "PyeongChang" "Sochi" "Vancouver") (sort (vals {2010 "Vancouver" 2014 "Sochi" 2018 "PyeongChang"})))

"You can even iterate over the map entries as a seq"
(= {:a __ :b __}
   (into {}
         (map
          (fn [[k v]] [k (inc v)])
          {:a 1 :b 2})))

(= {:a 2 :b 3}
  (into {}
        (map
          (fn [[k v]] [k (inc v)])
          {:a 1 :b 2})))
