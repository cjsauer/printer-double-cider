(ns printer-double-sider.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [printer-double-sider.core-test]
   [printer-double-sider.common-test]))

(enable-console-print!)

(doo-tests 'printer-double-sider.core-test
           'printer-double-sider.common-test)
