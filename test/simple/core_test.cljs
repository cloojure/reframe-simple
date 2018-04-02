(ns simple.core-test
  (:require
    [cljs.test :refer-macros [deftest is async]]
    [ajax.core :as ajax]
  ))

(deftest t-will-fail
  (is (= 95 (+ 2 3))))
(deftest t-will-succeed
  (is (=  5 (+ 2 3))))

(deftest t-date
  (println "date.now()"  (. js/Date now))
 ;(println "date.today()"  (. js/Date today))
 ;(println "date.today()"  (.today js/Date))
 ;(println "Friday?  "  (->  js/Date .today .is .friday))
 ;(println "Sunday?  "  (->  js/Date .today .is .sunday))
 ;(println "3 days ago:  "  (->  js/Date .today (.add -3) .days ))

 (println "globalName:  " js/globalName)
 (println "globalObject:  " js/globalObject)
 (println "(-> % .-b inc) =>" (-> js/globalObject .-b inc))
 ;(println "(window.hello) =>" (window.hello)) ; works, but annoying
)

;(deftest t-async
;  ; fails due to:
;  ;    Failed to load https://www.google.com/:
;  ;    No 'Access-Control-Allow-Origin' header is present on the requested resource.
;  ;    Origin 'null' is therefore not allowed access.
;  (async done
;    (ajax/GET "http://www.google.com"
;      {:handler
;       (fn [& args]
;         (println "success handler finished"))
;       :error-handler
;       (fn [resp]
;         (is (= (:status-text resp) "Request failed."))
;         (println "error handler finished")
;         (done))
;       })))

