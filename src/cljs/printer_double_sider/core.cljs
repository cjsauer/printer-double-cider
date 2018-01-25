(ns printer-double-sider.core
  (:require [reagent.core :as reagent :refer [atom]]
            [clojure.string :as s]))

(enable-console-print!)

(defn page-ranges
  [n slides-per-page]
  (let [ranges (map (juxt first last)
                    (partition-all slides-per-page (range 1 (inc n))))]
    {:side-one (take-nth 2 ranges)
     :side-two (take-nth 2 (drop 1 ranges))}))

(defn page-range->str
  [[lo hi]]
  (if (= lo hi)
    (str lo)
    (s/join "-" [lo hi])))

(defn page-range-coll->str
  [prs]
  (s/join "," (map page-range->str prs)))

(defonce app-state (atom {:num-pages 30
                          :slides-per-page 3}))

(defn num-input
  [{:keys [id label value change-fn]}]
  [:div.form-group
   [:label {:for id} label]
   [:input.form-control.form-control-lg
    {:id id
     :type "number"
     :value (if (js/isNaN value) 0 value)
     :on-change #(change-fn (try (js/parseInt (.. % -target -value))
                                 (catch js/Error e 0)))}]])

(defn range-output
  [{:keys [side-key num-pages slides-per-page]}]
  (let [range-str (-> (page-ranges num-pages slides-per-page)
                      side-key
                      page-range-coll->str)]
    [:div.form-group
     [:label
      {:for (str side-key)}
      (case side-key
        :side-one "Side one"
        :side-two "Side two")]
     [:textarea.form-control
      {:value (str range-str)
       :readOnly true}]]))

(defn credits
  []
  [:span.credits "Created with ❤ for B"])

(defn print-panel [{:keys [num-pages slides-per-page]}]
  [:div.print-panel
   [:h1 "Printer Double Sider"]
   [:form
    [num-input {:id "num-pages-input"
                :label "Number of pages"
                :value num-pages
                :change-fn #(swap! app-state assoc :num-pages %)}]
    [num-input {:id "slides-per-page-input"
                :label "Slides per page"
                :value slides-per-page
                :change-fn #(swap! app-state assoc :slides-per-page %)}]
    [range-output {:side-key :side-one
                   :num-pages num-pages
                   :slides-per-page slides-per-page}]
    [range-output {:side-key :side-two
                   :num-pages num-pages
                   :slides-per-page slides-per-page}]]])

(defn app
  []
  [:div.app-container
   [print-panel @app-state]
   [credits]])

(defn render []
  (reagent/render [app] (js/document.getElementById "app")))

(comment

  (range 41)

  )
