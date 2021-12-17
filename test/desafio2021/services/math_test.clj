(ns desafio2021.services.math-test
  (:require [desafio2021.services.math :as services.math]
            [midje.sweet :refer [=> fact facts]]))

(facts "should sum everyone here"
  (fact "should sum positive numbers"
    (services.math/sum 10 20) => 30
    (services.math/sum 12 11) => 23
    (services.math/sum 1 5) => 6)
       
  (fact "sould sum negative numbers too"
    (services.math/sum -1 -3) => -4))

(facts "should subtract everyone here"
  (fact "should subtract positive numbers"
    (services.math/minus 10 20) => -10
    (services.math/minus 12 11) => 1
    (services.math/minus 1 5) => -4)

  (fact "sould subtract negative numbers too")
    (services.math/minus -1 -3) => 2)

(facts "should multiply everyone here"
  (fact "should multiply positive numbers"
    (services.math/times 10 20) => 200
    (services.math/times 12 11) => 132
    (services.math/times 1 5) => 5)

  (fact "sould multiply negative numbers too")
    (services.math/times -1 -3) => 3)

(facts "should divide everyone here"
  (fact "should divide positive numbers"
    (services.math/divide 10 20) => 1/2
    (services.math/divide 12 11) => 12/11
    (services.math/divide 1 5) => 1/5)

  (fact "sould divide negative numbers too")
    (services.math/divide -1 -3) => 1/3)