(do
  (require '[figwheel-sidecar.repl-api :as ra])
  (ra/start-figwheel!
    {:figwheel-options {:server-port 5621}
     :build-ids        ["dev"]
     :all-builds       [{:id           "dev"
                         :figwheel     true
                         :source-paths ["src"]
                         :compiler     {:main           'jsx-to-cljs.cmd
                                        :output-to      "out/jsx_to_cljs.js"
                                        :output-dir     "out"
                                        :target         :nodejs,
                                        :optimizations  :none,
                                        :pretty-print   true,
                                        :parallel-build true
                                        :verbose        false}}]})
  (ra/cljs-repl))

(comment
  (ra/stop-figwheel!))