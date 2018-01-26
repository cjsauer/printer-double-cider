(ns printer-double-cider.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [printer-double-cider.core-test]
   [printer-double-cider.common-test]))

(enable-console-print!)

(doo-tests 'printer-double-cider.core-test
           'printer-double-cider.common-test)
