(ns datatable.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce debug?
  ^boolean js/goog.DEBUG)

(defonce app-state
  (reagent/atom
   {:text " EMPLOYEE DETAILS"}))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn page [ratom]
  [:p (:text @ratom)

 [:table.table.table-striped.table-bordered
   {:cell-spacing "0" :width "100%"}

          [:thead
           [:tr
            [:th "Emp #"]
            [:th "Emp Name"]
            [:th "Salary"]
            [:th "Commission"]]]
          [:tbody
           [:tr
            [:th {:scope "row"} 1]
            [:td "Mark O"]
            [:td 100000.00]
            [:td 200000.00]]
           [:tr
            [:th {:scope "row"} 2]
            [:td "John D"]
            [:td 300000.00]
            [:td 400000.00]]
           [:tr
            [:th {:scope "row"} 3]
            [:td "Rick jack"]
            [:td 500000.00]
            [:td 600000.00]]
           ]]
])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when debug?
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))
