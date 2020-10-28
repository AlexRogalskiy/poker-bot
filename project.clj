(defproject openimagecv-poker-card "0.1.0-SNAPSHOT"
  :java-source-paths ["java"]
  :main io.brainshells.api.openimagecv.processor.ApplicationBootstrap
  :plugins [[lein-auto "0.1.3"]]
  :auto {:default {:file-pattern #"\.(java)$"}}
  :repositories [["jitpack" "https://jitpack.io"]]
  :dependencies [[org.clojure/clojure "1.10.0"]])
