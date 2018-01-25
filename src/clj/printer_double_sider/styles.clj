(ns printer-double-sider.styles
  (:require [garden-watcher.def :refer [defstyles]]
            [garden.units :as u]))

(defstyles style
  [:.app-container {:display "flex"
                    :justify-content "center"
                    :padding-top (u/px 50)}]
  [:.print-panel {:width (u/px 400)}])
