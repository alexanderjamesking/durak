(defproject durak "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [compojure "1.5.1"]
                 [ring/ring-defaults "0.2.1"]]
  :plugins [[lein-ring "0.9.7"]
            [org.clojars.punkisdead/lein-cucumber "1.0.7"]]
  :ring {:handler durak.handler/app}
  :cucumber-feature-paths ["features/"]
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]
                        [info.cukes/cucumber-clojure "1.2.5"]

                        ]}})
