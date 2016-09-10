(ns pets.handlers
    (:require [re-frame.core :as re-frame]
              [pets.db :as db]))

(re-frame/reg-event-db
 :initialize-db
 (fn  [_ _]
   db/default-db))

(re-frame/reg-event-db
 :select-next-pet
 (fn [state [_ current-index]]
  (db/select-next-pet state current-index)))

(re-frame/reg-event-db
 :update-name
 (fn [state [_ new-name]]
  (db/set-name state new-name)))

(re-frame/reg-event-db
 :set-mode
 (fn [state [_ mode]]
  (db/set-mode state mode)))
