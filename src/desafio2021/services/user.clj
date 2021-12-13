(ns desafio2021.services.user)

(defn- user-can-work?
  "If user is older than 15, can work :)"
  [age]
  (> age 15))

(defn create-user
  [name age]
  (println (str "Creating user [name=" name "] [age=" age "]"))
  {:name name
   :age age
   :employed (user-can-work? age)})

(defn start-user-service
  []
  (println "Starting user-service")
  (let [user-one   (create-user "Papai Noel" 68)
        user-two   (create-user "Mamãe Noel" 67)
        user-three (create-user "Little child" 11)]

    (if (:employed user-one)
      (println (str "User " (:name user-one) " is employed!!"))
      (println (str "User " (:name user-one) " is too young, can't work!!")))
    
    (if (:employed user-two)
      (println (str "User " (:name user-two) " is employed!!"))
      (println (str "User " (:name user-two) " is too young, can't work!!")))
    
    (if (:employed user-three)
      (println (str "User " (:name user-three) " is employed!!"))
      (println (str "User " (:name user-three) " is too young, can't work!!")))))
