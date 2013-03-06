{:dev
 {:dependencies [[com.palletops/pallet "0.8.0-SNAPSHOT" :classifier "tests"]
                 [org.cloudhoist/ssh-transport "0.3.3-SNAPSHOT"]
                 [com.palletops/java-crate "0.8.0-beta.1"]
                 [com.palletops/crates "0.8.0-SNAPSHOT"]
                 [riemann-clojure-client "0.0.3"]
                 [ch.qos.logback/logback-classic "1.0.9"]]
  :aliases {"live-test-up"
            ["pallet" "up" "--phases" "install,configure,test"]
            "live-test-down" ["pallet" "down"]
            "live-test" ["do" "live-test-up," "live-test-down"]}
  :test-selectors {:default (complement :live-test)
                   :live-test :live-test
                   :all (constantly true)}
  :repositories {"boundary-site" "http://maven.boundary.com/artifactory/repo"}}
 :doc {:dependencies [[com.palletops/pallet-codox "0.1.0-SNAPSHOT"]]
       :plugins [[codox/codox.leiningen "0.6.4"]
                 [lein-marginalia "0.7.1"]]
       :codox {:writer codox-md.writer/write-docs
               :output-dir "doc/0.8/api"
               :src-dir-uri "https://github.com/pallet/java-crate/blob/develop"
               :src-linenum-anchor-prefix "L"}
       :aliases {"marg" ["marg" "-d" "doc/0.8/annotated"]
                 "codox" ["doc"]
                 "doc" ["do" "codox," "marg"]}
       }
 :pallet {:jvm-opts ["-Djna.nosys=true"]}}