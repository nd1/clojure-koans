(ns clojure-koans.04-collections
  [:require [clojure.string :as string]])

"A keyword is a symbol that starts with :"
  (= __ (keyword "foo"))
  (= :foo (keyword "foo"))

  "And you can get name the name of keyword"
  (= __ (name :key))
  (= "key" (name :key))

  "A string is nothing more than text surrounded by double quotes"
  (= __ "hello")
  (= (name :hello) "hello")

  "But double quotes are just magic on top of something deeper"
  (= __ (str 'world))
  (= "world" (str 'world))

  "You can do more than create strings, you can put them together"
  (= "Cool right?" (str __ __))
  (= "Cool right?" (str "Cool right?"))

  "You can even get certain characters"
  (= \C (get "Characters" __))
  (= \C (get "Characters" 0))

  "Or even count the characters"
  (= __ (count "Hello World"))
  (= 11 (count "Hello World"))

  "But strings and characters are not the same"
  (= __ (= \c "c"))
  (= false (= \c "c"))

  "How about joining together elements in a list?"
  (= __ (string/join '(1 2 3)))
  (= "123" (clojure.string/join '(1 2 3)))

  "What if you wanted to separate them out?"
  (= "1, 2, 3" (string/join __ '(1 2 3)))
  (= "1, 2, 3" (clojure.string/join ", " '(1 2 3)))

  "Maybe you want to find the index of the first occurrence of a substring"
  (= 0 (string/index-of "hello world" __))
  (= 0 (clojure.string/index-of "hello world" "h"))

  "Or maybe the last index of the same"
  (= __ (string/last-index-of "hello world, hello" "hello"))
  (= 13 (clojure.string/last-index-of "hello world, hello" "hello"))

  "But when something doesn't exist, nothing is found"
  (= __ (string/index-of "hello world" "bob"))
  (= nil (clojure.string/index-of "hello world" "bob"))

  "Sometimes you don't want whitespace cluttering the front and back"
  (= __ (string/trim "  \nhello world \t \n"))
  (= "hello world" (clojure.string/trim "  \nhello world \t \n"))

  "You can check if something is a char"
  (= __ (char? \c))
  (= true (char? \c))

  "But it may not be"
  (= __ (char? "a"))
  (= false (char? "a"))

  "But chars aren't strings"
  (= __ (string? \b))
  (= false (string? \b))

  "Strings are strings"
  (= true (string? "true"))

  "Some strings may be blank"
  (= __ (string/blank? ""))
  (= true (clojure.string/blank? ""))

  "Even if at first glance they aren't"
  (= __ (string/blank? " \n \t  "))
  (= true (clojure.string/blank? " \n \t  "))

  "However, most strings aren't blank"
  (= __ (string/blank? "hello?\nare you out there?"))
  (= false (clojure.string/blank? "hello?\nare you out there?"))
