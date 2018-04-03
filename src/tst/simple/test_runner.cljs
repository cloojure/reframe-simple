(ns simple.test-runner
  (:require
    [simple.core-test]
    [cljs.test :refer-macros [deftest is testing run-tests]]))

(enable-console-print!)
(println "tests - before")
(run-tests
  'simple.core-test
)
(println "tests - after")


