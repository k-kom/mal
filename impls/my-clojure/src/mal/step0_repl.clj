(ns mal.step0-repl
  (:gen-class))

(defn READ [x] x)

(defn EVAL [x] x)

(defn PRINT [x] x)

(defn rep
  [x]
  (-> x
      READ
      EVAL
      PRINT))

(defn rep-loop []
  ;; you need to flush to print strings (not println)
  (print "user> ")
  (flush)
  (when-let [s (rep (read-line))]
    (println s)
    (recur)))

(defn -main
  [& args]
  (rep-loop))

;; TODO: repl history