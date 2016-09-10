(ns pets.subs
    (:require-macros [reagent.ratom :refer [reaction]])
    (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 :title
 (fn [db]
   (:title db)))

(re-frame/reg-sub
 :pets
 (fn [db]
   (:pets db)))

(re-frame/reg-sub
 :selected-pet
 (fn [db]
   (:selected-pet db)))

(re-frame/reg-sub
 :mode
 (fn [db]
  (:mode db)))
