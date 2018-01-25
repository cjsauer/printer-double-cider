(ns printer-double-sider.styles
  (:require [garden-watcher.def :refer [defstyles]]
            [garden.units :as u]))

(defstyles style
  [:.app-container {:display "flex"
                    :flex-direction "column"
                    :align-items "center"
                    :padding-bottom (u/px 100)}]
  [:.print-panel :.help-steps {:width (u/px 450)}])
