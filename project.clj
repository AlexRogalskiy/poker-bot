(defproject poker-card-opencv "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :main io.brainshells.api.image.HelloCv
  :plugins [[lein-auto "0.1.3"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["vendredi" "https://repository.hellonico.info/repository/hellonico/"]
                 ["jitpack" "https://jitpack.io"]]
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [origami/origami "4.5.0"]
                 [origami/filters "1.11"]
                 [origami/sources "1.0.1"]])
