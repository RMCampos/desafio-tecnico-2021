(ns desafio2021.services.user-test
  (:require [desafio2021.services.user :as services.user]
            [midje.sweet :refer [=> fact facts]]))

(fact "create-user-test simple"
  (let [user-one (services.user/create-user "Ricardo" 32)]
    (:name user-one) => "Ricardo"
    (:age user-one) => 32
    (:employed user-one) => true))

(facts "create-user-test too young to work"
  (fact "baby is too young to work"
    (let [user-one (services.user/create-user "Just a Baby" 2)]
      (:name user-one) => "Just a Baby"
      (:age user-one) => 2
      (:employed user-one) => false))
  (fact "children is too young to work")
    (let [user-one (services.user/create-user "Just a Kid" 9)]
      (:name user-one) => "Just a Kid"
      (:age user-one) => 9
      (:employed user-one) => false)
  (fact "young adult can work")
    (let [user-one (services.user/create-user "Not a kit anymore" 16)]
      (:name user-one) => "Not a kit anymore"
      (:age user-one) => 16
      (:employed user-one) => true))