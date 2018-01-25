(ns printer-double-sider.core
  (:require [reagent.core :as reagent :refer [atom]]))

(enable-console-print!)

(defn page-ranges
  [n slides-per-page]
  (let [ranges (map (juxt first last)
                    (partition-all slides-per-page (range 1 (inc n))))]
    {:side-one (take-nth 2 ranges)
     :side-two (take-nth 2 (drop 1 ranges))}))

(defonce app-state (atom {:text "Hello Chestnut!"}))

(defn greeting []
  [:h1 (:text @app-state)])

(defn render []
  (reagent/render [greeting] (js/document.getElementById "app")))

(comment

  (range 41)

  )
