(ns printer-double-sider.styles
  (:require [garden-watcher.def :refer [defstyles]]
            [garden.units :as u]))

(defstyles style
  [:.print-panel {:margin-bottom (u/px 50)}]
  [:.credits {:margin [[(u/px 50) 0]]
              :text-align "center"}])
