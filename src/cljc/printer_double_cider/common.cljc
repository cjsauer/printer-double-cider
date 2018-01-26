(ns printer-double-cider.common)

(defn shared-fn
  "A function that is shared between clj and cljs"
  []
  (println "cljc!"))

