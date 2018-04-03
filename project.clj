(defproject simple "0.10.5"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [org.clojure/core.async "0.3.465" :exclusions [org.clojure/tools.reader]]
                 [cljs-ajax "0.7.3"]
                 [reagent "0.7.0"]
                 [re-frame "0.10.5"]
                 [tupelo "0.9.75"]]

  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-figwheel "0.5.14"]
            [lein-doo "0.1.10"]
            ]
  :hooks [leiningen.cljsbuild]

  :clean-targets ^{:protect false} ["resources/public/js"
                                    "resources/public/tst"  ]
  :cljsbuild {:builds
              [{:id           "dev"
                :source-paths ["src" "test"]
                :figwheel     {:on-jsload "simple.core/run"
                               :open-urls ["http://localhost:3449/example.html"]}
                :compiler     {:main                 "simple.core" ; or "simple.test-runner"
                               :asset-path           "js"
                               :output-to            "resources/public/js/client.js"
                               :output-dir           "resources/public/js"
                               :optimizations        :none
                               :source-map           true
                               :source-map-timestamp true}}
               {:id           "test"
                :source-paths ["src" "test"]
                :figwheel     {:on-jsload "simple.core/run"
                               :open-urls ["http://localhost:3449/tstr.html"]                              }
                :compiler     {:main                 "simple.test-runner" ; or "simple.test-runner"
                               :asset-path           "js"
                               :output-to            "resources/public/tst/client.js"
                               :output-dir           "resources/public/tst"
                               :optimizations        :none
                               :source-map           true
                               :source-map-timestamp true}}
               ]
              }
  :figwheel {:repl false}

  )
