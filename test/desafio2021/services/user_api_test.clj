(ns desafio2021.services.user-api-test
  (:require [clj-http.client :as http.client]
            [clojure.core :refer [with-redefs]]
            [desafio2021.services.user-api :as services.user-api]
            [midje.sweet :refer [=> fact]]))

(def user-test
  {:age 32
   :cell "47991699982"
   :date "27/03/1989"
   :email "rcampos@daitan.com"
   :name {:title "Mr."
          :first "Ricardo"
          :last "Campos"}
   :gender "male"
   :phone "4732270822"
   :location {:city "Joinville"
              :postcode "89228-070"
              :state "Santa Catarina"
              :street {:name "Rua Maracujá" :number 510}}
   :login {:md5 "000-111-222-AAA"
           :salt "123456"
           :password "AAA123"
           :sha1 "AAA-BBB-CCC-9999"
           :sha256 "000-111-222-AAA-256"
           :username "rcampos"
           :uuid "1234567890"}})

(fact "should print user details"
  (services.user-api/print-user user-test))

(fact "should retrieve random user"
  (with-redefs [http.client/get (fn [url] user-test)]
    (let [response (http.client/get "http://test.com")]
      response => user-test)))