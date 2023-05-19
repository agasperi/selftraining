(ns super-wasm-tutorial.core
  (:require [clojure.browser.repl :as repl]))

;; (defonce conn
;;   (repl/connect "http://localhost:9000/repl"))

(enable-console-print!)

(.then (. js/WebAssembly instantiateStreaming (js/fetch "calc.wasm"))
       (fn [obj] (js/console.log (obj/instance.exports.add 1 2))))
