(require '[cljs.build.api :as b])

(b/watch "src"
  {:main 'super-wasm-tutorial.core
   :output-to "out/super_wasm_tutorial.js"
   :output-dir "out"})
