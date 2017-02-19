(ns step-definitions
  (:require
    [cucumber.runtime.clj :refer [Given When Then]]
   ; [clojure.test :refer :all]
    ))

(println "IN STEP DEFS!!!")

;(use 'cucumber.runtime.clj)

;(use 'clojure.test)

(Given #"^someone else is in the room$" []
       ;(comment  Write code here that turns the phrase above into concrete actions  )

       (println "1")
       (assert (= 1 1))

       )
;
(When #"^I say hello$" []
      (println "2")
      )

(Then #"^they should say hello back to me!$" []
      (println "3")
      )
