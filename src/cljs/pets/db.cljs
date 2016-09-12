(ns pets.db)

(def default-db
  {:title "Clojure Del 1. Test App"
   :mode :view
   :selected-pet 0
   :pets [{:id 1
           :name "Catmobiles"
           :url "http://ichef.bbci.co.uk/news/1024/cpsprodpb/15664/production/_86825678_cats9.png"}
          {:id 2
           :name "Ninjacat"
           :url "http://static.boredpanda.com/blog/wp-content/uploads/2015/01/ninja-cat-hiding-funny-105__605.jpg"}
          {:id 3
           :name "Supercat!"
           :url "http://i.embed.ly/1/display/resize?key=1e6a1a1efdb011df84894040444cdc60&url=http%3A%2F%2Fpbs.twimg.com%2Fmedia%2FBnr8xQqIQAAa1AJ.jpg"}
          {:id 4
           :name "Businesscat"
           :url "http://d39kbiy71leyho.cloudfront.net/wp-content/uploads/2016/05/09170020/cats-politics-TN.jpg"}
          {:id 5
           :name "Mariocat!"
           :url "http://g02.a.alicdn.com/kf/HTB1kfeaHpXXXXcLaXXXq6xXFXXXX/18cm-Yellow-font-b-cat-b-font-font-b-Mario-b-font-font-b-Plush-b.jpg"}]})

(defn select-next-pet
 [state current-index]
 (assoc state :selected-pet (inc current-index)))

(defn set-name
 [state new-name]
 (let [new-pet (assoc (nth (:pets state) (:selected-pet state)) :name new-name)]
   (assoc state :pets
    (map
     (fn [{:keys [id] :as pet}]
      (if (= id (:id new-pet)) new-pet pet))
     (:pets state)))))


(defn set-mode
 [state mode]
 (assoc state :mode mode))
