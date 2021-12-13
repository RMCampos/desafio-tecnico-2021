(defproject desafio2021 "0.0.1-SNAPSHOT"
  :description ""
  :url "github"
  :dependencies [[cheshire "5.10.1"]
                 [clj-http "3.12.3"]
                 [org.clojure/clojure "1.10.3"]]
  :profiles {:dev {:env {root-env "dev"}
                   :main desafio2021.main}
             :test {:dependencies [[midje "1.10.4"]]
                    :plugins [[lein-midje "3.2.1" :exclusions [org.clojure/clojure]]]
                    :env {root-env "test"}}})