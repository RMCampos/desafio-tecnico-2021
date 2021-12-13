(ns desafio2021.main
  (:gen-class)
  (:require [desafio2021.services.user :as services.user]
            [desafio2021.services.user-api :as services.user-api]))

(defn -main
  [& args]
  (println "Starting app!")
  (services.user/start-user-service)
  (services.user-api/start-user-api-service))