(ns pets.views
    (:require [re-frame.core :as re-frame]))

(defn main-panel []
    (fn []
     (let [title (re-frame/subscribe [:title])
           pets (re-frame/subscribe [:pets])
           selected-pet (re-frame/subscribe [:selected-pet])
           mode (re-frame/subscribe [:mode])
           current-pet (nth (cycle @pets) @selected-pet)]
      [:div.container
       [:row
         [:div.col-xs-12.text-xs-center
          [:h1
           @title]]

         [:div.col-xs-12.text-xs-center
          (if (not (nil? @selected-pet))
           [:div.col-xs-12
            (case @mode
             :edit
             [:div.col-xs-6.offset-xs-3
              [:div.form-inline
               [:div.form-group
                [:input.form-control
                 {:placeholder "Write the title here.."
                  :default-value (:name current-pet)
                  :on-input #(re-frame/dispatch [:update-name
                                                  (-> % .-target .-value)])}]]
               [:div.btn.btn-secondary
                {:on-click #(re-frame/dispatch [:set-mode :show])}
                "X"]]]
             [:h2.text-xs-center
              {:on-click #(re-frame/dispatch [:set-mode :edit])}
              (:name current-pet)])
            [:hr]
            [:img {:src (:url current-pet)
                   :height 600
                   :style {:border "3px solid #fff"
                           :box-shadow "0 2px 3px rgba(0,0,0,.2)"}}]
            [:div.col-xs-12.text-xs-center
             [:hr]
             [:div.btn.btn-success
              {:on-click #(re-frame/dispatch [:select-next-pet @selected-pet])}
              "NEXT CAT!"]]]
           [:div.col-xs-12
            [:h2 "No more cats :("]])
          [:div.col-xs-12.text-xs-left {:style {:margin-top 50}}
           @re-frame.db/app-db]]]])))
