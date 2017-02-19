(ns step-definitions
  (:require
    [cucumber.runtime.clj :refer [Given When Then]]
   ; [clojure.test :refer :all]
    ))


(Given #"^the cards$" [arg1]

       (println arg1)
       (println (type arg1))



       )

(Given #"^Boris is the attacker$" []
       )

(When #"^Boris attacks with the (\d+)♦$" [arg1]
      (println "Boris attacks with " arg1)
      )

(Then #"^Igor responds with the (\d+)♦$" [arg1]

      (println "Igor responds with " arg1)

      )
