(ns desafio2021.services.user-api
  (:require [clj-http.client :as http.client]
            [cheshire.core :as json]))

(def random-user-url
  "https://randomuser.me/api/?nat=br")

(defn print-user
  "Function that takes one user as argument and print its information."
  [user]
  (let [user-dob      (:dob user)
        user-name     (:name user)
        user-location (:location user)
        user-login    (:login user)]
    (println "Printing user:")
    (println (str "- Age: " (:age user-dob)))
    (println (str "- Cell: " (:cell user)))
    (println (str "- Date of Birth: " (:date user-dob)))
    (println (str "- E-mail: " (:email user)))
    (println (str "- Name: " (:title user-name) " " (:first user-name) " " (:last user-name)))
    (println (str "- Gender: " (:gender user)))
    (println (str "- Phone: " (:phone user)))
    (println (str "- Location - City: " (:city user-location)))
    (println (str "- Location - Postcode: " (:postcode user-location)))
    (println (str "- Location - State: " (:state user-location)))
    (println (str "- Location - Street: " (:name (:street user-location)) ", " (:number (:street user-location))))
    (println (str "- Login - MD5: " (:md5 user-login)))
    (println (str "- Login - Salt: " (:salt user-login)))
    (println (str "- Login - Password: " (:password user-login)))
    (println (str "- Login - SHA1: " (:sha1 user-login)))
    (println (str "- Login - SHA256: " (:sha256 user-login)))
    (println (str "- Login - Username: " (:username user-login)))
    (println (str "- Login - UUID: " (:uuid user-login)))))

(defn retrieve-random-user
  "Function that retrieves a random user from randomuser.me free web api."
  []
  (let [response-json (http.client/get random-user-url {:accept :json})
        body (:body response-json)
        body-map (json/parse-string body true)
        users (:results body-map)]
    (doseq [user users]
      (print-user user))))

(defn start-user-api-service
  "First function to be called when starting user-api service. This function
   starts the service!"
  []
  (println "Starting user-api-service")
  (retrieve-random-user))